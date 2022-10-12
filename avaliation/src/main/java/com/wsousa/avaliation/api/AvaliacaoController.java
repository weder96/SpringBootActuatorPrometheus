package com.wsousa.avaliation.api;

import com.wsousa.avaliation.domain.AvaliacaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
	
	private final AvaliacaoRepository avaliacoes;

	public AvaliacaoController(AvaliacaoRepository avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	@GetMapping
	public List<AvaliacaoModel> buscarPorProduto(@RequestParam Long produtoId) {
		return avaliacoes.getAll()
				.stream()
				.filter(avaliacao -> avaliacao.getProdutoId().equals(produtoId))
				.map(AvaliacaoModel::of)
				.collect(Collectors.toList());
	}
}
