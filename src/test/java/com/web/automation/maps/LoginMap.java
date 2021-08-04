package com.web.automation.maps;

import org.openqa.selenium.By;

public class LoginMap {
		
	public By botao_entrar = By.xpath("//span[normalize-space(text())='ENTRAR']/..");
	
	public By campo_Login(String nome) {
		return By.xpath("//input[@formcontrolname='" + nome + "']");
	}
	
	public By textoDeLoginInvalido = By.xpath("(//h2[text()='ERRO']/ancestor::div[@role='dialog']//div[text()!=''])[last()]");

	public By tituloPrincipalDoPainel = By.xpath("//span[@class='navbar-brand']/ancestor::div[@class='navbar-wrapper']");

}