package com.web.automation.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.web.automation.constants.TestRunnerConstants;
import com.web.automation.models.AccessData;
import com.web.automation.util.PropertiesManager;
import com.web.automation.util.StringManager;
import com.web.automation.util.YamlManager;

public class AccessDataManager {

	private static AccessData accessData = new AccessData();

	public static boolean isCentralizedData(String data) throws FileNotFoundException, IOException {
		return StringManager.getListMatcherByRegex(data, "^v[A-Z].*").size() > 0;
	}

	public static AccessData getData() throws FileNotFoundException, IOException {
		PropertiesManager enviromentProp = new PropertiesManager(
				TestRunnerConstants.ACCESS_PROPERTIES_PATH + File.separator + "access_envs.properties");
		loadData(enviromentProp.getProperties().getProperty("test_execution_environment"), accessData);
		return accessData;
	}

	public static void loadData(String environment, AccessData dataObject) throws FileNotFoundException {
		List<Object> yamlContent = YamlManager
				.readYaml(TestRunnerConstants.ACCESS_PROPERTIES_PATH + File.separator + "access_data.yaml");
		Map<?, ?> environmentDataMap = Map.class.cast(Map.class.cast(yamlContent.get(0)).get(environment));
		dataObject.setEnvironment(environment);
		dataObject.setUrl(environmentDataMap.get("url").toString());
		dataObject.setUsername(environmentDataMap.get("login_user").toString());
		dataObject.setPassword(environmentDataMap.get("login_password").toString());
	}
}
