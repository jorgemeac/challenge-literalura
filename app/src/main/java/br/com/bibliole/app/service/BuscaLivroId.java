package br.com.bibliole.app.service;

import br.com.bibliole.app.api.ConsumoBibliotecaApi;
import br.com.bibliole.app.model.Livro;
import br.com.bibliole.app.model.Pessoa;
import br.com.bibliole.app.util.GerenciamentoEntrada;

import java.util.List;
import java.util.Scanner;

public class BuscaLivroId extends GerenciamentoEntrada {
    private final Scanner scanner = new Scanner(System.in);
    final String ENDERECO = "https://gutendex.com/books/";
    ConsumoBibliotecaApi consumo = new ConsumoBibliotecaApi();

    public void buscarTitulo() throws Exception{
        GerenciamentoEntrada menuLivroOpicional = new GerenciamentoEntrada();
        System.out.println("Digite o ID do livro desejado: ");
        var idBusca = menuLivroOpicional.receberValorInteiro(scanner);
        var respostaJson = consumo.buscarLivros(ENDERECO + "?ids=" + idBusca);

        try {
            List<Livro> livrosFiltradosId = respostaJson.resultado();
            if(livrosFiltradosId.isEmpty()) {
                System.out.println("Nenhum livro encontrado. Informe o Id corretamente.");
                idBusca = menuLivroOpicional.receberValorInteiro(scanner);
            } else {
                for (Livro livro : livrosFiltradosId) {
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
