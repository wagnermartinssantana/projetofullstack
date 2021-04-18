package com.wagner.projetofull;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wagner.projetofull.domain.Categoria;
import com.wagner.projetofull.domain.Cidade;
import com.wagner.projetofull.domain.Cliente;
import com.wagner.projetofull.domain.Endereco;
import com.wagner.projetofull.domain.Estado;
import com.wagner.projetofull.domain.Pagamento;
import com.wagner.projetofull.domain.PagamentoComBoleto;
import com.wagner.projetofull.domain.PagamentoComCartao;
import com.wagner.projetofull.domain.Pedido;
import com.wagner.projetofull.domain.Produto;
//import com.wagner.projetofull.domain.enums.TipoCliente;
import com.wagner.projetofull.repositories.CategoriaRepository;
import com.wagner.projetofull.repositories.CidadeRepository;
import com.wagner.projetofull.repositories.ClienteRepository;
import com.wagner.projetofull.repositories.EnderecoRepository;
import com.wagner.projetofull.repositories.EstadoRepository;
import com.wagner.projetofull.repositories.PagamentoRepository;
import com.wagner.projetofull.repositories.PedidoRepository;
import com.wagner.projetofull.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetofullApplication  implements CommandLineRunner {
	
	
	// OPÇÃO PARA GERAR O NOME DAS CATEGORIAS TODA VEZ QUE RODAR O BANCO DE DADOS,POREM O BANCO ELE É SALVO ENTAO NÃO SERVE PARA A  SITUAÇÃO
	
	 
	
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	

	
	public static void main(String[] args) {
		SpringApplication.run(ProjetofullApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = new Categoria (null,"Informática");
		Categoria cat2 = new Categoria (null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null,"Impressora", 800.00);
		Produto p3 = new Produto(null,"Mouse", 80.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1 , cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		Estado est1 = new Estado (null,"Minas Gerais");
		Estado est2 = new Estado (null,"São Paulo");
		
		Cidade c1 = new Cidade (null,"Uberlândia" , est1);
		Cidade c2 = new Cidade (null,"São Paulo" , est2);
		Cidade c3 = new Cidade (null,"Campinas" , est2);

				
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		

		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva","maria@gmail.com","01952834652","PESSOA FISICA");
		
		cli1.getTelefones().addAll(Arrays.asList("975464151" , "975467474"));
		
		Endereco e1 = new Endereco(null, "Rua flores", "40", "Apt 102", "Jardim", "386656489", cli1, c1);

		Endereco e2 = new Endereco(null, "Rua matos", "40", "Apt 102", "São Paulo", "386656489", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"), cli1,e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:32"), cli1,e2);
		
		/* LEmbrar de trocar caso deseje usar os Enuns*/ 
		Pagamento pagto1 = new PagamentoComCartao(null,"QUITADO",ped1,6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,"Pendente",ped2,sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
				
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
	}
	
	
}
