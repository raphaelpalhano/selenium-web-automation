package com.web.automation.maps;

import org.openqa.selenium.By;

public class LoginMap {
	
	public By botao_entrar = By.xpath("//span[normalize-space(text())='ENTRAR']/..");
	
	public By campo_Login(String nome) {
		return By.xpath("//input[@formcontrolname='" + nome + "']");
	}
	
	public By textoDeLoginInvalido() {
		return By.xpath("//div[@class='swal2-html-container']");
	}


}