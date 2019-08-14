package br.com.eventhorizon.bjcp.services;

public class ResourceAlreadyExist extends Exception {

  private String resourceId;

  public ResourceAlreadyExist(String resourceId) {
    super("Resource with ID '" + resourceId + "' already exist");
    this.resourceId = resourceId;
  }
}
