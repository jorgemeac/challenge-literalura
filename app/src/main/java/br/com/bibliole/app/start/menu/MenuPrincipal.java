package br.com.bibliole.app.start.menu;

import br.com.bibliole.app.util.GerenciamentoEntrada;

import java.util.Scanner;

public class MenuPrincipal extends GerenciamentoEntrada {
    private final Scanner scanner = new Scanner(System.in);
    private int minhaOpcao;


    public void menuPrincipal() throws Exception{
        ExibeMenus menuPrincipal = new ExibeMenus();
        menuPrincipal.exibirMenuPrincipal();
        do {

            System.out.print("Escolha uma opção: ");
            minhaOpcao = receberValorInteiro(scanner);
            //conforme for resolvendo os problemas, irei implementanto os metodos dos case na classe GerenciamentoEntrada
            switch (minhaOpcao) {
                case 1: //ok
                    exibirMenuLivros();
                    break;
                case 2: //ok
                    exibirMenuAutores();
                    break;
                case 3: //ok
                    sair();
                    break;
                default: //ok
                    defaultMetodo();
            }
        } while (minhaOpcao != 3);
    }
}
