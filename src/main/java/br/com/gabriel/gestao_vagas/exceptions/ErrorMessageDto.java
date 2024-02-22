package br.com.gabriel.gestao_vagas.exceptions;

public class ErrorMessageDto {
  private String message;
  private String field;

  public ErrorMessageDto(String message, String field) {
    this.message = message;
    this.field = field;
  }

  public String getField() {
    return field;
  }

  public String getMessage() {
    return message;
  }

  public void setField(String field) {
    this.field = field;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
