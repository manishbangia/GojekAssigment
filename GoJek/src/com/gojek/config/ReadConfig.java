package com.gojek.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;


public class ReadConfig {
	private final static String extension = ".properties";
	private static final String path = "/src/com/gojek/config/cleartrip";
	private final static ReadConfig instance = new ReadConfig();
	
	public static ReadConfig getInstance() {
		return instance;
	}
	
	public String fetchConfig(String property) {

		String result = null;
		InputStream inputStream = null;

		try {
			Properties prop = new Properties();
			File file = new File(System.getProperty("user.dir") + path +extension);
			inputStream = new FileInputStream(file);
			prop.load(inputStream);
			Date time = new Date(System.currentTimeMillis());
			result = prop.getProperty(property);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;

	}
}
