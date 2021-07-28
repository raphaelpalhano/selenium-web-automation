package com.web.automation.pages;

import com.web.automation.maps.HomeMap;

public class HomePage extends BasePage {
	
	HomeMap homeMap = new HomeMap();
	
	public void selectMenuOption(String option) throws Exception {
		click(homeMap.getMenuOption(option));
	}
	
	

}
