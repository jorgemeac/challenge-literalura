package br.com.biblioler.app.start;

import br.com.biblioler.app.start.menu.MenuPrincipal;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaVirtualApplication {

	public static void main(String[] args) throws Exception {
		MenuPrincipal menu = new MenuPrincipal();

		try {
			menu.menuPrincipal();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
