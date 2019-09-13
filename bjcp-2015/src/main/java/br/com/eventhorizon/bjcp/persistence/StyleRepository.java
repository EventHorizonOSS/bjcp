package br.com.eventhorizon.bjcp.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends MongoRepository<PersistedStyle, String> {
}
