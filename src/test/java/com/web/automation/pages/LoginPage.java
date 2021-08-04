package com.web.automation.pages;

import com.web.automation.constants.TimeOutConstants;
import com.web.automation.core.AccessDataManager;
import com.web.automation.maps.HomeMap;
import com.web.automation.maps.LoginMap;
import com.web.automation.util.GenerateEvidences;

public class LoginPage extends BasePage {
	
	private LoginMap loginMap = new LoginMap();
	
	public void navegar_Para_URL() {
		try {
			String url = AccessDataManager.getData().getUrl().toString();
			navigate(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void preencher_campo(String campo, String valor) {
		try {
			waitVisibilityAndPresenceOfElement(loginMap.campo_Login(campo),TimeOutConstants.AVERAGE_SECONDS);
			sendKeys(loginMap.campo_Login(campo), valor, false);
			GenerateEvidences.takeScreenshot("Página de Login do sistema " + campo, loginMap.campo_Login(campo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void clicandoBotaoDeLogin() {
		try {
			waitVisibilityAndPresenceOfElement(loginMap.botao_entrar,TimeOutConstants.AVERAGE_SECONDS);
			click(loginMap.botao_entrar);
			GenerateEvidences.takeScreenshot("Página de Login do sistema ", loginMap.botao_entrar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String pegarTextoDeLoginInvalido() {
		try {
			waitVisibilityAndPresenceOfElement(loginMap.textoDeLoginInvalido,TimeOutConstants.AVERAGE_SECONDS);
			GenerateEvidences.takeScreenshot("Mensagem de Login Invalido! ", loginMap.textoDeLoginInvalido);
			return getText(loginMap.textoDeLoginInvalido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
		
	
	public String tituloPainelPrincipal() {
		try {
			waitVisibilityAndPresenceOfElement(loginMap.tituloPrincipalDoPainel, TimeOutConstants.AVERAGE_SECONDS);
			GenerateEvidences.takeScreenshot("Mensagem de Login Invalido! ", loginMap.tituloPrincipalDoPainel);
			return getText(loginMap.tituloPrincipalDoPainel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
