package br.com.bibliole.app.start.menu;

public  class ExibeMenus {
    //Método para exibir as opções do submenu Busca de Livros
    public void exibirMenuPrincipal() {
        System.out.println("""
                Menu Principal
                1 - BUSCAR LIVROS
                2 - BUSCAR AUTORES
                3 - SAIR
                """);
    }

    //Método para exibir as opções do submenu Busca de Livros
    public void exibirMenuLivros() {
        System.out.println("""
                Buscar Livros
                1 - BUSCAR POR ID
                2 - BUSCAR POR TÍTULO
                3 - BUSCAR POR AUTOR(A)
                4 - LISTAR LIVROS POR IDIOMAS
                5 - RETORNAR
                """);
    }

    //Método para exibir as opções do submenu Busca de Autores
    //Método para exibir as opções do submenu Busca de Ilustradores

    ///falta implementar os métodos
    public void exibirMenuAutor() {
        System.out.println(""" 
                Buscar Autores(as)
                1 - BUSCAR POR NOME
                2 - BUSCAR EM INTERVALO DE TEMPO
                3 - BUSCAR POR PERÍODO ANTERIOR A...
                4 - BUSCAR POR PERÍODO POSTERIOR A...
                5 - RETORNAR
                """);
    }

    //Método para listar livros por idioma
    public void exibirMenuIdiomas() {
        System.out.println("""
        Menu Listar livros por Idiomas
        1 - AFRICANO (AF)   |    6 - FRANCÊS (FR)
        2 - ALEMÃO (DE)     |    7 - ITALIANO (IT)
        3 - GREGO (EL)      |    8 - LATIM (LA)
        4 - INGLÊS (EN)     |    9 - PORTUGUÊS (PT)
        5 - ESPANHOL (ES)   |    10 - RUSSO (RU)
        
        0 - RETORNAR
                """);
    }
}
