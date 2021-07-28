package com.web.automation.pages;

import com.web.automation.maps.HomeMap;

public class HomePage extends BasePage {

	private HomeMap homeMap = new HomeMap();

	
	public void navegandoParaOSite(String URL) {
		try {
			navigate(URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
