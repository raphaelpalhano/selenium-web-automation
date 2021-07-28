package com.web.automation.maps;

import org.openqa.selenium.By;

public class LoginMap {
	public By login = By.xpath("//*[normalize-space(text())='ENTRAR']/ancestor::button[1]");
	public By username = By.xpath("//input[@*='username']");
	public By password = By.xpath("//input[@*='password']");
	
	public By errorMessage = By.xpath("(//h2[text()='ERRO']/ancestor::div[@role='dialog']//div[text()!=''])[last()]");
}