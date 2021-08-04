package com.web.automation.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import com.web.automation.pages.GestaoAgilPage;
import com.web.automation.pages.HomePage;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class GestaoAgilSteps {
	
	HomePage homePage = new HomePage();
	GestaoAgilPage gestaoAgilPage = new GestaoAgilPage();
	
	
	@E("a aba {string} é selecionada em Gestão Ágil")
	public void aba_de_gestao_agil_selecionada(String valorEsperadoTexto) {
		homePage.clicandoEmBotaoGestaoAgil();
		gestaoAgilPage.clicandoEmBotaoTodasDemandas();
		
	}
	
	@Quando("acessar página de criação de demandas")
	public void acessando_pagina_de_criacao_de_demanda() {
		gestaoAgilPage.clicandoNoBotaoDeCriarDemanda();
	}
	
	@E("em nova demanda preencher o campos com os valores")
	public void preenchendo_campo_titulo(String valores) {
		List<String> valoresList = Arrays.asList(valores.split("\\r?\\n")); // \r?\n 
		// nome : valor
		
		for (String valor : valoresList) {
			 // tirando o espaço lado esquerdo; tirando; tirando os dois pontos; tirando espaço lado direito; ind[0]
			String nome = valor.split("\\s*\\:\\s*")[0];
			String valor_campo = valor.split("\\s*\\:\\s*")[1];
			if(nome.equalsIgnoreCase("Status")) {
				gestaoAgilPage.selecionarOpcao(nome, valor_campo);
			}else if(nome.equalsIgnoreCase("Título")) {
				gestaoAgilPage.preencherCampo(valor_campo +":"+ gestaoAgilPage.retornaData());

			}else if(nome.equalsIgnoreCase("Hora estimadas")) {
				gestaoAgilPage.preencherCampoHora(valor_campo);
			}else {
				
				 //nome = Planejado - Data final
				String sub_campo_data = nome.split("\\s*\\-\\s*")[0];
				String nome_campo_data = nome.split("\\s*\\-\\s*")[1];
				System.out.println(sub_campo_data);
				System.out.println(nome_campo_data);
				gestaoAgilPage.preencherData(valor_campo, sub_campo_data, nome_campo_data);
				
			}
		}
	
	}
	
	
	@E("salvar nova demanda")
	public void clicando_em_salvar_demanda() {
		gestaoAgilPage.clicandoEmBotaoSalvar();
	}
	
	@Entao("o sistema exibe a mensagem {string}")
	public void mensagemExibida(String valor) {
		switch(valor) {
		case "A data de início executada deve ser informada!":
			assertEquals("preenchimento da data iníco", valor, gestaoAgilPage.mensagemDeFalhaDaData(valor));
			break;
		case "Demanda criada com sucesso!":
			assertEquals("demanda criada com sucesso", valor, gestaoAgilPage.mensagemDeNaoPreenchimentoOuSucesso(valor));
			break;
		case "Preencha o formulário adequadamente!":
			assertEquals("preenchimento inadequado", valor, gestaoAgilPage.mensagemDeNaoPreenchimentoOuSucesso(valor));
			break;
		case "A data de entrega executada deve estar em branco em uma demanda DOING":
			assertEquals("data de entrega executada não ficou em branco", valor, gestaoAgilPage.mensagemDeFalhaDaData(valor));
			break;
		}
	}
	
	
	@Então("o campo \"(.*?)\" é habilitado até a data \"(.*?)\"$")
	public void data_do_campo_atual_habilitado(String nomeCampo, String valor) {
		assertTrue(gestaoAgilPage.valorDataDeRecebimento(nomeCampo, valor));
	}
	
}
