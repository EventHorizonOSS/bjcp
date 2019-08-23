package br.com.eventhorizon.bjcp.common.model;

public class Field {

  public static final Field ID = new Field("id", false, true);

  public static final Field CREATED_AT = new Field("createdAt", false, true);

  public static final Field UPDATED_AT = new Field("updatedAt", false, true);

  protected String name;

  protected boolean required;

  protected boolean readOnly;

  protected Field(String name, boolean required, boolean readOnly) {
    this.name = name;
    this.required = required;
    this.readOnly = readOnly;
  }

  public String getName() {
    return name;
  }

  public boolean isRequired() {
    return required;
  }

  public boolean isReadOnly() {
    return readOnly;
  }

}
