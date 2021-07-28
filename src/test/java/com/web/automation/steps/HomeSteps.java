package com.web.automation.steps;

import static com.web.automation.core.CucumberLog.createLog;
import static com.web.automation.core.CucumberLog.getMethodName;

import com.web.automation.enums.LogType;
import com.web.automation.pages.HomePage;
import com.web.automation.util.Log;

import io.cucumber.java.pt.E;

public class HomeSteps {

	HomePage homePage = new HomePage();

	@E("^a aba 'Todas as Demanda' é selecionada em \"(.*?)\"$")
	public void selecionarTodasAsDemandas(String option) throws Exception {
		Log.sendLog(createLog(this.getClass(), getMethodName(), new Object[] { option }), LogType.INFO);
		homePage.selectMenuOption(option);
	}

}
