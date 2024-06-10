package br.com.biblioler.app.service;

/*public class BuscaLivroIdioma {

    Scanner scanner = new Scanner(System.in);
    final String ENDERECO = "https://gutendex.com/books/";
    ConsumoBibliotecaApi consumo = new ConsumoBibliotecaApi();

    public void buscarTitulo() throws Exception {
        System.out.println("Digite o idioma dos livros que deseja buscar: ");
        String idiomaBusca = scanner.nextLine().toLowerCase();

        List<Livro> todosLivros = new ArrayList<>();
        int page = 1;
        boolean hasMoreResults = true;

        while (hasMoreResults) {
            String url = ENDERECO + "?languages=" + idiomaBusca + "&page=" + page;
            var respostaJson = consumo.buscarLivros(url);

            if (respostaJson != null && respostaJson.resultado() != null) {
                List<Livro> livrosPagina = respostaJson.resultado();
                if (livrosPagina.isEmpty()) {
                    hasMoreResults = false;
                } else {
                    todosLivros.addAll(livrosPagina);
                    page++;
                }
            } else {
                hasMoreResults = false; // No more valid responses, exit loop
            }
        }

        try {
            List<Livro> livrosFiltradosIdioma = todosLivros.stream()
                    .peek(livro -> System.out.println("Livro encontrado: " + livro.titulo() + " - Idiomas: " + livro.idioma()))
                    .filter(livro -> livro.idioma().stream()
                            .anyMatch(idioma -> idioma.equalsIgnoreCase(idiomaBusca)))
                    .sorted(Comparator.comparing(Livro::titulo))
                    .limit(5)
                    .collect(Collectors.toList());

            if (livrosFiltradosIdioma.isEmpty()) {
                System.out.println("Nenhum livro encontrado neste idioma.");
            } else {
                for (Livro livro : livrosFiltradosIdioma) {
                   // System.out.println("Título: " + livro.titulo());
                }
            }
            System.out.println("Foram econtrados " + livrosFiltradosIdioma.size() + "títulos.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
*/
//
//
//public class BuscaLivroIdioma {
//    Scanner scanner = new Scanner(System.in);
//    final String ENDERECO = "https://gutendex.com/books/";
//    ConsumoBibliotecaApi consumo = new ConsumoBibliotecaApi();
//
//    public void buscarIdioma() throws Exception {
//        System.out.println("Digite o idioma dos livros que deseja buscar: ");
//        String idiomaBusca = scanner.nextLine().toLowerCase(); //vou fazer um enum para a pessoa digitar português e aparecer pt
//        String url = ENDERECO + "?languages=" + idiomaBusca;
//        var respostaJson = consumo.buscarLivros(url);
//
//        try {
//            List<Livro> livrosFiltradosIdioma = respostaJson.resultado().stream()
//                    //.peek(livro -> System.out.println("Livro encontrado: " + livro.titulo() + " - Idiomas: " + livro.idioma()))
//                    .filter(livro -> livro.idioma().stream()
//                            .anyMatch(idioma -> idioma.equalsIgnoreCase(idiomaBusca)))
//                    .sorted(Comparator.comparing(Livro::titulo))
//                    .limit(5)
//                    .collect(Collectors.toList());
//            if (livrosFiltradosIdioma.isEmpty()) {
//                System.out.println("Nenhum livro encontrado neste idioma.");
//            } else {
//                int i = 1;
//                for (Livro livro : livrosFiltradosIdioma) {
//                                        System.out.println("Id: " + livro.id());
//                    System.out.println("Título " + i++ + ": " + livro.titulo());
//                    String autores = livro.autores().stream()
//                            .findFirst()
//                            .map(Pessoa::nome)
//                            .orElse("Autor(a) não encontrado(a).");
//                    System.out.println("Autor(a): " + autores + "\n");//teste
//                }
//                int numeroObras = i++ - 1; //preciso melhorar esta lógica, mas tá funcionando
//                System.out.println("Foram encontrados " + numeroObras + " Obras para esta pesquisa.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void exibirMenuIdiomas() {
//        System.out.println("""
//        Menu Listar livros por Idiomas
//        1 - AFRICANO (AF)   |    6 - FRANCÊS (FR)
//        2 - ALEMÃO (DE)     |    7 - ITALIANO (IT)
//        3 - GREGO (EL)      |    8 - LATIM (LA)
//        4 - INGLÊS (EN)     |    9 - PORTUGUÊS (PT)
//        5 - ESPANHOL (ES)   |    10 - RUSSO (RU)
//
//        0 - RETORNAR
//                """);
//    }
//}
import br.com.biblioler.app.api.ConsumoBibliotecaApi;
import br.com.biblioler.app.model.Livro;
import br.com.biblioler.app.model.Pessoa;
import br.com.biblioler.app.start.menu.ExibeMenus;
import br.com.biblioler.app.start.menu.MenuLivro;
import br.com.biblioler.app.util.GerenciamentoEntrada;

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

//    public void exibirMenuIdiomas() {
//        System.out.println("""
//        Menu Listar livros por Idiomas
//        1 - AFRICANO (AF)   |    6 - FRANCÊS (FR)
//        2 - ALEMÃO (DE)     |    7 - ITALIANO (IT)
//        3 - GREGO (EL)      |    8 - LATIM (LA)
//        4 - INGLÊS (EN)     |    9 - PORTUGUÊS (PT)
//        5 - ESPANHOL (ES)   |    10 - RUSSO (RU)
//
//        0 - RETORNAR
//        """);
//    }

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

//    public int receberInteiro() {
//        int numero;
//        while (true) {
//            try {
//                numero = scanner.nextInt();
//                scanner.nextLine(); // Limpar o buffer após receber o valor inteiro
//                break;
//            } catch (InputMismatchException e) {
//                System.out.println("Por favor, insira um número válido.");
//                scanner.next(); // Limpar entrada inválida
//            }
//        }
//        return numero;
//    }

    public static void main(String[] args) {
        BuscaLivroIdioma busca = new BuscaLivroIdioma();
        try {
            busca.buscarIdioma();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
