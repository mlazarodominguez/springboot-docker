package com.salesianostriana.dam.proyectorepaso.repositorios;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.salesianostriana.dam.proyectorepaso.model.Reserva;

@DataJpaTest
@ActiveProfiles("test")
public class MiguelReservaRepositorioTest {
	
	@Autowired
	private ReservaRepositorio reservaRepositorio;
	
	@Test
	public void testFindBuyUsuarioId() {
		List<Reserva> resultado = reservaRepositorio.findByUsuarioId(1);
		assertThat(resultado).isEmpty();
	}
	
}
