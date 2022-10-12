package com.wsousa.products.controller;

import com.wsousa.products.client.avaliacoes.AvaliacaoClient;
import com.wsousa.products.client.avaliacoes.AvaliacaoModel;
import com.wsousa.products.domain.Produto;
import com.wsousa.products.domain.ProdutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private final ProdutoRepository produtos;
	private final AvaliacaoClient avaliacoes;

	public ProductController(ProdutoRepository produtos, AvaliacaoClient avaliacoes) {
		this.produtos = produtos;
		this.avaliacoes = avaliacoes;
	}

	@GetMapping
	public List<ProductModel> buscarTodos() {
		return produtos.getAll()
				.stream()
				.map(this::converterProdutoParaModelo)
				.collect(Collectors.toList());
	}

	@GetMapping("/{produtoId}")
	public ProductModel buscarPorId(@PathVariable Long produtoId) {
		return produtos.getOne(produtoId)
				.map(this::converterProdutoParaModeloComAvaliacao)
				.orElseThrow(ResourceNotFoundException::new);
	}
	
	private ProductModel converterProdutoParaModelo(Produto produto) {
		return ProductModel.of(produto);
	}
	
	private ProductModel converterProdutoParaModeloComAvaliacao(Produto produto) {
		return ProductModel.of(produto, buscarAvaliacaoDoProduto(produto.getId()));
	}

	private List<AvaliacaoModel> buscarAvaliacaoDoProduto(Long productId) {
		return avaliacoes.buscarTodosPorProduto(productId);
	}
}
