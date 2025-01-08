package FixedData;

public enum BrowserType {
	
	/**
	 * @author raghavagnihotri
	 * @since 09-JAN-2025 
	 * This project support to work with most widely used browsers of industry
	 */
	
	CHROME("CHROME"),
	FIREFOX("FIREFOX"),
	SAFARI("SAFARI"),
	EDGE("EDGE");
	
	final String browser ;
	
	BrowserType(String browserName)
	
	{
		// Convert name to upper case
		browserName=browserName.toUpperCase();
		
		// Initialize browser based on browser name
		switch (browserName)
		{
		case "CHROME" -> this.browser=browserName;
		case "FIREFOX" -> this.browser=browserName;
		case "EDGE" -> this.browser=browserName;
		case "SAFARI" -> this.browser=browserName;
		default -> this.browser="CHROME";
		
		}
		
	}
}
