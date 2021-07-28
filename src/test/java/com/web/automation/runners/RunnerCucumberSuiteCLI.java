package com.web.automation.runners;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.web.automation.core.DriverFactory;

import io.cucumber.core.cli.Main;

public class RunnerCucumberSuiteCLI {
	public static String featuresPath;

	@Test
	public void main() throws Exception {
		String driverPath = System.getProperty("user.dir") + File.separator + "driver" + File.separator
				+ DriverFactory.driverName;
		Process p = Runtime.getRuntime().exec("chmod +x " + driverPath);
		p.waitFor();

		String cucumberTags = System.getProperty("cucumberTags") != null ? System.getProperty("cucumberTags") : "";
		List<String> cucumberTagsList = new ArrayList<String>();
		cucumberTagsList = Arrays.asList(cucumberTags.split("\\s\\,"));
		List<String> cucumberTagsArgsList = new ArrayList<String>();
		if (cucumberTagsList.size() > 0 && !cucumberTagsList.get(0).equals("")) {
			for (String cucumberTag : cucumberTagsList) {
				cucumberTagsArgsList.add("-t");
				cucumberTagsArgsList.add(cucumberTag);
			}
		}

		String[] cucumberArgs = { "-g", "com.web.automation.core", "-g", "com.web.automation.pages", "-g",
				"com.web.automation.steps", "src/test/resources/features", "--plugin", "pretty", "--plugin",
				"json:target/cucumber/cucumber.json", "--plugin", "html:target/cucumber/cucumber", "-m" };
		cucumberArgs = ArrayUtils.addAll(cucumberArgs, cucumberTagsArgsList.stream().toArray(String[]::new));
		Main.run(cucumberArgs, ClassLoader.getSystemClassLoader());
	}
}
