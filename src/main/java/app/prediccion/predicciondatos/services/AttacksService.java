package app.prediccion.predicciondatos.services;

import app.prediccion.predicciondatos.models.Attacks;
import app.prediccion.predicciondatos.repository.AttacksRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AttacksService implements IAttacksService{

    private final AttacksRepository attacksRepository;

    public AttacksService(AttacksRepository attacksRepository) {
        this.attacksRepository = attacksRepository;
    }

    @Override
    public List<Attacks> attacksLists() {
        return attacksRepository.findAll();
    }
}
