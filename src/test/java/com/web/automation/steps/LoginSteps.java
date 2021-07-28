package com.web.automation.steps;

import org.junit.Assert;

import com.web.automation.core.CucumberLog;
import com.web.automation.enums.LogType;
import com.web.automation.pages.LoginPage;
import com.web.automation.util.Log;

import  io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	private LoginPage loginPage = new LoginPage();

	/**
	 * Login with user and password
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Quando("^que esteja logado em \"(.*?)\" com usuário \"(.*?)\" e senha \"(.*?)\"$")
	public void login(String url, String username, String password) throws Exception {
		Log.sendLog(CucumberLog.createLog(this.getClass(),CucumberLog.getMethodName(), new Object[] { url, username, password }),
				LogType.INFO);
		loginPage.navigateToUrl(url);
		loginPage.fillLoginFields(username, password);
		loginPage.performLogin();
	}
	
	
	@Entao("^a seguinte mensagem de erro \"(.*?)\" é exibida na página de login$")
	public void validateLoginErrorMessage(String expectedMessage) throws Exception{
		Log.sendLog(CucumberLog.createLog(this.getClass(),CucumberLog.getMethodName(), new Object[] { expectedMessage }),
				LogType.INFO);
		Assert.assertEquals(expectedMessage, loginPage.getLoginErrorMessage());
	}
	
	
	
}
