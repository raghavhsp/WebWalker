package Utils.ExtentReport;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import Utils.Test.TestBase;




/**
 * @author 703306684 RAGHAV AGNIHOTRI
 * @since 13052024
 * @description Contains functions to control extent reporting feature in
 *              Automation Adaptive project
 * @version V 1.0
 */

public class ExtentReportUtility extends TestBase{
	
	
	/*******************************************************************************************/
	public static ReportPropertiesReader objTestData = new ReportPropertiesReader();
	private final Logger log = LoggerFactory.getLogger(ExtentReportUtility.class);
	/*******************************************************************************************/
	
	
	
	/**
	 * @description Set AssignDevice
	 * @author 703306684
	 * @since 13052024
	 * @param spark (ExtentSparkReporter)
	 * @return
	 * @return flag (boolean) : Flag for change in order of report parameters
	 */

	public ExtentReports assignReportProperties(ExtentReports extent, String browser , int noOfTestCases) {

		InetAddress localHost = null;

		try {
			localHost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// Add User Name
		String property = "Total TCs";
		String value = ""+noOfTestCases;;
		extent.setSystemInfo(property, value );
		
		
		// Add User Name
		 property = "User";
		 value = System.getProperty("user.name");
		extent.setSystemInfo(property, value);

		// Add IP Address
		property = "IP Address";
		value = localHost.getHostAddress();
	//	value = "<h6 style=\"font-size:13px ; text-align:left; color: #4B4645;\">" + value + "</h6>";
		extent.setSystemInfo(property, value);

		// Add Country
		property = "Country Code";
		value = System.getProperty("user.country");
		extent.setSystemInfo(property, value);

		// Add Time Zone
		property = "Time Zone";
		value = System.getProperty("user.timezone");
		extent.setSystemInfo(property, value);

		// Add Operating System
		property = "Operating System";
		try {
			value = (System.getProperty("sun.desktop").toUpperCase());
		}
		catch (Exception e) {
			value=System.getProperty("os.name");
		}
		log.info("Os is :"+value);
		if (value.equalsIgnoreCase("unix")) {
			value = "<svg width=\"22px\" height=\"22px\" fill=\"#4B4645\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"currentColor\"><path d=\"M8.66784 19.2731L9.67371 17.5309C12.4214 18.6911 15.6673 17.6497 17.1971 15C17.6099 14.2851 17.8588 13.5206 17.9555 12.75H19.9677C19.8637 13.8618 19.5241 14.9695 18.9292 16C18.5267 16.6971 18.035 17.3108 17.477 17.8349C16.8385 17.6413 16.1244 17.7022 15.501 18.0621C14.8783 18.4216 14.4688 19.0086 14.3168 19.6575C12.4998 20.2066 10.4923 20.1118 8.66784 19.2731ZM7.3688 18.5231C5.73024 17.3624 4.64445 15.6713 4.21148 13.8232C4.69743 13.3671 5.00098 12.719 5.00098 12C5.00098 11.2801 4.69669 10.6312 4.20973 10.1751C4.38459 9.42975 4.67025 8.69715 5.07277 7.99995C5.66768 6.96954 6.4572 6.12154 7.3681 5.47557L8.3742 7.2182C7.75517 7.68729 7.21755 8.28509 6.80482 8.99995C5.27497 11.6497 5.996 14.9814 8.37467 16.7809L7.3688 18.5231ZM8.66779 4.72671C10.4122 3.92909 12.4225 3.76619 14.3163 4.34045C14.4679 4.99011 14.8776 5.57789 15.501 5.93778C16.1243 6.29766 16.8382 6.3586 17.4766 6.16508C18.9209 7.51805 19.785 9.34047 19.9664 11.25H17.9542C17.7265 9.45286 16.6908 7.77941 15.001 6.8038C13.3112 5.82819 11.3441 5.76797 9.67386 6.46927L8.66779 4.72671ZM16.001 5.07175C15.2835 4.65754 15.0377 3.74015 15.4519 3.02271C15.8662 2.30527 16.7835 2.05946 17.501 2.47367C18.2184 2.88789 18.4642 3.80527 18.05 4.52271C17.6358 5.24015 16.7184 5.48596 16.001 5.07175ZM4.00098 12C4.00098 12.8284 3.3294 13.5 2.50098 13.5C1.67255 13.5 1.00098 12.8284 1.00098 12C1.00098 11.1715 1.67255 10.5 2.50098 10.5C3.3294 10.5 4.00098 11.1715 4.00098 12ZM16.001 18.9282C16.7184 18.5139 17.6358 18.7598 18.05 19.4772C18.4642 20.1946 18.2184 21.112 17.501 21.5262C16.7835 21.9404 15.8662 21.6946 15.4519 20.9772C15.0377 20.2598 15.2835 19.3424 16.001 18.9282Z\"></path></svg> <h6 style=\"font-size:13px ; text-align:left; color: #4B4645;\">Unix</h6>";
			extent.setSystemInfo(property, value);
		} else if (value.equalsIgnoreCase("windows")) {
			value = "<svg fill=\"#4B4645\" width=\"22px\" height=\"22px\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"currentColor\"><path d=\"M3.00098 5.47902L10.3778 4.4625V11.5902H3.00098V5.47902ZM3.00098 18.521L10.3778 19.5375V12.4982H3.00098V18.521ZM11.1894 19.646L21.001 21V12.4982H11.1894V19.646ZM11.1894 4.35402V11.5902H21.001V3L11.1894 4.35402Z\"></path></svg> <h6 style=\"font-size:13px ; text-align:left; color: #4B4645;\">Windows</h6>";
			extent.setSystemInfo(property, value);
		}
		
		else {
			value="Unknown";
		}

		// ADD OS Version
		property = "OS Version";
		value =( System.getProperty("os.name").toUpperCase());
		extent.setSystemInfo(property, value);

		// Add JAVA Version
		property = "JAVA Version";
		value = System.getProperty("java.version");
		extent.setSystemInfo(property, value);

		property = "Browser";
		value =( browser.toUpperCase());
		if (value.equalsIgnoreCase("chrome")) {
			value = "<svg width=\"22px\" height=\"22px\" fill=\"#4B4645\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"currentColor\"><path d=\"M9.82726 21.7633C5.34912 20.7712 2 16.7767 2 12C2 10.1779 2.48734 8.46958 3.33878 6.99834L7.62189 14.4169C8.47396 15.9571 10.1152 17 12 17C12.2023 17 12.4018 16.988 12.5978 16.9646L9.82726 21.7633ZM12 22L16.2868 14.5751C16.7396 13.8229 17 12.9419 17 12C17 10.8744 16.6281 9.83566 16.0004 9H21.5422C21.8396 9.94704 22 10.9548 22 12C22 17.5228 17.5228 22 12 22ZM14.5721 13.545C14.0473 14.4168 13.0917 15 12 15C10.8897 15 9.92024 14.3968 9.40149 13.5002L9.37313 13.4501C9.13535 13.0203 9 12.526 9 12C9 10.3431 10.3431 9 12 9C13.6569 9 15 10.3431 15 12C15 12.5465 14.8539 13.0589 14.5985 13.5002L14.5721 13.545ZM4.6322 5.23859C6.46008 3.24783 9.08432 2 12 2C15.7014 2 18.9331 4.01099 20.6622 7H12C9.93635 7 8.1647 8.25019 7.40112 10.0345L4.6322 5.23859Z\"></path></svg> <h6 style=\"font-size:13px ; text-align:left; color: #4B4645;\">Chrome</h6>";
			extent.setSystemInfo(property, value);
		}

		else if (value.equalsIgnoreCase("firefox")) {
			value = "<svg width=\"22px\" height=\"22px\" fill=\"#4B4645\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"currentColor\"><path d=\"M12.001 2C17.5238 2 22.001 6.47715 22.001 12C22.001 17.5228 17.5238 22 12.001 22C6.47813 22 2.00098 17.5228 2.00098 12C2.00098 10.5365 2.31538 9.14635 2.88033 7.89353C3.34744 6.95503 4.11409 6.01955 4.73082 5.7004C4.07759 6.98266 3.75823 8.24073 3.69049 9.08266C4.14533 7.58266 5.00622 6.32621 6.21106 5.43911C8.27719 3.92016 11.059 3.85202 12.1671 4.81976C10.1107 5.52581 7.87073 8.36653 8.36428 11.6952C8.44419 12.2447 8.60906 12.7785 8.85299 13.2774C8.46912 12.2661 8.43525 10.8435 9.05461 9.91935C9.74654 8.88911 10.7332 8.67137 11.2607 8.78266C11.0526 8.73911 10.5929 9.61936 10.5252 9.77419C10.3523 10.1679 10.2664 10.5943 10.2736 11.0242C10.2888 11.9223 10.6594 12.7778 11.3042 13.4032C13.2256 15.2754 16.3268 14.5387 17.7155 12.4016C18.6687 10.9306 18.7848 8.43427 17.5607 6.4504C17.2554 5.96696 16.8913 5.52325 16.4768 5.12944C14.6262 3.36387 11.9979 2.56054 9.49503 2.92549C8.38907 3.10214 7.44765 3.42052 6.67077 3.88065C7.75554 2.79776 9.9123 2 12.001 2Z\"> </path></svg><h6 style=\"font-size:13px ; text-align:left; color: #4B4645;\">Firefox</h6>";
			extent.setSystemInfo(property, value);
		}

		return extent;

	}

	/**
	 * @description Set the order of tabs in an extent report
	 * @author 703306684
	 * @since 08052024
	 * @param spark (ExtentSparkReporter)
	 * @return flag (boolean) : Flag for change in order of report parameters
	 */
	public boolean setReportOrderNTitle(ExtentSparkReporter spark, String suiteName) {
		boolean flag = false;

		try {
			String title = "Suite: " + suiteName;
			spark.config().setDocumentTitle(suiteName);
			spark.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY,
					ViewName.DEVICE, ViewName.AUTHOR, ViewName.EXCEPTION, ViewName.LOG }).apply();

			flag = true;
		} catch (Exception e) {
			log.error("Error setting order of Extent Report :" + e);
		}
		return flag;
	}

	/**
	 * @description Set there for the extent report
	 * @author 703306684
	 * @since 08052024
	 * @param spark (ExtentSparkReporter)
	 * @param theme (String) : Type of these to be selected from Dark/Standard
	 */
	public boolean setTheme(ExtentSparkReporter spark) {
		boolean flag = false;
		boolean isDataPresent=false;
		String extentReportStyle=null;
		try {
			
			HashMap<String, String> dataSheetProperties = objTestData.getDataSheetProperties();
			final HashMap<String, String> masterData = objTestData.getMasterData(dataSheetProperties.get("FileName"),
					dataSheetProperties.get("MasterSheetName"));
			
			extentReportStyle =masterData.get("Extent Report Style");
			if (extentReportStyle!=null && extentReportStyle!= "")
				
				isDataPresent=true;


		} catch (Exception e) {
			log.warn("No Data found in excel data sheet for report style Error:"+e);
			log.info("Setting Theme: STANDARD");
			spark.config().setTheme(Theme.STANDARD);
		}
		
		if (isDataPresent) {
		
			// Selecting Theme
			if(extentReportStyle.equalsIgnoreCase("STANDARD"))
				spark.config().setTheme(Theme.STANDARD);
			else if (extentReportStyle.equalsIgnoreCase("DARK"))
				spark.config().setTheme(Theme.DARK);
			else
				spark.config().setTheme(Theme.STANDARD);
			flag =true;
		}
		
		return flag;
	}

	/**
	 * @description Create a Label for extent report with given color (Default :
	 *              BLUE)
	 * @author 703306684
	 * @since 08052024
	 * @param label (String): Label text
	 * @param color (String) : color of the label
	 * @return Markup
	 */
	public Markup getMarkupCustomLabel(String label, ExtentColor color) {
		Markup markup = null;

		try {
			markup = MarkupHelper.createLabel(label, color);

		} catch (Exception e) {
			log.error("Error creating custom Label :" + label + "\nError:" + e);
		}

		return markup;
	}

	/**
	 * @description Create a Label for extent report with given color (Default :
	 *              BLUE)
	 * @author 703306684
	 * @since 08052024
	 * @param label (String): Label text
	 * @param color (String) : color of the label
	 * @return Markup
	 */
	public Markup getMarkupCodeBlock(String code, CodeLanguage lang) {
		Markup markup = null;

		try {
			markup = MarkupHelper.createCodeBlock(code, lang);

		} catch (Exception e) {
			log.error("Error creating code paceholder in extent report\n" + lang + " code :" + code);
		}

		return markup;
	}

	/**
	 * @description Create a Table for extent report with given data
	 * @author 703306684
	 * @since 08052024
	 * @param data (String [][]): 2D array for table key value pairs
	 * @return Markup : table to be added to extent report
	 */

	public Markup getMarkupTabel(String[][] data) {
		try {
			return MarkupHelper.createTable(data);
		} catch (Exception e) {
			log.error("Error creating markup table for the extent report\nDATA =" + data + "\nERROR :" + e);
			return null;
		}
	}

	/**
	 * @description Create a List (Ordered) for extent report with given data
	 * @author 703306684
	 * @since 08052024
	 * @param items (List<String>): List of Objects to be added to the list
	 * @return OrderedList : OrderedList object
	 */

	public Markup getMarkupOrderedList(List<String> items) {
		try {
			return MarkupHelper.createOrderedList(items);
		} catch (Exception e) {
			log.error("Error creating markup Ordered List for the extent report\nItems =" + items + "\nERROR :" + e);
			return null;
		}
	}

	/**
	 * @description Create a List (Un-Ordered) for extent report with given data
	 * @author 703306684
	 * @since 08052024
	 * @param items (List<String>): List of Objects to be added to the list
	 * @return UnorderedList : UnorderedList object
	 */

	public Markup getMarkupUnOrderedList(List<String> items) {
		try {
			return MarkupHelper.createUnorderedList(items);
		} catch (Exception e) {
			log.error("Error creating markup Ordered List for the extent report\nItems =" + items + "\nERROR :" + e);
			return null;
		}
	}

	/**
	 * @description Create a test case record (ExtentTest) to be added to Extent
	 *              Report
	 * @author 703306684
	 * @since 08052024
	 * @param extent   (ExtentReports) : ExtentReports object
	 * @param caseName (String) : Name of test case
	 * @param caseDesc (String) : Description of test case
	 * @return ExtentTest : ExtentTest object
	 */

	public static ExtentTest createTestWithTitleDesc(ExtentReports extent, String className, String caseName, String caseDesc) {

		try {
			ExtentTest test= extent.createTest("Test Case #"+testCaseCounter++ +" :("+className+")-> "+caseName," <h6 style=\"font-size:13px ; text-align:left; color: #0070D7; \"><b><u> TC Description</u> : </b>"
							+ caseDesc);
		//	logStep(test, Status.INFO, "Execution started for test case :"+caseName);
			
//			// Incresing counter from Test Base
//			testCaseCounter++;
			
			return test;
		} catch (Exception e) {
//			log.error("Error creating test in Extent Report\nTest Case Name :" + caseName + "\nTest Case Description :"
//					+ caseDesc);
			return null;
		}
	}

	/**
	 * @description Assign a Device Name to the test
	 * @author 703306684
	 * @since 08052024
	 * @param ExtentTest : ExtentTest object
	 * @param deviceName (String) : Name of Device to be assigned to the case
	 * @return boolean : flag
	 */

	public boolean assignDeviceToTest(ExtentTest test, String deviceName) {
		boolean flag = false;

		try {
			test.assignDevice(deviceName);
			flag = true;
		} catch (Exception e) {
			log.error("Error assigning device to test \nDevice Name : " + deviceName + "\nError :" + e);
		}
		return flag;
	}

	/**
	 * @description Assign a Test Category Name to the test
	 * @author 703306684
	 * @since 08052024
	 * @param ExtentTest : ExtentTest object
	 * @param category   (String) : Test category to be assigned to the case
	 * @return boolean : flag
	 */

	public boolean assignSeverityToTest(ExtentTest test, ExtentTestLevel severity) {
		boolean flag = false;

		try {
			
			test.assignCategory( (severity.toString()));
			flag = true;
		} catch (Exception e) {
			log.error("Error assigning Severity to test \nSeverity : " + severity + "\nError :" + e);
		}
		return flag;
	}

	/**
	 * @description Assign a Test Category Name to the test
	 * @author 703306684
	 * @since 08052024
	 * @param ExtentTest : ExtentTest object
	 * @param author     (String) : Author to be assigned to the case
	 * @return boolean : flag
	 */

	public boolean assignAuthorToTest(ExtentTest test, String author) {
		boolean flag = false;

		try {
			test.assignAuthor(author);
			flag = true;
		} catch (Exception e) {
			log.error("Error assigning Author to test \nAuthor : " + author + "\nError :" + e);
		}
		return flag;
	}

	/**
	 * @description Assign a Property to the test
	 * @author 703306684
	 * @since 08052024
	 * @param extent   (ExtentReports) : ExtentReports object
	 * @param property (String) : Property Key to be assigned to the Report
	 * @param property (String) : Value of property to be assigned to the Report
	 * @return boolean : flag
	 */

	public boolean assignPropertyToReport(ExtentReports extent, String property, String propValue) {
		boolean flag = false;

		try {
			extent.setSystemInfo(property, propValue);
			flag = true;
		} catch (Exception e) {
			log.error("Error assigning Property to Report \nProperty : " + property + "  Value :" + propValue
					+ "+\nError :" + e);
		}
		return flag;
	}

	/**
	 * @description Log a step with Step Status . Step Detail, Throwable Exception,
	 *              Media
	 * @author 703306684
	 * @since 10052024
	 * @param test    (ExtentTest) : ExtentTest object
	 * @param status  (Status) : Status of test step
	 * @param details (String) : Description for test step
	 * @param t       (Throwable) : Throwable objects
	 * @param media   (Media) : Media object to attach to report
	 * @return boolean : flag
	 */

	public boolean logStep(ExtentTest test, Status status, String details, Throwable t, Media media) {
		boolean flag = false;

		try {
			if (status.equals(Status.FAIL)) {
			//	generateTopLog(test, Status.FAIL, "The test has encountered one or more failures. Please review the steps for additional details.");
				test.log(status,
						" <h6 style=\"font-size:13px ; text-align:left; color: #E02300;\"><b><u>TEST STEP FAILED </u></b></h6> <h6 style=\"font-size:13px ; text-align:left; color: #E02300;\"><i>  "
								+ details + "</i></h6>",
						t, media);
				flag = true;
			}

			else if (status.equals(Status.WARNING)) {
				test.log(status, " <b> <u>WARNING </u> :</b> " + details, t, media);
				flag = true;
			}

			else {
				test.log(status, details, t, media);
				flag = true;
			}

		} catch (Exception e) {
			log.error("Error Logging test setep\n Status :" + status + " Step Detail: " + details
					+ " Thowable Exception for step: " + t + "Media :" + media + "\nException :" + e);
		}
		return flag;
	}

	/**
	 * @description Log a step with Step Status . Step Detail, Media
	 * @author 703306684
	 * @since 10052024
	 * @param test    (ExtentTest) : ExtentTest object
	 * @param status  (Status) : Status of test step
	 * @param details (String) : Description for test step
	 * @param media   (Media) : Media object to attach to report
	 * @return boolean : flag
	 */

	public boolean logStep(ExtentTest test, Status status, String details, Media media) {
		boolean flag = false;

		try {

			if (status.equals(Status.FAIL)) {
		//		generateTopLog(test, Status.FAIL, "The test has encountered one or more failures. Please review the steps for additional details.");
				test.log(status,
						" <h6 style=\"font-size:13px ; text-align:left; color: #E02300;\"><b><u>TEST STEP FAILED </u></b></h6> <h6 style=\"font-size:13px ; text-align:left; color: #E02300;\"><i>  "
								+ details + "</i></h6>",
						media);
				flag = true;
			}

			else if (status.equals(Status.WARNING)) {
				test.log(status, " <b> <u>WARNING </u> :</b> " + details, media);
				flag = true;
			}

			else {
				test.log(status, details, media);
				flag = true;
			}

		} catch (Exception e) {
			log.error("Error Logging test setep\n Status :" + status + " Step Detail: " + details + "Media :" + media
					+ "\nException :" + e);
		}
		return flag;
	}

	/**
	 * @description Log a step with Step Status . Step Detail, Media
	 * @author 703306684
	 * @since 10052024
	 * @param test   (ExtentTest) : ExtentTest object
	 * @param status (Status) : Status of test step
	 * @param media  (Media) : Media object to attach to report
	 * @return boolean : flag
	 */

	public boolean logStep(ExtentTest test, Status status, Media media) {
		boolean flag = false;

		try {
			test.log(status, media);
			flag = true;
		} catch (Exception e) {
			log.error("Error Logging test setep\n Status :" + status + "Media :" + media + "\nException :" + e);
		}
		return flag;
	}

	/**
	 * @description Log a step with Step Status . Step Detail, Throwable
	 * @author 703306684
	 * @since 10052024
	 * @param test    (ExtentTest) : ExtentTest object
	 * @param status  (Status) : Status of test step
	 * @param details (String) : Description for test step
	 * @return boolean : flag
	 */

	public boolean logStep(ExtentTest test, Status status, String details) {
		boolean flag = false;

		try {
			if (status.equals(Status.FAIL)) {
		//		generateTopLog(test, Status.FAIL, "The test has encountered one or more failures. Please review the steps for additional details.");
				test.log(status,
						" <h6 style=\"font-size:13px ; text-align:left; color: #E02300;\"><b><u>TEST STEP FAILED </u></b></h6> <h6 style=\"font-size:13px ; text-align:left; color: #E02300;\"><i>  "
								+ details + "</i></h6>");
				flag = true;
			}

			else if (status.equals(Status.WARNING)) {
				test.log(status, " <b> <u> ⛔ WARNING ⛔</u> :</b> " + details);
				flag = true;
			}
			
			else if (status.equals(Status.SKIP)) {
				test.log(status, " <b> <u> ⚠️ TEST CASE SKIPPED ⚠️</u> :</b> " + details);
				flag = true;
			}

			else {
				test.log(status, details);
				flag = true;
			}

		} catch (Exception e) {
			log.error(
					"Error Logging test setep\n Status :" + status + " Step Detail: " + details + "\nException :" + e);
		}
		return flag;
	}

	/**
	 * @description Log a step with Step Status . Step Detail, Markup , Media
	 * @author 703306684
	 * @since 10052024
	 * @param test   (ExtentTest) : ExtentTest object
	 * @param status (Status) : Status of test step
	 * @param markup (Markup) : Markup object
	 * @return boolean : flag
	 */

	public boolean logStep(ExtentTest test, Status status, Markup markup) {
		boolean flag = false;

		try {
			test.log(status, markup);
			flag = true;
		} catch (Exception e) {
			log.error("Error Logging test setep\n Status :" + status + "Markup :+" + markup + " \nException :" + e);
		}
		return flag;
	}

	/**
	 * @description Log a step with Step Status, Throwable Exception, Media
	 * @author 703306684
	 * @since 10052024
	 * @param test   (ExtentTest) : ExtentTest object
	 * @param status (Status) : Status of test step
	 * @param t      (Throwable) : Throwable objects
	 * @param media  (Media) : Media object to attach to report
	 * @return boolean : flag
	 */

	public boolean logStep(ExtentTest test, Status status, Throwable t, Media media) {
		boolean flag = false;

		try {
			test.log(status, t, media);
			flag = true;
		} catch (Exception e) {
			log.error("Error Logging test setep\n Status :" + status + " Thowable Exception for step: " + t + "Media :"
					+ media + "\nException :" + e);
		}
		return flag;
	}

	/**
	 * @description Log a step with Step Status . Step Detail, Throwable Exception,
	 *              Media
	 * @author 703306684
	 * @since 10052024
	 * @param test   (ExtentTest) : ExtentTest object
	 * @param status (Status) : Status of test step
	 * @param t      (Throwable) : Throwable objects
	 * @return boolean : flag
	 */

	public boolean logStep(ExtentTest test, Status status, Throwable t) {
		boolean flag = false;

		try {
			test.log(status, t);
			flag = true;
		} catch (Exception e) {
			log.error("Error Logging test setep\n Status :" + status + " Thowable Exception for step: " + t
					+ "\nException :" + e);
		}
		return flag;
	}

	/**
	 * @description Add top level logs to a test
	 * @author 703306684
	 * @since 10052024
	 * @param test    (ExtentTest) : ExtentTest object
	 * @param status  (Status) : Status of test step
	 * @param details (String) : Log details
	 * @return boolean : flag
	 */

	public boolean generateTopLog(ExtentTest test, Status status, String details) {
		boolean flag = false;

		try {
			if (status.equals(Status.FAIL)) {
				test.generateLog(status,
						" <h6 style=\"font-size:13px ; text-align:left; color: #E02300;\"><b><u>TEST STEP FAILED </u></b></h6> <h6 style=\"font-size:13px ; text-align:left; color: #E02300;\"><i>  "
								+ details + "</i></h6>");
				flag = true;
			}

			else if (status.equals(Status.WARNING)) {
				test.generateLog(status, " <b> <u>WARNING </u> :</b> " + details);
				flag = true;
			}

			else {
				test.generateLog(status, details);
				flag = true;
			}

		} catch (Exception e) {
			log.error("Error generating top log  \n Status :" + status + " Details : " + details + "\nException :" + e);
		}
		return flag;
	}

	/**
	 * @description Add top level logs to a test
	 * @author 703306684
	 * @since 10052024
	 * @param test   (ExtentTest) : ExtentTest object
	 * @param status (Status) : Status of test step
	 * @param markup (Markup) : Markup Objects
	 * @return boolean : flag
	 */

	public boolean generateTopLog1(ExtentTest test, Status status, Markup markup) {
		boolean flag = false;

		try {
			test.generateLog(status, markup);
			flag = true;
		} catch (Exception e) {
			log.error("Error generating top log  \n Status :" + status + " Markup : " + markup + "\nException :" + e);
		}
		return flag;
	}

	/**
	 * @description Generate report
	 * @author 703306684
	 * @since 10052024
	 * @param extent (ExtentReports) : ExtentReports object
	 * @return boolean : flag
	 */

	public boolean generateReport(ExtentReports extent) {
		boolean flag = false;

		try {
			extent.flush();
			flag = true;
		} catch (Exception e) {
			log.error("Error generating report \nException :" + e);
		}
		return flag;
	}

	/**
	 * @description log step with SS
	 * @author 703306684
	 * @since 1505204
	 * @param driver (WebDriver) : WebDriver instance
	 * @param extent (ExtentReports) : ExtentReports instance
	 * @param status (Status) : Status of test
	 * @param details (String) : Details of test step
	 * @return boolean : flag
	 */

	public boolean logStepWithSS(WebDriver driver, ExtentTest test, Status status, String details) {

		boolean flag = false;
		try {

			// Takse screenshot
	//		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotFileNew = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			// Save screenshot
	//		String pathForReport = "Extent_SSDump" + File.separator + GetTimeStampValue() + " _Screenshot.png";
	//		String filePath = "Extent Report" + File.separator + pathForReport;
	//		FileUtils.copyFile(screenshotFile, new File(filePath));


			// Logging into Extent report with Screenshot
	//		logStep(test, status, details, MediaEntityBuilder.createScreenCaptureFromPath(pathForReport).build());
			logStep(test, status, details, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotFileNew).build());
			flag = true;
		} 
		
		catch (Exception e) {
			log.error("Errro capturing SS for Extent Report", e);
			logStep(test, Status.WARNING, "Errro capturing SS for Extent Report");
			logStep(test, Status.WARNING, e);
		}
		
		return flag;
	}

	
	
	/**
	 * @description Give current data time
	 * @author 703306684
	 * @since 1505204
	 * @return systime
	 */
	public static String GetTimeStampValue() {

		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString();
		String systime = timestamp.replace(":", "-");
		return systime;

	}
	
	/**
	 * @description : Assign  test case specific properties
	 * @param test : Extent Test instance
	 * @param author : name of author of test case
	 * @param severity : severity of test case
	 */
	
	public void assignTestCaseProperties(ExtentTest test,  String author , ExtentTestLevel severity )
	{
		assignAuthorToTest(test, author);
		String deviceName=null;
		try {
			deviceName=System.getProperty("sun.desktop");
		}
		catch (Exception e) {
			deviceName=System.getProperty("os.name");
		}
		
		if(deviceName==null)
		{
			deviceName="Unknown";
		}
		
		assignDeviceToTest(test, deviceName);
		assignSeverityToTest(test, severity);

	}
}
