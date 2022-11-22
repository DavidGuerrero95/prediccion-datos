package app.prediccion.predicciondatos.controllers;

import app.prediccion.predicciondatos.models.Attacks;
import app.prediccion.predicciondatos.repository.AttacksRepository;
import app.prediccion.predicciondatos.services.IAttacksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/attacks")
public class AttacksController {

    @Autowired
    IAttacksService attacksService;

    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Attacks> listAttacks(){
        return attacksService.attacksLists();
    }
}
