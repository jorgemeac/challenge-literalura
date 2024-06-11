package br.com.bibliole.app.start;

import br.com.bibliole.app.start.menu.MenuPrincipal;
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