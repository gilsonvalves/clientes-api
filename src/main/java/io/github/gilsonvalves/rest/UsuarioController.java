package io.github.gilsonvalves.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.gilsonvalves.cliente.exception.UsuarioCadastroException;
import io.github.gilsonvalves.clientes.service.UsuarioService;
import io.github.gilsonvalves.model.entity.Usuario;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService service;// = new UsuarioService();
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody @Validated Usuario usuario) {
		 try{
	            service.salvar(usuario);
	        }catch (UsuarioCadastroException e){
	            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage() );
	        }
		
	}
}
