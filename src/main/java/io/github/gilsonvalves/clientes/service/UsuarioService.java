package io.github.gilsonvalves.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.gilsonvalves.cliente.exception.UsuarioCadastroException;
import io.github.gilsonvalves.model.entity.Usuario;
import io.github.gilsonvalves.model.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	
	private final UsuarioRepository rep;
	
	@Autowired
	public UsuarioService(UsuarioRepository rep) {
		this.rep = rep;
	}
	
	public Usuario salvar(Usuario usuario) {
	/*	 boolean exists = rep.existsByUsername(usuario.getUsername());
		 if(exists) {
			 throw new UsuarioCadastroException(usuario.getUsername());
		 }*/
		return rep.save(usuario);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = rep.findByUsername(username)
							.orElseThrow(() -> new  UsernameNotFoundException(""));
		return User
				.builder()
				.username(usuario.getUsername())
				.password(usuario.getPassword())
				.roles("USER")
				.build();
	}

}
