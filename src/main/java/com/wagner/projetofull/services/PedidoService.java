package com.wagner.projetofull.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wagner.projetofull.domain.Pedido;
import com.wagner.projetofull.repositories.PedidoRepository;
import com.wagner.projetofull.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
								"Objeto não encontrado! ID:" + id + ", Tipo: " + Pedido.class.getName()));
	}
	
}
