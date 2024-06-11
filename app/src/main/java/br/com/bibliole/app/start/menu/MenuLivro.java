package br.com.bibliole.app.start.menu;

import br.com.bibliole.app.util.GerenciamentoEntrada;

import java.util.Scanner;

public class MenuLivro extends GerenciamentoEntrada {
    private final Scanner scanner = new Scanner(System.in);
    private int minhaOpcao;

    public void menuLivros() throws Exception { //Método para exibir o menu livros
        ExibeMenus menuLivro = new ExibeMenus();
        menuLivro.exibirMenuLivros();
        do {
            System.out.print("Escolha uma opção de busca em livros: ");
            minhaOpcao = receberValorInteiro(scanner);
            switch (minhaOpcao) {
                case 1:
                    buscarPorId();
                    break;
                case 2:
                    buscarPorTitulo();
                    break;
                case 3:
                    buscarPorAutor();
                    break;
                case 4:
                    listarPorIdioma();
                    break;
                case 5:
                    retornar();
                    // Retorno ao menu principal, encerrando o loop
                    break;
                default:
                    defaultMetodo();
            }
        } while (minhaOpcao != 5);
    }
}