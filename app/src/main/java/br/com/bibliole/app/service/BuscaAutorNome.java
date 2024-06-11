package br.com.bibliole.app.service;

import br.com.bibliole.app.api.ConsumoBibliotecaApi;
import br.com.bibliole.app.model.Livro;
import br.com.bibliole.app.model.Pessoa;
import br.com.bibliole.app.util.GerenciamentoEntrada;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;

public class BuscaAutorNome extends GerenciamentoEntrada {
    Scanner scanner = new Scanner(System.in);
    final String ENDERECO = "https://gutendex.com/books/";
    ConsumoBibliotecaApi consumo = new ConsumoBibliotecaApi();

    public void buscarAutor() throws Exception {
        try {
            System.out.println("Digite o nome do(a) autor(a): ");
            var nomeBusca = scanner.nextLine();
            var respostaJson = consumo.buscarLivros(ENDERECO + "?search=" + nomeBusca.replace(" ", "%20"));

            List<Livro> livrosFiltradosAutor = respostaJson.resultado().stream()
                    .filter(livro -> !livro.autores().isEmpty() &&
                            livro.autores().stream()
                                    .anyMatch(autor -> autor.nome().toLowerCase().contains(nomeBusca.toLowerCase())))
                    .distinct()
                    .sorted(Comparator.comparing(livro -> livro.autores().get(0).nome()))
                    .limit(5) // manter temporariamente
                    .collect(Collectors.toList());

            if (livrosFiltradosAutor.isEmpty()) {
                System.out.println("Nenhum livro encontrado para este(a) autor(a).");
            } else {
                Set<String> autoresSet = new HashSet<>();
                for (Livro livro : livrosFiltradosAutor) {
                    livro.autores().stream()
                            .map(Pessoa::nome)
                            .forEach(autoresSet::add);
                }
                // Ordenar os autores em ordem alfabética
                List<String> autoresOrdenados = autoresSet.stream()
                        .sorted()
                        .collect(Collectors.toList());
                // Imprimir os autores coletados em uma lista numérica e ordenados alfabeticamente
                int contador = 1;
                for (String autor : autoresOrdenados) {
                    System.out.println("Autor(a) " + contador + ": " + autor);
                    contador++;
                }
            }
            concluir();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
