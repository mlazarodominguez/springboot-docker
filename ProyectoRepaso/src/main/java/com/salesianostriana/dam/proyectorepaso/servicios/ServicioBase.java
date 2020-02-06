package com.salesianostriana.dam.proyectorepaso.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
/**
 * @author Daniel Santano Fernández
 * Servicio base
 */
@RequiredArgsConstructor
public abstract class ServicioBase<T, ID, R extends JpaRepository<T, ID>> {

	//@Autowired
	protected final R repositorio;
	
	public T save(T t) {
		return repositorio.save(t);
	}
	
	public T findById(ID id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public List<T> findAll() {
		return repositorio.findAll();
	}
	
	public T edit(T t) {
		return repositorio.save(t);
	}
	
	public void delete(T t) {
		repositorio.delete(t);
	}
	
	public void deleteById(ID id) {
		repositorio.deleteById(id);
	}
	
	
}
