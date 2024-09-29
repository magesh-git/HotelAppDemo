package org.baseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;

public class BaseClass {
	
	public static WebDriver driver;

		public void driverIntialization() throws IOException {
			WebDriverManager.chromedriver().setup();
			Properties prop=new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Data.properties");
			prop.load(fis);
			String browser = System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
		    String url = prop.getProperty("url");
			
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(url);
			}
			else if(browser.equals("edge")) {
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.get(url);
			}
	}
		
	public void staticDropDown(WebElement element, String text) {
		Select s= new Select(element);
		try {
			s.selectByValue(text);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendingKeys(WebElement element, String keys) {
		try{
			element.sendKeys(keys);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void click(WebElement element) {	
		try {
			element.click();	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readExcel(int rowNumber,int ColNumber)  {
		String cellValue = null;
		try {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//TestData2.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(ColNumber);
		DataFormatter formatter = new DataFormatter();
		cellValue = formatter.formatCellValue(cell);
		wb.close();
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
		return cellValue;
	}
	
	public void captureScreenShot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(".\\Screenshots\\"+ filename+".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
