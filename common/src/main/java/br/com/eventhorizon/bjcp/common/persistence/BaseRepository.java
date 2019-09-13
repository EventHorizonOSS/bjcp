package br.com.eventhorizon.bjcp.common.persistence;

import br.com.eventhorizon.bjcp.common.domain.BaseModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel, ID extends Serializable> extends MongoRepository<T, ID> {

  <S extends T> S save(S obj);

}
