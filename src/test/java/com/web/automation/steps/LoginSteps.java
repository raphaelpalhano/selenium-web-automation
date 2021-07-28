package com.web.automation.steps;



import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import com.web.automation.core.AccessDataManager;
import com.web.automation.pages.LoginPage;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	private LoginPage loginPage = new LoginPage();

	@Dado("^que o gestão ágil é acessado$")
	public void acessandoPaginaInicalGestaoAgil() {
		loginPage.navegar_Para_URL();

	}

   @Quando("^o login é realizado com usuário \"(.*?)\" e senha \"(.*?)\"​$")
	public void o_login_é_realizado_com_usuário_e_senha_​(String usuario, String senha) throws Exception {
		String username = AccessDataManager.isCentralizedData(usuario) ? AccessDataManager.getData().getUsername()
				: usuario;
		String password = AccessDataManager.isCentralizedData(senha) ? AccessDataManager.getData().getPassword()
				: senha;
		loginPage.preencher_campo("username", username);
		loginPage.preencher_campo("password", password);
		loginPage.clicandoBotaoDeLogin();

	}

	@Então("a seguinte mensagem de erro \"(.*?)\" é exibida na página de login​")
	public void a_seguinte_mensagem_de_erro_é_exibida_na_página_de_login​(String textoDeMensagem) {
		String texto = loginPage.pegarTextoDeLoginInvalido();
		Assert.assertEquals(textoDeMensagem, texto);
	}
	
	

}
