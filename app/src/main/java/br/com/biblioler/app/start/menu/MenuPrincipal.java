package br.com.biblioler.app.start.menu;

import br.com.biblioler.app.util.GerenciamentoEntrada;

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
                case 3: //estatísticas
                    MenuIdiomas menuIdiomas = new MenuIdiomas();
                    menuIdiomas.menuIdiomas();
                    break;
                case 4: //ok
                    sair();
                    break;
                default: //ok
                    defaultMetodo();
            }
        } while (minhaOpcao != 4);
       // scanner.close(); // ESTE CÓDIGO ESTAVA APRESETANDO ERRO DE SCANNER
        // Nos submenus não, pois dar erro.
    }
}
