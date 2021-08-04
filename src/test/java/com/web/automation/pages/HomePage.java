package com.web.automation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.web.automation.constants.TimeOutConstants;
import com.web.automation.maps.HomeMap;
import com.web.automation.util.GenerateEvidences;

public class HomePage extends BasePage {

	private HomeMap homeMap = new HomeMap();

	public List<String> retornandoListaDeElementosNavBar() throws Exception {
		waitVisibilityAndPresenceOfElement(homeMap.baseElementos, TimeOutConstants.AVERAGE_SECONDS);
		hover(homeMap.baseElementos);
		waitVisibilityAndPresenceOfElement(homeMap.primeira_opcao, TimeOutConstants.AVERAGE_SECONDS);
		return listaDeElementosValores(getWebElements(homeMap.listaDeElementos));
	}
	
	
	

	
	public void clicandoEmBotaoGestaoAgil() {
		try {
			waitVisibilityAndPresenceOfElement(homeMap.baseElementos, TimeOutConstants.AVERAGE_SECONDS);
			hover(homeMap.baseElementos);
			GenerateEvidences.takeScreenshot("clicando na opcao gestao agil ", homeMap.botaoGestaoAgil);
			click(homeMap.botaoGestaoAgil);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void clicandoEmBotaoDeSair() {
		try {
			if (waitVisibilityAndPresenceOfElement(homeMap.botaoDeSaida, 1)) {
				GenerateEvidences.takeScreenshot("Clicando em botao de sair ", homeMap.botaoDeSaida);
				click(homeMap.botaoDeSaida);
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

	public void navegandoParaOSite(String URL) {
		try {
			navigate(URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
