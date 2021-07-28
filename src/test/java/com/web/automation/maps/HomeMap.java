package com.web.automation.maps;

import org.openqa.selenium.By;

public class HomeMap {

	public By getMenuOption(String option) {
		switch (option.toLowerCase()) {
		case "gestão ágil":
			option = "gestao-agil";
			break;
		case "dashboard":
			option = "dashboard";
			break;
		}
		return By.xpath("(//a[contains(@href,'" + option + "')])[1]");
	}

}
