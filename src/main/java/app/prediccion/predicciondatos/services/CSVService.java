package app.prediccion.predicciondatos.services;

import app.prediccion.predicciondatos.helper.CSVHelper;
import app.prediccion.predicciondatos.models.Attacks;
import app.prediccion.predicciondatos.repository.AttacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    AttacksRepository attacksRepository;

    public ByteArrayInputStream load(){
        List<Attacks> attacks = attacksRepository.findAll();
        ByteArrayInputStream in = CSVHelper.attacksToCSV(attacks);
        return  in;
    }
}
