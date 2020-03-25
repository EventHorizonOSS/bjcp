package br.com.eventhorizon.bjcp.services;

public class ResourceAlreadyExistException extends Exception {

  private String resourceId;

  public ResourceAlreadyExistException(String resourceId) {
    super("Resource with ID '" + resourceId + "' already exist");
    this.resourceId = resourceId;
  }
}
