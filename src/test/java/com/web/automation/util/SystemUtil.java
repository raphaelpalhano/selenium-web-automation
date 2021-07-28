package com.web.automation.util;

import java.util.Properties;
import java.util.PropertyPermission;

import sun.security.util.SecurityConstants;

public class SystemUtil {

	public static void setProperty(String key, Object value) {
		System.setProperty(key, value.toString());
	}
}
