package com.douglas.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douglas.cursomc.domain.Categoria;
import com.douglas.cursomc.domain.Cidade;
import com.douglas.cursomc.domain.Cliente;
import com.douglas.cursomc.domain.Endereco;
import com.douglas.cursomc.domain.Estado;
import com.douglas.cursomc.domain.Pagamento;
import com.douglas.cursomc.domain.PagamentoComBoleto;
import com.douglas.cursomc.domain.PagamentoComCartao;
import com.douglas.cursomc.domain.Pedido;
import com.douglas.cursomc.domain.Produto;
import com.douglas.cursomc.domain.enuns.EstadoPagamento;
import com.douglas.cursomc.domain.enuns.TipoCliente;
import com.douglas.cursomc.repository.CategoriaRepository;
import com.douglas.cursomc.repository.CidadeRepository;
import com.douglas.cursomc.repository.ClienteRepository;
import com.douglas.cursomc.repository.EnderecoRepository;
import com.douglas.cursomc.repository.EstadoRepository;
import com.douglas.cursomc.repository.PagamentoRepository;
import com.douglas.cursomc.repository.PedidoRepository;
import com.douglas.cursomc.repository.ProdutoRepository;

//token git: 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
// 
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepoitory;
	
	@Autowired
	private EnderecoRepository enderecoRepoitory;
	
	@Autowired
	private ClienteRepository clienteRepoitory;

	@Autowired
	private PedidoRepository pedidoRepoitory;
	
	@Autowired
	private PagamentoRepository pagamentoRepoitory;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador" , 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "S??o Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "S??o Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepoitory.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "111.111.111-11", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12345678", "87654321"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto 303", "Jardim", "14810000", cli1, c1);
		Endereco e2 = new Endereco(null, "Av. Matos", "105", "sala 80", "centro", "14806000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepoitory.saveAll(Arrays.asList(cli1));
		enderecoRepoitory.saveAll(Arrays.asList(e1,e2));
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepoitory.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepoitory.saveAll(Arrays.asList(pagto1, pagto2));
		
	}

}
