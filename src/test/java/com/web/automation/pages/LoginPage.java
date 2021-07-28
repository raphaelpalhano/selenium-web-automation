package com.web.automation.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;

import com.web.automation.core.AccessDataManager;
import com.web.automation.maps.LoginMap;
import com.web.automation.util.GenerateEvidences;
import com.web.automation.util.StringManager;

public class LoginPage extends BasePage {
	private LoginMap loginMap = new LoginMap();


	
	public void navigateToUrl(String url) throws Exception {
		url = AccessDataManager.isCentralizedData(url) ? AccessDataManager.getData().getUrl() : url;
		if (!getCurrentPageUrl().equals("chrome-search://local-ntp/local-ntp.html")) {
			newTab();
			switchToNewTab(true);
		}
		navigate(url);
	}
	
	public void fillLoginFields(String username, String password) throws Exception {
		username = AccessDataManager.isCentralizedData(username) ? AccessDataManager.getData().getUsername() : username;
		password = AccessDataManager.isCentralizedData(password) ? AccessDataManager.getData().getPassword() : password;
		sendKeys(loginMap.username, username, false);
		sendKeys(loginMap.password, password, false);

	}
	
	public void performLogin() throws Exception {
		GenerateEvidences.takeScreenshot("Logando no sistema", loginMap.username, loginMap.password);
		sendEnter(loginMap.password);
	}
	
	public String getLoginErrorMessage() throws Exception {
		String erro = getText(loginMap.errorMessage);
		GenerateEvidences.takeScreenshot("Verificar mensagem de erro", loginMap.errorMessage);
		return erro;
	}
	
}
