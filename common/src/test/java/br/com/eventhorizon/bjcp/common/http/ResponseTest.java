package br.com.eventhorizon.bjcp.common.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ResponseTest {

  @Test
  public void test() throws JsonProcessingException {
    // given
    String data = "data";
    Response response = Response.Builder
        .create(ResponseStatus.SUCCESS)
        .data(data)
        .build();

    // when
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(response);

    // then
    assertTrue(jsonString.contains("\"status\":\"SUCCESS\""));
    assertTrue(jsonString.contains("\"data\":\"" + data + "\""));
  }
}
