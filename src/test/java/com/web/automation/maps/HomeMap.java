package com.web.automation.maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeMap {
	
	public By baseElementos = By.xpath("//div[@class='sidebar-wrapper']");
	public By primeira_opcao = By.xpath("(//ul[@class='nav']//p)[1]");

	public By botaoGestaoAgil = By.xpath("(//ul[@class='nav']//p)[2]");
	
	public By listaDeElementos = By.xpath("//ul[@class='nav']//p");
	
	public By botaoDeSaida = By.xpath("//i[text()='exit_to_app']/..");
	

	
}
