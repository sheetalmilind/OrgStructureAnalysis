package com.organization.structure.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	
	private static final Properties properties = new Properties();
	
	static {
		
		InputStream input = ConfigUtil.class.getClassLoader().getResourceAsStream("application.properties");
		if(input != null) {
			try {
				properties.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  }
		
		public static String getProperty(String key) {
			return properties.getProperty(key);
		}
		
	}


