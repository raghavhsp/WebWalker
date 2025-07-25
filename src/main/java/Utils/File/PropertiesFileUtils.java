package Utils.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Utils.Test.TestBase;

public class PropertiesFileUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PropertiesFileUtils.class);
	private static Properties testProperties;
	
	// Constructor method
	public PropertiesFileUtils()
	{
		testProperties=getConfig().isPresent() ? getConfig().get() : null;
	}
	
	
	/**
	 * @description This method is used to get a property value from config.properties files
	 * @author raghavagnihotri
	 * @return 
	 * @since 25-JUL-2025
	 */
	public  Optional<String> getConfigPropertyValue(String propertyKey)
	{
		String value = testProperties.getProperty(propertyKey);
		return Optional.ofNullable(value);
	}
	
	
	/**
	 * @decription This method is used to load properties from a file 
	 * @author raghavagnihotri
	 * @since 25-JUL-2025
	 * @param filePath
	 * @return Properties
	 */
	public  Optional<Properties> getProperty(String filePath)
	{
		Properties prop= new Properties();
		
		InputStream stream =null;
		
		try {
			stream = new FileInputStream (new File (System.getProperty("user.dir")+ filePath) );			
			prop.load(stream);
		}
		catch (Exception e) {
		log.error("Error getting file '"+System.getProperty("user.dir")+ filePath +"': "+e.getMessage());
		}
		
		return Optional.ofNullable(prop);
	}
	
	
	/**
	 * @description this method is used to get properties from config.properties files
	 * @author raghavagnihotri
	 * @since 25-JUL-2025
	 * @return
	 */
	public  Optional<Properties> getConfig()
	{
		return getProperty(File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"config.properties");
		
	}

}
