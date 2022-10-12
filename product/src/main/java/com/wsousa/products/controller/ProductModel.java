package com.wsousa.products.controller;

import com.wsousa.products.client.avaliacoes.AvaliacaoModel;
import com.wsousa.products.domain.Produto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ProductModel {

	public Long id;
	public String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public List<AvaliacaoModel> avaliacoes;

	public ProductModel() {

	}

	public ProductModel(Long id, String nome) {
		this.id = id;
		this.name = nome;
	}

	public ProductModel(Long id, String nome, List<AvaliacaoModel> avaliacoes) {
		this.id = id;
		this.name = nome;
		this.avaliacoes = avaliacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AvaliacaoModel> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoModel> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public static ProductModel of(Produto produto) {
		return new ProductModel(
				produto.getId(),
				produto.getNome()
		);
	}
	
	public static ProductModel of(Produto produto, List<AvaliacaoModel> avaliacoes) {
		return new ProductModel(
				produto.getId(),
				produto.getNome(),
				avaliacoes
		);
	}
	
}
