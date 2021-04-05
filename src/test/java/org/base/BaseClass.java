package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver lancuhChromeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91908\\eclipse-workspace\\SeleniumJava\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		return driver;
	}

	public static WebDriver lancuhFirefoxBrowser() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\91908\\eclipse-workspace\\SeleniumJava\\Drivers\\geckodriver.exe");

       driver = new FirefoxDriver();

		return driver;

	}

	public static WebDriver lancuhEdgeBrowser() {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\91908\\eclipse-workspace\\SeleniumJava\\Drivers\\msedgedriver.exe");

        driver = new EdgeDriver();

		return driver;

	}

	public static void takeScreenShot(String name) throws IOException {
		TakesScreenshot tss= (TakesScreenshot) driver;
		File screenshotAs = tss.getScreenshotAs(OutputType.FILE);
		File resorce = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenShot\\"+name+".png");
		FileUtils.copyDirectory(screenshotAs, resorce);
	}
	
	public static void selectDate(String date, WebElement e, WebElement e1) throws InterruptedException {
		String[] split = date.split("-");
		String dt = split[0];
		String mon = split[1];
		for (int i = 0; i < 15; i++) {
			String month = e.getText();
			if (month.equals(mon)) {
				break;	
			}
			WebElement next = e1;
			clickWithjavaScript(next);
			
		}
		driver.findElement(By.linkText(dt)).click();
		
		
		
	}
	public static void selectDocument(WebElement e, String t) {
		WebElement selectDocument = e;
		Select s = new Select(selectDocument);
		s.selectByVisibleText(t);
	}
	
	public static void max() {

		driver.manage().window().maximize();
	}

		public static void fillTextBox(WebElement e, String s) {
		e.sendKeys(s);
	}

		public static void Quit() {
		driver.quit();
	}

	public static void scrolldown() {

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,1000)");

	}

	public static void scrollup() {

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,-1000)");

	}

	public static void clickWithjavaScript(WebElement e)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",e);
	}
	
	public static void waitUntillExecute() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public static void waitTillElementVisible(WebElement e, String name) throws IOException {
		WebDriverWait w = new WebDriverWait(driver, 50);
		w.until(ExpectedConditions.visibilityOf(e));
		takeScreenShot(name);
	
	}
	
	
  public static String dataDriven(int Rowno, int cellno) throws IOException {
	  
	  File loc = new File("C:\\Users\\91908\\eclipse-workspace\\Lennvox\\src\\test\\resources\\Data.xlsx");
		
		FileInputStream f= new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(f);
		Sheet sheet = w.getSheet("sheet1");
		Row r = sheet.getRow(Rowno);
		Cell c= r.getCell(cellno);
		int type=c.getCellType();
		String value =null;
			if (type==1) {
				
				value= c.getStringCellValue();
				
			}
				
			else if (DateUtil.isCellInternalDateFormatted(c)) {
				
				Date date= c.getDateCellValue();
				SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyy");
				value = sf.format(date);
				
			}
			else {
				
				double db = c.getNumericCellValue();
				long lg= (long) db;
				value = String.valueOf(lg);
				
			}
			return value;

	

}
}