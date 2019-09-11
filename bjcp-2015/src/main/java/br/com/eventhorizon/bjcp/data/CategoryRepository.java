package br.com.eventhorizon.bjcp.data;

import br.com.eventhorizon.bjcp.common.data.BaseRepository;
import br.com.eventhorizon.bjcp.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, String> {
}
