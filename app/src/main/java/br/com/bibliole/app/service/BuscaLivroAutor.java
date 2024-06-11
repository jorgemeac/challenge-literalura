package br.com.bibliole.app.service;

import br.com.bibliole.app.api.ConsumoBibliotecaApi;
import br.com.bibliole.app.model.Livro;
import br.com.bibliole.app.model.Pessoa;
import br.com.bibliole.app.util.GerenciamentoEntrada;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuscaLivroAutor extends GerenciamentoEntrada {
    Scanner scanner = new Scanner(System.in);
    final String ENDERECO = "https://gutendex.com/books/";
    ConsumoBibliotecaApi consumo = new ConsumoBibliotecaApi();

    public void buscarTitulo() throws Exception {
        try {
            System.out.println("Digite o nome do(a) autor(a): ");
            var nomeBusca = scanner.nextLine();
            var respostaJson = consumo.buscarLivros(ENDERECO + "?search=" + nomeBusca.replace(" ", "%20"));

            List<Livro> livrosFiltradosAutor = respostaJson.resultado().stream()
                    .filter(livro -> !livro.autores().isEmpty() &&
                            livro.autores().get(0).nome().toLowerCase().contains(nomeBusca.toLowerCase()))
                    .sorted(Comparator.comparing(livro -> livro.autores().get(0).nome()))
                    .limit(5) // manter temporariamente
                    .collect(Collectors.toList());

            if (livrosFiltradosAutor.isEmpty()) {
                System.out.println("Nenhum livro encontrado para este(a) autor(a).");
            } else {
                for (Livro livro : livrosFiltradosAutor) {
                    System.out.println("Id: " + livro.id());
                    System.out.println("Título: " + livro.titulo());
                    String autores = livro.autores().stream()
                            .findFirst()
                            .map(Pessoa::nome)
                            .orElse("Autor(a) não encontrado(a).");
                    System.out.println("Autor(a): " + autores);
                    System.out.println("Downloads: " + livro.downloads() + "\n");
                }
            }
            concluir();
        } catch (Exception e) {
            e.printStackTrace();
        } // o fechamento do scanner estava causando erro
    }
}
