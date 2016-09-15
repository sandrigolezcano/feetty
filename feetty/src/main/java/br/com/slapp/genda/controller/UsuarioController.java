package br.com.slapp.genda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.slapp.genda.model.Usuario;
import br.com.slapp.genda.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getUsuarioList() {
		return new ResponseEntity<List<Usuario>>(usuarioRepository.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getUsuario(@PathVariable String id) {
		return new ResponseEntity<Usuario>(usuarioRepository.getById(Integer.parseInt(id)), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> geraUsuario(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(usuarioRepository.save(usuario), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Usuario> atualizaUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioDB = usuarioRepository.getById(usuario.getId());
		
		return new ResponseEntity<Usuario>(usuarioRepository.update(usuarioDB), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletaUsuario(HttpServletResponse response, @PathVariable String id) throws IOException {
		Usuario usuario = usuarioRepository.getById(Integer.parseInt(id));
		if(usuario == null) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), "Id invalido");
		} else {
			usuarioRepository.delete(usuario);
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		
	}

}
