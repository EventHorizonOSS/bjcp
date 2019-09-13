package br.com.eventhorizon.bjcp.persistence;

import br.com.eventhorizon.bjcp.domain.Style;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends MongoRepository<Style, String> {
}
