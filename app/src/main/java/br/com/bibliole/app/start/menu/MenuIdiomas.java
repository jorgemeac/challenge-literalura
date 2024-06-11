package br.com.bibliole.app.start.menu;

import br.com.bibliole.app.util.GerenciamentoEntrada;

import java.util.Scanner;

public class MenuIdiomas extends GerenciamentoEntrada {
    private final Scanner scanner = new Scanner(System.in);
    private int minhaOpcao;

    public void menuIdiomas() throws Exception {
        ExibeMenus menuIdioma = new ExibeMenus();
        menuIdioma.exibirMenuIdiomas();
        do {
            System.out.print("Escolha uma opção de busca em idiomas: ");
            minhaOpcao = receberValorInteiro(scanner);

            switch (minhaOpcao) {
                case 1:
                    System.out.println("Viva a Africa!!!");
                    break;

                default:
                    defaultMetodo();
            }
        } while (minhaOpcao != 0);
    }
}
