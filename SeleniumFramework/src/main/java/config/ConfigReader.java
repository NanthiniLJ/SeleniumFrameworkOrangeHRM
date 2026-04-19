package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	public Properties init_prop() {
		
		prop = new Properties();
		try {
			FileInputStream ipfile = new FileInputStream("./src/main/resources/config.properties");
			prop.load(ipfile);
		} catch(FileNotFoundException e) {
			e.printStackTrace();	
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return prop;
		
		
	}
	

}
