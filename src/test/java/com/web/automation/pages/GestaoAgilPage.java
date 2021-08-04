package com.web.automation.pages;

import java.time.LocalDate;
import java.time.LocalTime;
import com.web.automation.constants.TimeOutConstants;
import com.web.automation.maps.GestaoAgilMap;
import com.web.automation.util.DateManager;
import com.web.automation.util.GenerateEvidences;

public class GestaoAgilPage extends BasePage {

	GestaoAgilMap gestaoAgil = new GestaoAgilMap();

	public void clicandoEmBotaoTodasDemandas() {
		try {
			waitVisibilityAndPresenceOfElement(gestaoAgil.todasDemandas, TimeOutConstants.AVERAGE_SECONDS);
			GenerateEvidences.takeScreenshot("Botao todas demandas", gestaoAgil.todasDemandas);
			click(gestaoAgil.todasDemandas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clicandoNoBotaoDeCriarDemanda() {
		try {
			waitVisibilityAndPresenceOfElement(gestaoAgil.botaoCriarDemanda, TimeOutConstants.AVERAGE_SECONDS);
			GenerateEvidences.takeScreenshot("Botao Criar demanda", gestaoAgil.botaoCriarDemanda);
			click(gestaoAgil.botaoCriarDemanda);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selecionarOpcao(String campo, String campoOpcoes) {
		try {
			waitVisibilityAndPresenceOfElement(gestaoAgil.campoDeValor(campo), TimeOutConstants.AVERAGE_SECONDS);
			GenerateEvidences.takeScreenshot("Campo de valor" + campo + " ", gestaoAgil.campoDeValor(campo));
			click(gestaoAgil.campoDeValor(campo));
			waitVisibilityAndPresenceOfElement(gestaoAgil.campoOpcoes(campoOpcoes), TimeOutConstants.AVERAGE_SECONDS);
			GenerateEvidences.takeScreenshot("Campo de opção" + campoOpcoes + " ", gestaoAgil.campoOpcoes(campoOpcoes));
			click(gestaoAgil.campoOpcoes(campoOpcoes));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void preencherCampo(String valor) {
		try {
			waitVisibilityAndPresenceOfElement(gestaoAgil.campoTitulo, TimeOutConstants.AVERAGE_SECONDS);
			sendKeys(gestaoAgil.campoTitulo, valor, false);
			GenerateEvidences.takeScreenshot("preencher campo com valor " + valor + " ", gestaoAgil.campoTitulo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void preencherData(String valor, String subtitulo, String campoValor) {
		try {
			waitVisibilityAndPresenceOfElement(gestaoAgil.preenchendoCamposData(subtitulo, campoValor),
					TimeOutConstants.AVERAGE_SECONDS);
			String data = DateManager.convertToPatternDate(valor, "dd/MM/yyyy");
			sendKeys(gestaoAgil.preenchendoCamposData(subtitulo, campoValor), data, false);
			GenerateEvidences.takeScreenshot("preencher campo com valor " + valor + " ",
					gestaoAgil.preenchendoCamposData(subtitulo, campoValor));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public boolean valorDataDeRecebimento(String campoValor, String valor) {
		try {
			waitVisibilityAndPresenceOfElement(gestaoAgil.dataRecebimento(campoValor),
					TimeOutConstants.AVERAGE_SECONDS);
			String data = DateManager.convertToPatternDate(valor, "dd/MM/yyyy");
			GenerateEvidences.takeScreenshot("preencher campo com valor " + valor + " ",
					gestaoAgil.dataRecebimento(campoValor));
			String valorDoCampo = getValue(gestaoAgil.dataRecebimento(campoValor));
			System.out.println(valorDoCampo);
			System.out.println(data);
			return valorDoCampo.equals(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Erro ao comparar valores de data de recebimento");
		return false;
	}

	public String retornaData() {
		LocalTime horasAtuais = LocalTime.now();
		LocalDate currentdate = LocalDate.now();
		int currentDay = currentdate.getDayOfMonth();
		int month = currentdate.getMonthValue();
		int year = currentdate.getYear();
		String date = " Data: " + currentDay + "/" + month + "/" + year +" horas: "+ horasAtuais; 
		return date;

	}

	public void preencherCampoHora(String valor) {
		try {
			waitVisibilityAndPresenceOfElement(gestaoAgil.campoHora, TimeOutConstants.AVERAGE_SECONDS);
			sendKeys(gestaoAgil.campoHora, valor, false);
			GenerateEvidences.takeScreenshot("preencher campo com valor " + valor + " ", gestaoAgil.campoHora);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clicandoEmBotaoSalvar() {
		try {
			waitVisibilityAndPresenceOfElement(gestaoAgil.botaoSalvar, TimeOutConstants.AVERAGE_SECONDS);
			click(gestaoAgil.botaoSalvar);
			GenerateEvidences.takeScreenshot("botão salvar", gestaoAgil.botaoSalvar);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String mensagemDeNaoPreenchimentoOuSucesso(String mensagem) {
		try {
			waitVisibilityAndPresenceOfElement(gestaoAgil.capturandoMensagem(mensagem), TimeOutConstants.AVERAGE_SECONDS);
			GenerateEvidences.takeScreenshot("botão salvar", gestaoAgil.capturandoMensagem(mensagem));
			return getText(gestaoAgil.capturandoMensagem(mensagem));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String mensagemDeFalhaDaData(String mensagem) {
			try {
				System.out.println(getText(gestaoAgil.mensagemDeErroDaData(mensagem)));
				waitVisibilityAndPresenceOfElement(gestaoAgil.mensagemDeErroDaData(mensagem), TimeOutConstants.AVERAGE_SECONDS);
				GenerateEvidences.takeScreenshot("mensagem de erro gerada por falta de preenchimento do campo data", gestaoAgil.mensagemDeErroDaData(mensagem));
				return getText(gestaoAgil.mensagemDeErroDaData(mensagem));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

}
