package br.com.bibliole.app.service;

import br.com.bibliole.app.api.ConsumoBibliotecaApi;
import br.com.bibliole.app.model.Livro;
import br.com.bibliole.app.model.Pessoa;
import br.com.bibliole.app.util.GerenciamentoEntrada;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuscaLivroTitulo extends GerenciamentoEntrada {
    Scanner scanner = new Scanner(System.in);
    final String ENDERECO = "https://gutendex.com/books/";
    ConsumoBibliotecaApi consumo = new ConsumoBibliotecaApi();

    public void buscarTitulo() throws Exception{
        System.out.println("Digite o nome do livro que deseja fazer a busca: ");
        var nomeBusca = scanner.nextLine();
        var respostaJson = consumo.buscarLivros(ENDERECO + "?search=" + nomeBusca.replace(" ", "%20"));

        try {
            List<Livro> livrosFiltradosTitulo = respostaJson.resultado().stream()
                    .filter(livro -> livro.titulo().toLowerCase().contains(nomeBusca.toLowerCase()))
                    .sorted(Comparator.comparing(Livro::titulo))
                    .limit(5) //manter o limite da api por enquanto
                    .collect(Collectors.toList());
            if(livrosFiltradosTitulo.isEmpty()) {
                System.out.println("Nenhum livro encontrado com seus parâmetros de busca.");
            } else {
                for (Livro livro : livrosFiltradosTitulo) {
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
        }
    }
}
