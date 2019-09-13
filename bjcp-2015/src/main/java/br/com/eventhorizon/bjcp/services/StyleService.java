package br.com.eventhorizon.bjcp.services;

import br.com.eventhorizon.bjcp.persistence.StyleRepository;
import br.com.eventhorizon.bjcp.domain.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StyleService {

  private StyleRepository styleRepository;

  @Autowired
  public StyleService(StyleRepository styleRepository) {
    this.styleRepository = styleRepository;
  }

  public List<Style> find() {
    return styleRepository.findAll();
  }

  public Style findById(String id) throws ResourceNotFoundException {
    Optional<Style> op = styleRepository.findById(id);
    if (op.isPresent()) {
      return op.get();
    }
    throw new ResourceNotFoundException(id);
  }

  public List<Style> find(Map<String, String> query) {
    // TODO
    return Collections.emptyList();
  }

}
