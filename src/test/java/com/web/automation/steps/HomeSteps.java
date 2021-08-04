package com.web.automation.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.web.automation.core.AccessDataManager;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LoginPage;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;

public class HomeSteps {

	private HomePage homePage = new HomePage();	
	private LoginPage loginPage = new LoginPage();

	@Então("uma lista de titulos é exibida na página de inicial")
	public void titulo_principal_mostrado_na_tela(String opcoes) throws Exception {
		String[] opcoesList = opcoes.split("\\r?\\n"); // \r?\n

		for (String opcao : opcoesList) {

			assertTrue("A opção " + opcao + " não foi encontrada no menu da página inicial",
					homePage.retornandoListaDeElementosNavBar().contains(opcao));
		}

	}
	
	
	@E("o login é efetuado com usuário {string} e senha {string}")
	public void o_login_é_realizado_com_usuário_e_senha_​(String usuario, String senha) throws Exception {
		String username = AccessDataManager.isCentralizedData(usuario) ? AccessDataManager.getData().getUsername()
				: usuario;
		String password = AccessDataManager.isCentralizedData(senha) ? AccessDataManager.getData().getPassword()
				: senha;
		homePage.clicandoEmBotaoDeSair();
		loginPage.preencher_campo("username", username);
		loginPage.preencher_campo("password", password);
		loginPage.clicandoBotaoDeLogin();
		

	}
	
	
	

	
	
	
}
