package com.alan.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alan.bookstore.domain.Livro;
import com.alan.bookstore.repositories.LivroRepository;
import com.alan.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

}
