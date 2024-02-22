package br.com.gabriel.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException {
  public UserFoundException() {
    super("User arleady exists.");
  }
}
