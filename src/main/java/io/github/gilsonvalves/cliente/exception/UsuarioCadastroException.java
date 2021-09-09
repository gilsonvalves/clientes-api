package io.github.gilsonvalves.cliente.exception;

public class UsuarioCadastroException extends RuntimeException {
	 public UsuarioCadastroException( String login ){
	        super("Usuário já cadastrado para o login " + login);
	    }

}
