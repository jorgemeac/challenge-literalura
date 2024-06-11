package br.com.bibliole.app.service;

import br.com.bibliole.app.api.ConsumoBibliotecaApi;
import br.com.bibliole.app.model.Livro;
import br.com.bibliole.app.model.Pessoa;
import br.com.bibliole.app.start.menu.ExibeMenus;
import br.com.bibliole.app.start.menu.MenuLivro;
import br.com.bibliole.app.util.GerenciamentoEntrada;

import java.util.*;
import java.util.stream.Collectors;

public class BuscaLivroIdioma extends GerenciamentoEntrada {
    Scanner scanner = new Scanner(System.in);
    final String ENDERECO = "https://gutendex.com/books/";
    ConsumoBibliotecaApi consumo = new ConsumoBibliotecaApi();
    ExibeMenus exibeMenus = new ExibeMenus();

    public void buscarIdioma() throws Exception {
        exibeMenus.exibirMenuIdiomas();
        int opcao = receberInteiro(scanner);
        String idiomaBusca = selecionarIdioma(opcao);

        if (idiomaBusca == "SAIR") {
            MenuLivro menuLivro = new MenuLivro();
            menuLivro.menuLivros();
            return;
        }

        if (idiomaBusca == null) {
            System.out.println("Opção inválida. Retornando ao menu livros.");
            exibirMenuLivros();
            return;
        }

        String url = ENDERECO + "?languages=" + idiomaBusca;
        var respostaJson = consumo.buscarLivros(url);

        try {
            List<Livro> livrosFiltradosIdioma = respostaJson.resultado().stream()
                    .filter(livro -> livro.idioma().stream()
                            .anyMatch(idioma -> idioma.equalsIgnoreCase(idiomaBusca)))
                    .sorted(Comparator.comparing(Livro::titulo))
                    .limit(5)
                    .collect(Collectors.toList());

            if (livrosFiltradosIdioma.isEmpty()) {
                System.out.println("Nenhum livro encontrado neste idioma.");
            } else {
                int i = 1;
                for (Livro livro : livrosFiltradosIdioma) {
                    System.out.println("Id: " + livro.id());
                    System.out.println("Título " + i++ + ": " + livro.titulo());
                    String autores = livro.autores().stream()
                            .findFirst()
                            .map(Pessoa::nome)
                            .orElse("Autor(a) não encontrado(a).");
                    System.out.println("Autor(a): " + autores + "\n");
                }
                int numeroObras = i - 1;
                System.out.println("Foram encontrados " + numeroObras + " Obras para esta pesquisa.");
            }
            concluir();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String selecionarIdioma(int opcao) {
        return switch (opcao) {
            case 0 -> "SAIR";
            case 1 -> "af";
            case 2 -> "de";
            case 3 -> "el";
            case 4 -> "en";
            case 5 -> "es";
            case 6 -> "fr";
            case 7 -> "it";
            case 8 -> "la";
            case 9 -> "pt";
            case 10 -> "ru";
            default -> null;
        };
    }
}