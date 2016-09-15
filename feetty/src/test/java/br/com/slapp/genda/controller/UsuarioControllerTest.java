package br.com.slapp.genda.controller;

import org.junit.Test;

import junit.framework.TestCase;

public class UsuarioControllerTest extends TestCase {
	@Test 
	public void testListaUsuario(){
		assertNotNull(new UsuarioController().getUsuarioList());
	}
	
}
