package app.prediccion.predicciondatos.controllers;

import app.prediccion.predicciondatos.models.Attacks;
import app.prediccion.predicciondatos.services.CSVService;
import app.prediccion.predicciondatos.services.IAttacksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/attacks")
public class AttacksController {

    private final IAttacksService attacksService;
    private final CSVService fileService;

    public AttacksController(IAttacksService attacksService, CSVService fileService) {
        this.attacksService = attacksService;
        this.fileService = fileService;
    }

    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Attacks> listAttacks(){
        return attacksService.attacksLists();
    }

    @GetMapping("/download")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Resource> getFile() {
        String filename = "attacks.csv";
        InputStreamResource file = new InputStreamResource(fileService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }
}
