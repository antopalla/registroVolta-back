package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiSchedaRequestDTO;
import it.itsvoltapalermo.registro.model.SchedaValutazione;
import org.springframework.stereotype.Component;

@Component
public class SchedaValutazioneMapper {

    public SchedaValutazione fromAggiungiSchedaRequestDTO(AggiungiSchedaRequestDTO dto) {
        SchedaValutazione s = new SchedaValutazione();
        s.setPathScheda(dto.getPathScheda());
        s.setPathFirma(dto.getPathFirma());

        s.setLivelloPreparazioneIngresso(dto.getLivelloPreparazioneIngresso());
        s.setSocializzazione(dto.getSocializzazione());
        s.setComunicazione(dto.getComunicazione());
        s.setImpegno(dto.getImpegno());
        s.setMotivazione(dto.getMotivazione());
        s.setRispettoRegole(dto.getRispettoRegole());
        s.setCollaborazioneTutor(dto.getCollaborazioneTutor());
        s.setCollaborazioneDocenti(dto.getCollaborazioneDocenti());
        s.setCollaborazioneColleghi(dto.getCollaborazioneColleghi());
        s.setIntegrazioneGruppo(dto.getIntegrazioneGruppo());
        s.setConoscenzaConcettiTecnici(dto.getConoscenzaConcettiTecnici());
        s.setConoscenzaConcettiTeorici(dto.getConoscenzaConcettiTeorici());
        s.setUsoLinguaggioTerminologia(dto.getUsoLinguaggioTerminologia());
        s.setCapacitaCollegamentoOrganizzazione(dto.getCapacitaCollegamentoOrganizzazione());
        s.setLivelloPreparazioneUscita(dto.getLivelloPreparazioneUscita());

        s.setGiudizioComplessivo(dto.getGiudizioComplessivo());

        return s;
    }
}
