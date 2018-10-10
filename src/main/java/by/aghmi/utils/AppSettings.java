package by.aghmi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppSettings {
	
	private static AppSettings settings;
	private static Properties props;
	
	private AppSettings() {
		props = new Properties();
		try {
			props.load(new FileInputStream(new File("C:/Users/Mickey/Desktop/NewWebApp/res/app.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Settings have been initialized.");
	}
	
	public synchronized static AppSettings getSettings(){
		if(settings == null){
			settings = new AppSettings();
		}
		return settings;
	}
	
	public synchronized String getProp(String key){
		return props.getProperty(key);
	}
	
	public synchronized Properties getProperties(){
		return props;
	}

}
