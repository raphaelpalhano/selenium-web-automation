package com.web.automation.core;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { " com.web.automation.pages", " com.web.automation.steps",
		" com.web.automation.core" }, monochrome = true, strict = true, plugin = { "html:target/cucumber/cucumber",
				"json:target/cucumber/cucumber.json" })
public class CucumberConfig {
}
