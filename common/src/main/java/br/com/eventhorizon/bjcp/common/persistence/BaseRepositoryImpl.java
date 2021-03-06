package br.com.eventhorizon.bjcp.common.persistence;

import br.com.eventhorizon.bjcp.common.util.IdUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class BaseRepositoryImpl<T extends BasePersistedModel, ID extends Serializable> extends SimpleMongoRepository<T, ID> implements
    BaseRepository<T, ID> {

  protected MongoOperations mongoOperations;

  public BaseRepositoryImpl(MongoEntityInformation<T, ID> metadata,
      MongoOperations mongoOperations) {
    super(metadata, mongoOperations);
    this.mongoOperations = mongoOperations;
  }

  @Transactional
  @Override
  public <S extends T> S save(S obj) {
    return update(obj);
  }

  @Override
  public <S extends T> S create(S obj) {
    String id = obj.getId();
    if (id == null || id.isEmpty()) {
      try {
        obj.setId(IdUtil.generateDocumentId());
      } catch (NoSuchAlgorithmException e) {
        // TODO
      }
    }
    Long now = new Date().getTime();
    obj.setCreatedAt(now);
    obj.setUpdatedAt(now);
    return super.insert(obj);
  }

  @Override
  public <S extends T> S update(S obj) {
    Long now = new Date().getTime();
    obj.setUpdatedAt(now);
    return (S) mongoOperations.save(obj);
  }

  @Override
  public <S extends T> S patch(S obj) {
    Long now = new Date().getTime();
    obj.setUpdatedAt(now);

    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Object> objectMap = objectMapper.convertValue(obj, Map.class);
    objectMap.values().removeIf(Objects::isNull);
    objectMap.keySet().removeIf(String::isEmpty);
    objectMap.keySet().removeIf(s -> s.equals("_id"));
    objectMap.keySet().removeIf(s -> s.equals("id"));
    objectMap.keySet().removeIf(s -> s.equals("createdAt"));

    Query query = new Query(new Criteria("_id").is(obj.getId()));
    Update update = new Update();
    objectMap.forEach(update::set);
    return (S) mongoOperations.findAndModify(query, update, obj.getClass());
  }

}
