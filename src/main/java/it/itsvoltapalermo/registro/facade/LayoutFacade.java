package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiLayoutRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaLayoutRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.LayoutResponseDTO;
import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.mapper.LayoutMapper;
import it.itsvoltapalermo.registro.model.Layout;
import it.itsvoltapalermo.registro.service.def.LayoutService;
import it.itsvoltapalermo.registro.utilities.FileManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LayoutFacade {

    private final LayoutService lService;
    private final LayoutMapper lMapper;
    private final FileManagerService fService;

    @Value("${layouts.path}")
    private String layoutFolder;

    public void aggiungiLayout(AggiungiLayoutRequestDTO request) {
        if (!("application/vnd.ms-excel".equalsIgnoreCase(request.getFile().getContentType()) ||
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equalsIgnoreCase(request.getFile().getContentType()))) {
            throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "file", "Il file deve essere un foglio di calcolo Excel");
        }

        Layout l = lMapper.fromAggiungiLayoutRequestDTO(request);
        l.setDataCreazione(LocalDateTime.now());
        l.setPath(fService.uploadFile(layoutFolder, request.getFile()));

        lService.aggiungiLayout(l);
    }

    public void modificaLayout(ModificaLayoutRequestDTO request){
        Layout l = lService.getLayout(request.getId());
        l.setNome(request.getNome());
        l.setDescrizione(request.getDescrizione());

        lService.modificaLayout(l);
    }

    public void eliminaLayout(long id){
        Layout l = lService.getLayout(id);
        fService.deleteFile(layoutFolder + File.separator + l.getPath());
        lService.eliminaLayout(id);
    }

    public LayoutResponseDTO getLayout(long id){
        return lMapper.toLayoutResponseDTO(lService.getLayout(id));
    }

    public List<LayoutResponseDTO> getLayouts(){
        return lMapper.toLayoutResponseDTOList(lService.getLayouts());
    }

    public ByteArrayResource downloadLayout(long id){
        Layout l = lService.getLayout(id);
        byte[] layout = fService.downloadFile(layoutFolder + File.separator + l.getPath());
        return new ByteArrayResource(layout);
    }
}
