package br.com.bibliole.app.util;

import br.com.bibliole.app.service.*;
import br.com.bibliole.app.start.menu.MenuAutores;
import br.com.bibliole.app.start.menu.MenuLivro;
import br.com.bibliole.app.start.menu.MenuPrincipal;

import java.util.Scanner;

public class GerenciamentoEntrada {
    Scanner scanner = new Scanner(System.in);
    int minhaOpcao;

    //Este método faz o tratamento de erro de entradas inválidas como strings, negativos e zero.
    protected static int receberValorInteiro(Scanner scanner) {
        int entradaNumerica;

        while (true) {
            try {
                String entradaString = scanner.nextLine().replace(" ", ""); //caso o usário digite valor não numérico por engano ou espaço antes/depois do número
                entradaNumerica = Integer.parseInt(entradaString); //tenta converter para inteiro

                if(entradaNumerica <= 0 ) {
                    //Se for um número zero ou negativo, esse erro será apresentado
                    throw new NumberFormatException("Erro: o número deve ser maior que zero.");
                }
                return entradaNumerica;

            } catch (NumberFormatException e) {
                //Caso o usuário digite uma entrada inválida e que
                //não pode ser convertida num inteiro.
                System.out.println("Erro: Entrada inválida. Por favor, digite um valor numérico adequado.");
                System.out.println("Este erro ocorre quando é inserido um valor não-numérico, zero ou números negativos.");
                System.out.println("Tente novamente. \n");
            }
        }
    }

    //Este método faz o tratamento de erro de entradas inválidas como strings.
    protected static int receberInteiro(Scanner scanner) {
        int entradaNumerica;

        while (true) {
            try {
                String entradaString = scanner.nextLine().replace(" ", ""); //caso o usário digite valor não numérico por engano ou espaço antes/depois do número
                entradaNumerica = Integer.parseInt(entradaString); //tenta converter para inteiro

                return entradaNumerica;

            } catch (NumberFormatException e) {
                //Caso o usuário digite uma entrada inválida e que
                //não pode ser convertida num inteiro.
                System.out.println("Erro: Entrada inválida. Por favor, digite um valor numérico adequado.");
                System.out.println("Este erro ocorre quando é inserido um valor não-numérico, zero ou números negativos.");
                System.out.println("Tente novamente. \n");
            }
        }
    }

    //MÉTODOS UTIIZADOS NO MENU PRINCIPAL
    //Método para exibir o MenuLivro - switch-case: 1
    protected void exibirMenuLivros() throws Exception {
        System.out.println("Você optou por pesquisar Livros.");
        MenuLivro menuLivros = new MenuLivro();
        menuLivros.menuLivros();
    }

    //Método para exibir o MenuLivro - switch-case: 1
    protected void exibirMenuAutores() throws Exception {
        System.out.println("Você optou por pesquisar Autores.");
        MenuAutores menuAutores = new MenuAutores();
        menuAutores.menuAutores();
    }

    //Método para sair da classe Pricipal
    protected void sair() throws Exception {
        System.out.println("Você optou por encerrar a aplicação.");
        System.out.println("Aplicativo finalizado com sucesso!");
        System.exit(0);

    }

    //Método para sair da classe Pricipal
    protected void concluir() throws Exception {
        System.out.println("Sua busca foi finalizada com sucesso!");
        System.exit(0);

    }

    //METODOS UTILIZADOS NO MENU LIVROS
    //Método para busca por Id da classe MenuLivro - switch-case: 1
    protected void buscarPorId() throws Exception {
        System.out.println("Você optou por pesquisar Livros por Id.");
        BuscaLivroId buscaId = new BuscaLivroId();
        buscaId.buscarTitulo();
    }

    //Método para busca por Título da classe MenuLivro - switch-case: 2
    protected void buscarPorTitulo() throws Exception {
        System.out.println("Você optou por pesquisar Livros por Título.");
        BuscaLivroTitulo buscaTitulo = new BuscaLivroTitulo();
        buscaTitulo.buscarTitulo();
    }

    //Método para busca por Autor da classe MenuLivro - switch-case: 3
    protected void buscarPorAutor() throws Exception {
        System.out.println("Você optou por pesquisar Livros por Autor(a).");
        BuscaLivroAutor buscaAutor = new BuscaLivroAutor();
        buscaAutor.buscarTitulo();
    }

    //Método para listar por Idioma da classe MenuLivro - switch-case: 4
    protected void listarPorIdioma() throws Exception {
        System.out.println("Você optou por listar Livros por Idioma.");
        BuscaLivroIdioma buscaIdioma = new BuscaLivroIdioma();
        buscaIdioma.buscarIdioma();
    } //Nota: tô querendo criar um método que busque por todos os arquivos de um idioma.

    //Método para retornar ao menuPrincipal, classe MenuLivro - switch-case: 5
    protected void retornar() throws Exception {
        System.out.println("Você optou por retornar ao Menu Inicial.");
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.menuPrincipal();
    }

    //Método defaultMetodo, (classe MenuLivro - switch-case > 5), (classe MenuPrincipal - switch-case > 6)
    protected void defaultMetodo() throws Exception {
        System.out.println("Erro: Você escolheu uma opção não disponível no menu.");
        System.out.println("Tente novamente. \n");
    }

    //METODOS UTILIZADOS NO MENU AUTORES
    //Método para buscar autor(a) por nome -  classe MenuAutores - switch-case: 1
    protected void buscarAutorPorNome() throws Exception {
        System.out.println("Você optou por pesquisar autores(as) pelo nome.");
        BuscaAutorNome buscaPorNome = new BuscaAutorNome();
        buscaPorNome.buscarAutor();
    }

    //Método para buscar autor(a) por período -  classe MenuAutores - switch-case: 2
    protected void buscarAutorPorPeriodo() throws Exception {
        System.out.println("Você optou por pesquisar autores(as) vivos por período.");
        BuscaAutorData buscaPorPeriodo = new BuscaAutorData();
        buscaPorPeriodo.buscarAutoresEntreAnos();
    }

    //Método para buscar autor(a) após -  classe MenuAutores - switch-case: 3
    protected void buscarAutorApos() throws Exception {
        System.out.println("Você optou por pesquisar autores(as) vivos a partir de determinado ano.");
        BuscaAutorData buscaAutorApos = new BuscaAutorData();
        buscaAutorApos.buscarAutoresApos();
    }

    //Método para buscar autor(a) por período anterior a - classe MenuAutores - switch-case: 4
    protected void buscarAutorAntes() throws Exception {
        System.out.println("Você optou por pesquisar autores(as) vivos a partir de determinado ano.");
        BuscaAutorData buscaAutorAntes = new BuscaAutorData();
        buscaAutorAntes.buscarAutoresAntes();
    }
}
