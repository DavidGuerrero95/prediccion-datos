package app.prediccion.predicciondatos.repository;

import app.prediccion.predicciondatos.models.Attacks;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttacksRepository extends MongoRepository<Attacks, String> {
}
