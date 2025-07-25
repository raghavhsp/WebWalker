
/*
 *AP Flow(Product specific) class to contains Business Functions Of extracting data from an excel file.
 *
 *@author 703260622 ATHARVA GUPTA
 *@since 05042024
 *@version 1.0
 */

package Utils.ExtentReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Utils.File.PropertiesFileUtils;
import Utils.Test.TestBase;
import io.qameta.allure.Step;


public class ReportPropertiesReader {

	private final Logger log = LoggerFactory.getLogger(ReportPropertiesReader.class);
	public ExtentReportUtility extentUtilObj = new ExtentReportUtility();
	public static TestBase objTestBase = new TestBase();
	public PropertiesFileUtils propUtils= new PropertiesFileUtils();

	

	/**
	 * @description This function is used to get User Name , Password & Url from
	 *              excel file
	 * @since 05042024
	 * @author Raghav Agnihotri
	 * 
	 * @param excelFileName - Excel file Name
	 * @param sheetName     - Excel sheet Name
	 * @return credentials : HashMap of User Name , Password & Url
	 */
	@Step("Getting User Name, Password & Url from Master Sheet of Test Data File.")
	public HashMap<String, String> getMasterData(String excelFileName, String sheetName) {

		try {
			if (excelFileName != null && !excelFileName.isEmpty() && sheetName != null && !sheetName.isEmpty())
				log.info("Attempting to get User Name, Password & Url from \nSheet: " + sheetName + "\nFile: "
						+ excelFileName);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("The Test Data File Name OR Sheet Name value is null. \nError: " + e);
		}
		HashMap<String, String> credentials = new HashMap<String, String>();
		String excelFilePath = "test_data" + File.separator + excelFileName;
		log.info("Test data file path is: " + excelFilePath);
		try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath))) {
			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			log.info("Test data Sheet Name is: " + sheetName);
			// Iterate through each row
			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				// Assuming the first column contains keys and the second column contains values
				Cell keyCell = currentRow.getCell(0);
				Cell valueCell = currentRow.getCell(1);

				if (keyCell != null && !keyCell.getStringCellValue().trim().isEmpty()) {
					String key = keyCell.getStringCellValue().trim();
					if (valueCell == null || valueCell.getStringCellValue().trim().isEmpty()) {
						credentials.put(key, null);
					} else {
						String value = valueCell.getStringCellValue().trim();
						credentials.put(key, value);
					}
				}
			}

			workbook.close();
			inputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error Getting User Name, Password & Url from test data. \nError: " + e);
		}
		return credentials;
	}

	
	public HashMap<String,String> getDataSheetProperties(){
		
		// Declaration
		HashMap<String,String> dataSheetProperties = new HashMap <String, String> ();
		
		// Get Data Sheet properties
		try {
			String fileName = propUtils.getConfigPropertyValue("APFlowTestDataXLS").get();
			String sheetMaster = propUtils.getConfigPropertyValue("APFlowTestDataActiveSheetMaster").get();
			String sheetInvoice = propUtils.getConfigPropertyValue("APFlowTestDataActiveSheetInvoice").get();
			String sheetInvLI = propUtils.getConfigPropertyValue("APFlowTestDataActiveSheetInvoiceLineItem").get();

		// Check for any data sheet name not defined
		if (!(fileName.isBlank() || sheetMaster.isBlank() || sheetInvoice.isBlank() || sheetInvLI.isBlank()) )
		{
			// Load Data sheet properties
			dataSheetProperties.put("FileName", fileName);
			dataSheetProperties.put("MasterSheetName", sheetMaster);
			dataSheetProperties.put("CreateInvoiceDataSheetName", sheetInvoice);
			dataSheetProperties.put("CreateINVLDataSheetName", sheetInvLI);
		}
		
		} catch (Exception e) {
			log.error("Error getting properties of data file :"+e);
			e.printStackTrace();
			return null;
		}
		return dataSheetProperties;
		
	}
	

}
