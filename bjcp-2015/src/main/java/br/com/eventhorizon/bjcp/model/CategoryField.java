package br.com.eventhorizon.bjcp.model;

import br.com.eventhorizon.bjcp.common.model.Field;

public class CategoryField extends Field {

  public static final CategoryField NAME = new CategoryField("name", true, false);

  public static final CategoryField DESCRIPTION = new CategoryField("description", true, false);

  protected CategoryField(String name, boolean required, boolean readOnly) {
    super(name, required, readOnly);
  }

}
