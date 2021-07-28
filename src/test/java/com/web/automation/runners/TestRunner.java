package com.web.automation.runners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;

import com.web.automation.core.CucumberConfig;
import com.web.automation.core.Hooks;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", tags = { "@CT_AUT_02" })
public class TestRunner extends CucumberConfig {

	@BeforeClass
	public static void setup() {
		Hooks.setExcutionResultTime(new SimpleDateFormat("yyyyMMdd-HHmmss-SSS").format(new Date()));
	}
}
