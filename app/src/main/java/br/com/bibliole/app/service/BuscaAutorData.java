package br.com.bibliole.app.service;

import br.com.bibliole.app.api.ConsumoBibliotecaApi;
import br.com.bibliole.app.model.Livro;
import br.com.bibliole.app.model.Pessoa;
import br.com.bibliole.app.util.GerenciamentoEntrada;

import java.util.*;

public class BuscaAutorData extends GerenciamentoEntrada {
    Scanner scanner = new Scanner(System.in);
    final String ENDERECO = "https://gutendex.com/books/";
    ConsumoBibliotecaApi consumo = new ConsumoBibliotecaApi();
    //GerenciamentoEntrada entrada = new GerenciamentoEntrada();
    List<Livro> livros;

    public void buscarAutoresEntreAnos() {
        try {
            System.out.println("Digite o ano de busca inicial: ");
            int anoInicio = receberInteiro(scanner);
            System.out.println("Digite o ano de busca final: ");
            int anoFinal = receberInteiro(scanner);

            String url = ENDERECO + "?author_year_start=" + anoInicio + "&author_year_end=" + anoFinal;

            livros = consumo.buscarLivros(url).resultado();
            listarAutoresData();
            concluir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao buscar os autores.");
            e.printStackTrace();
        }
    }

    public void buscarAutoresAntes() {
        try {
            System.out.println("Você quer buscar autores(as) antes de qual ano? ");
            int anoFinal = receberInteiro(scanner);
            String url = ENDERECO + "?author_year_end=" + anoFinal;

            livros = consumo.buscarLivros(url).resultado();
            listarAutoresData();
            concluir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao buscar os autores.");
            e.printStackTrace();
        }
    }

    public void buscarAutoresApos() {
        try {
            System.out.println("Você quer buscar autores(as) a partir de qual ano? ");
            int anoInicio = receberInteiro(scanner);
            String url = ENDERECO + "?author_year_start=" + anoInicio;

            livros = consumo.buscarLivros(url).resultado();
            listarAutoresData();
            concluir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao buscar os autores.");
            e.printStackTrace();
        }
    }

    private void listarAutoresData() {
        // Extrair nomes de autores únicos dos livros
        Set<Pessoa> autores = new HashSet<>();
        for (Livro livro : livros) {
            autores.addAll(livro.autores());
        }

        // Ordenar os autores em ordem alfabética
        List<Pessoa> autoresOrdenados = new ArrayList<>(autores);
        autoresOrdenados.sort(Comparator.comparing(Pessoa::nome));

        // Imprimir os autores numerados e organizados alfabeticamente
        if (autoresOrdenados.isEmpty()) {
            System.out.println("Nenhum autor encontrado no intervalo definido. Tente novamente!");
            buscarAutoresApos();
        } else {
            System.out.println("Autores encontrados no intervalo definido:");
            int contador = 1;
            for (Pessoa autor : autoresOrdenados) {
                System.out.printf("Autor %d: %s. Nasceu em %d e Faleceu no ano de %d)%n",
                        contador, autor.nome(), autor.anoNascimento(), autor.anoObito());
                contador++;
            }
        }
    }
}