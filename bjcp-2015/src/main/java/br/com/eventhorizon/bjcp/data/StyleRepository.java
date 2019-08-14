package br.com.eventhorizon.bjcp.data;

import br.com.eventhorizon.bjcp.model.Style;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends MongoRepository<Style, String> {
}
