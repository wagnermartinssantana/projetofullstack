package com.wagner.projetofull.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wagner.projetofull.domain.Cliente;
import com.wagner.projetofull.repositories.ClienteRepository;
import com.wagner.projetofull.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
								"Objeto não encontrado! ID:" + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}
