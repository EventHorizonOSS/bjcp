package br.com.eventhorizon.bjcp.persistence;

import br.com.eventhorizon.bjcp.common.persistence.BaseRepository;
import br.com.eventhorizon.bjcp.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, String> {
}
