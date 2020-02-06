package com.salesianostriana.dam.proyectorepaso.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.salesianostriana.dam.proyectorepaso.model.Espacio;
import com.salesianostriana.dam.proyectorepaso.repositorios.EspacioRepositorio;

/**
 * @author Daniel Santano Fernández Servicio de Espacio
 */

@Service
public class EspacioServicio extends ServicioBase<Espacio, Long, EspacioRepositorio>{

	/**
	 * Atributos de la clase
	 */
		EspacioRepositorio espacioRepositorio;
	
		/**
		 * Constructor de la clase
		 * @param espacioRepositorio
		 */
	    public EspacioServicio(EspacioRepositorio espacioRepositorio) {
			super(espacioRepositorio);
		}

	    /**
		 * Metodo que devuelve todos los espacios para poder ser paginados
		 * @param pageable hace que findall sea paginable
		 * @return lista paginable
		 */
		public Page<Espacio> findAllPageable(Pageable pageable) {
	        return espacioRepositorio.findAll(pageable);
	    }
		
}
