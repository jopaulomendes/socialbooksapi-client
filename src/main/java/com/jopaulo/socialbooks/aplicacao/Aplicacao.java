package com.jopaulo.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.jopaulo.socialbooks.client.LivroClient;
import com.jopaulo.socialbooks.domain.Livro;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		
		LivroClient cliente = new LivroClient("http://localhost:8080", "joao", "1234");
		
		List<Livro> listarLivros = cliente.listar();
		
		for (Livro livro : listarLivros) {
			System.out.println("Livro: " + livro.getNome());
			System.out.println("Editora: " + livro.getEditora());
			System.out.println("Ano de publicação: " + livro.getPublicacao());
			System.out.println("Resumo: " + livro.getResumo());
		}
		
		Livro livro = new Livro();
		livro.setNome("O Poder da Atração");
		livro.setEditora("Positivo");
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("05/05/1980"));
		livro.setResumo("O da atração");
		
		String localizacao = cliente.salvar(livro);
		
		System.out.println("URI do livro salvo: " + localizacao);
		
		Livro livroBuscado = cliente.buscar(localizacao);
		
		System.out.println("Livro buscado: " + livroBuscado.getNome());
	}
}
