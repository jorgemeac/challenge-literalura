package br.com.biblioler.app.start.menu;

import br.com.biblioler.app.util.GerenciamentoEntrada;

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
//            System.out.println("""
//        Menu Listar livros por Idiomas
//        AF - AFRICANO   |    FR - FRANCÊS
//        DE - ALEMÃO     |    IT - ITALIANO
//        EL - GREGO      |    LA - LATIM
//        EN - INGLÊS     |    PT - PORTUGUÊS
//        ES - ESPANHOL   |    RU - RUSSO
//
//        RETORNAR
//                """)

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
