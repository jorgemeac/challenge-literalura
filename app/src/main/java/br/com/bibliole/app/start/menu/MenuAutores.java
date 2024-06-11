package br.com.bibliole.app.start.menu;

import br.com.bibliole.app.util.GerenciamentoEntrada;

import java.util.Scanner;

public class MenuAutores extends GerenciamentoEntrada {
    private final Scanner scanner = new Scanner(System.in);
    private int minhaOpcao;

    public void menuAutores() throws Exception { //Método para exibir o menu livros
        ExibeMenus menuAutor = new ExibeMenus();
        menuAutor.exibirMenuAutor();

        do {
            System.out.print("Escolha uma opção de busca em autores: ");
            minhaOpcao = receberValorInteiro(scanner);
            switch (minhaOpcao) {
                case 1:
                    buscarAutorPorNome();
                    break;
                case 2:
                    buscarAutorPorPeriodo();
                    break;
                case 3:
                    buscarAutorAntes();
                    break;
                case 4:
                    buscarAutorApos();
                    break;
                case 5: //ok
                    retornar();
                    // Retorno ao menu principal, encerrando o loop
                    break;
                default: //ok
                    defaultMetodo();
            }
        } while (minhaOpcao != 5);
    }
}
