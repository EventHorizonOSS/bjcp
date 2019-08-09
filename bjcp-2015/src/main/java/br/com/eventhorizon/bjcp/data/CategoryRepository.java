package br.com.eventhorizon.bjcp.data;

import br.com.eventhorizon.bjcp.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
