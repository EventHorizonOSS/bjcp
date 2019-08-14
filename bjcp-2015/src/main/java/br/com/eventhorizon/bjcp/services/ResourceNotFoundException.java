package br.com.eventhorizon.bjcp.services;

public class ResourceNotFoundException extends Exception {

  private String resourceId;

  public ResourceNotFoundException(String resourceId) {
    super("Resource with ID '" + resourceId + "' not found");
    this.resourceId = resourceId;
  }

  public String getResourceId() {
    return resourceId;
  }

}
