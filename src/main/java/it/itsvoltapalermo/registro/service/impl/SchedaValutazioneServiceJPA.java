package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.SchedaValutazione;
import it.itsvoltapalermo.registro.repository.SchedaValutazioneRepository;
import it.itsvoltapalermo.registro.service.def.SchedaValutazioneService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SchedaValutazioneServiceJPA implements SchedaValutazioneService {

    private final SchedaValutazioneRepository repo;

    @Override
    public void aggiungiSchedaValutazione(SchedaValutazione s) {
        if(s.getId() != 0) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(s);
    }

    @Override
    public void modificaSchedaValutazione(SchedaValutazione s) {
        if(s.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(s);
    }

    @Override
    public void eliminaSchedaValutazione(long id) {
        SchedaValutazione s = getSchedaValutazione(id);
        s.setDisattivato(true);
        repo.save(s);
    }

    @Override
    public SchedaValutazione getSchedaValutazione(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Scheda di valutazione non trovata"));
    }

    @Override
    public List<SchedaValutazione> getSchedeValutazione() {
        return repo.findAllByDisattivatoIsFalse();
    }


    // Scrittura su excel
    public byte[] generaExcel(SchedaValutazione scheda) {

        ClassPathResource layout = new ClassPathResource("layout/"+scheda.getLayout().getPath());

        try (InputStream is = layout.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);

            // Nome dello studente in B4 (riga 3, colonna 1)
            String nomeStudente = scheda.getStudente().getNome() + " " + scheda.getStudente().getCognome();
            valoreCella(sheet, 3, 1, nomeStudente);

            // Modulo in B5 (riga 4, colonna 1)
            valoreCella(sheet, 4, 1, scheda.getModulo().getDenominazione());

            // Docente in B6 (riga 5, colonna 1)
            String nomeDocente = scheda.getDocente().getNome() + " " + scheda.getDocente().getCognome();
            valoreCella(sheet, 5, 1, nomeDocente);

            // Valutazioni per le categorie
            // Le categorie sono attese nella colonna A. In base al rating (0..5) viene posta una "X" nella colonna:
            // 0 -> B (indice 1), 1 -> C (indice 2), …, 5 -> G (indice 6)
            impostaValutazione(sheet, "Livello di preparazione di ingresso", scheda.getLivelloPreparazioneIngresso());
            impostaValutazione(sheet, "Socializzazione", scheda.getSocializzazione());
            impostaValutazione(sheet, "Comunicazione", scheda.getComunicazione());
            impostaValutazione(sheet, "Impegno", scheda.getImpegno());
            impostaValutazione(sheet, "Motivazione", scheda.getMotivazione());
            impostaValutazione(sheet, "Rispetto delle regole", scheda.getRispettoRegole());
            impostaValutazione(sheet, "Collaborazione con il tutor", scheda.getCollaborazioneTutor());
            impostaValutazione(sheet, "Collaborazione con i docenti", scheda.getCollaborazioneDocenti());
            impostaValutazione(sheet, "Collaborazione con i colleghi", scheda.getCollaborazioneColleghi());
            impostaValutazione(sheet, "Integrazione nel gruppo", scheda.getIntegrazioneGruppo());
            impostaValutazione(sheet, "Comprensione dei concetti caratterizzanti la materia", scheda.getConoscenzaConcettiTecnici());
            impostaValutazione(sheet, "Conoscenza dei contenuti tecnici relativi alla materia", scheda.getConoscenzaConcettiTeorici());
            impostaValutazione(sheet, "Uso del linguaggio e della terminologia tecnica specifica", scheda.getUsoLinguaggioTerminologia());
            impostaValutazione(sheet, "Capacità di collegamento, organizzazione, rielaborazione critica e autonoma dei contenuti", scheda.getCapacitaCollegamentoOrganizzazione());
            impostaValutazione(sheet, "LIVELLO PREPARAZIONE DI USCITA", scheda.getLivelloPreparazioneUscita());

            // Giudizio in B26 (riga 25, colonna 1)
            valoreCella(sheet, 25, 1, scheda.getGiudizioComplessivo());

            // Data in A28 (riga 27, colonna 0)
            String dataOdierna = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            valoreCella(sheet, 27, 0, dataOdierna);

            // Firma in D28 (riga 27, colonna 3)
            inserisciImmagine(workbook, sheet, 27, 3, scheda.getPathFirma());

            // Converto il Workbook in byte[]
            byte[] output = workbookToByteArray(workbook);

            // Salvataggio su disco
            String fileName = "files/scheda_di_valutazione_compilata_" + System.currentTimeMillis() + ".xlsx";
            scheda.setPathScheda(fileName);
            repo.save(scheda);

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                fos.write(output);
            }
            return output;

        } catch (Exception e) {
            throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "excel", "Errore nella generazione del file Excel");
        }
    }

    /**
     * Imposta il valore (String) nella cella indicata da riga e colonna.
     */
    private void valoreCella(Sheet sheet, int rowIndex, int colIndex, String value) {
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }
        Cell cell = row.getCell(colIndex);
        if (cell == null) {
            cell = row.createCell(colIndex);
        }
        cell.setCellValue(value);
    }

    /**
     * Trova la riga in cui la cella della colonna A (indice 0) corrisponde al label.
     */
    private Row findRowByLabel(Sheet sheet, String label) {
        for (Row row : sheet) {
            Cell cell = row.getCell(0);
            if (cell != null && cell.getCellType() == CellType.STRING) {
                if (label.equals(cell.getStringCellValue().trim())) {
                    return row;
                }
            }
        }
        return null;
    }

    /**
     * Imposta la valutazione in base al rating (0..5) inserendo una "X" nella colonna corrispondente
     * (rating 0 → colonna B, 1 → C, …, 5 → G) nella riga in cui il label è in colonna A.
     */
    private void impostaValutazione(Sheet sheet, String label, int rating) {
        Row row = findRowByLabel(sheet, label);
        if (row != null) {
            int colIndex = rating + 1; // A è 0, quindi 0 → B (1), 1 → C (2), ecc.
            Cell cell = row.getCell(colIndex);
            if (cell == null) {
                cell = row.createCell(colIndex);
            }
            cell.setCellValue("X");
        }
    }

    /**
     * Inserisce un'immagine nella cella indicata da riga e colonna.
     */
    private void inserisciImmagine(Workbook workbook, Sheet sheet, int rowIndex, int colIndex, String path) {
        if (path != null) {
            ClassPathResource pathFirma = new ClassPathResource("firme/"+path);
            if (pathFirma.exists()) {
                Row rigaFirma = sheet.getRow(rowIndex);
                if (rigaFirma == null) {
                    rigaFirma = sheet.createRow(rowIndex);
                }
                Cell cellaFirma = rigaFirma.getCell(colIndex);
                if (cellaFirma == null) {
                    cellaFirma = rigaFirma.createCell(colIndex);
                }
                cellaFirma.setCellValue("");

                try {
                    byte[] signatureBytes = IOUtils.toByteArray(pathFirma.getInputStream());
                    int pictureIndex = workbook.addPicture(signatureBytes, Workbook.PICTURE_TYPE_PNG);

                    CreationHelper helper = workbook.getCreationHelper();
                    Drawing<?> drawing = sheet.createDrawingPatriarch();
                    ClientAnchor anchor = helper.createClientAnchor();
                    anchor.setCol1(colIndex);
                    anchor.setRow1(rowIndex);
                    Picture pict = drawing.createPicture(anchor, pictureIndex);
                    pict.resize();
                } catch (Exception e) {
                    throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "firma", "Errore nella lettura dell'immagine della firma");
                }
            }
        }
    }

    /**
     * Converte il Workbook in un array di byte.
     */
    private byte[] workbookToByteArray(Workbook workbook) throws Exception {
        try (java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream()) {
            workbook.write(bos);
            return bos.toByteArray();
        }
    }

}
