package util;

import java.io.FileInputStream;
import java.util.Properties;
//Java IO package
public class PropertyFileutil {
	
	public static String getPropertyValue(String key) throws Throwable {
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties properties=new Properties();
		properties.load(file);
		return properties.getProperty(key);
	}

}
