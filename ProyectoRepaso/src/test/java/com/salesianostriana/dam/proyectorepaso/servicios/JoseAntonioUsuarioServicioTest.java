package com.salesianostriana.dam.proyectorepaso.servicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.salesianostriana.dam.proyectorepaso.model.Usuario;
import com.salesianostriana.dam.proyectorepaso.repositorios.UsuarioRepositorio;

import lombok.extern.java.Log;

@Log
@ExtendWith(MockitoExtension.class)
public class JoseAntonioUsuarioServicioTest {
	
	@InjectMocks
	private UsuarioServicio usuarioServicio;

	@Mock
	BCryptPasswordEncoder passwordEncoder;

	@Mock
	private UsuarioRepositorio uRepositorio;

	@Mock
	private Usuario user;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void passwordVacioNoCoincideConPasswordCifrada() {
		when(passwordEncoder.encode("password")).thenReturn("1248787tg2ehognsbhyu");
		when(passwordEncoder.encode("")).thenReturn("");
		String result1 = usuarioServicio.cifrarPassword("password");
		String result2 = usuarioServicio.cifrarPassword("");
		assertNotEquals(result1, result2);
	}

	@Test
	public void passwordCifradaCoincideConPasswordCifrada() {
		when(passwordEncoder.encode("password")).thenReturn("1248787tg2ehognsbhyu");
		String expected = passwordEncoder.encode("password");
		String result2 = usuarioServicio.cifrarPassword("password");
		assertEquals(expected, result2);
	}
	
//	@Test
//	public void validarRegistroUsuario() {
//		Usuario userMock=new Usuario(1,"Pepe","este@no.es","pass",false,false,true,false,null);
//		usuarioServicio.activarUsuario(userMock);
//		
//		assertThat(userMock.isActivo()).isTrue();
//	}
//	
//	@Test
//	public void desactivarUsuario() {
//		Usuario userMock=new Usuario(1,"Pepe","este@no.es","pass",false,false,true,false,null);
//		usuarioServicio.desactivarUsuario(userMock.getId());
//		
//		assertThat(userMock.isActivo()).isFalse();
//	}
//	
}
