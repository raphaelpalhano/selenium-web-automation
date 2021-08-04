package com.web.automation.maps;

import org.openqa.selenium.By;

public class GestaoAgilMap {
	
	public By todasDemandas = By.xpath("(//a[@href='#/gestao-agil/todas-demandas'])[1]");
	
	public By botaoCriarDemanda = By.xpath("//span[normalize-space(text())='NOVA DEMANDA']/..");

	
	public By campoTitulo = By.xpath("//input[@formcontrolname='titulo']");
	
	public By opcoesSelect = By.xpath("//span[@class='ng-tns-c61-867.ng-star-inserted']");
	
	public By campoHora = By.xpath("//mat-label[normalize-space(text())='Horas estimadas']/ancestor::div[1]//input");
	
	public By preenchendoCamposData(String subtitulo, String campoData){
		return By.xpath("//div//h6[text()='"+subtitulo+"']/ancestor::div[1]//app-input-datepicker[@label='"+campoData+"']//input");
		
	}
	
	public By dataRecebimento(String valor) {
		return By.xpath("//app-input-datepicker[@label='"+valor+"']//input");

	}
	
	public By botaoSalvar = By.xpath("//mat-icon[text()='save']/ancestor::span/..");
	
	public By capturandoMensagem(String mensagem) {
		return By.xpath("//span[normalize-space(text())='" + mensagem + "']/..");
	}
	
	public By mensagemDeErroDaData(String mensagemDeErro) {
		return By.xpath("//div[normalize-space(text())='"+mensagemDeErro+"']");
	}
	
	
	//mat-label[text()='Status']/ancestor::div[1]//mat-select
	
	//span[normalize-space(text())='BACKLOG']/ancestor::mat-option
	
	public By campoDeValor(String campo) {
		return By.xpath("//mat-label[text()='"+campo+"']/ancestor::div[1]//mat-select");
	}

	

	public By campoOpcoes(String campoOpcaoDinamica) {
		return By.xpath("//span[normalize-space(text())='"+campoOpcaoDinamica+"']/ancestor::mat-option");
	}
}
