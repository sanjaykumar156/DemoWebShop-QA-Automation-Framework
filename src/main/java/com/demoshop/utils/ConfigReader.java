package com.demoshop.utils;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop= new Properties();
	
	static {
		try {
	InputStream Is=ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
	
	if(Is==null) {
		throw new RuntimeException("configproperties file not found in the locaation");	
	}
	prop.load(Is);
		}catch(Exception e){
			throw new RuntimeException("Failed to load config.properties",e);
		
	}
	}
	public static String getproperty(String key) {
		return prop.getProperty(key);
	}

}
