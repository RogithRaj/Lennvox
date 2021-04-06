package org;

import java.io.IOException;

import org.base.BaseClass;
import org.lennvox.DataFromExcel;
import org.lennvox.POMFillTheForm;
import org.lennvox.POMLogin;
import org.lennvox.POMSelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LennvoxRun extends BaseClass{
	
	@BeforeMethod
	private void startBrowser() {

			lancuhChromeBrowser();
			driver.get("https://www.liidaveqa.com/");
			max();
			waitUntillExecute();
		
	}	
	@Test(dataProvider="data", dataProviderClass=DataFromExcel.class)
	private void testRun(String user, String pass, String firstName,String lastName,String phone , String mailid, String date, String docpath,  String img ) throws IOException, InterruptedException {
		
		
		POMLogin p= new POMLogin();
		p.getSignIn().click();
		p.getUsername().sendKeys(user);
		p.getPassword().sendKeys(pass);
		p.getSubmit().click();
		
		POMSelect pp= new POMSelect();
		pp.getSelectOption().click();
		pp.getSelectSalesTool().click();
		clickWithjavaScript(pp.getBulidAProspal());
		clickWithjavaScript(pp.getSelectLead());
		clickWithjavaScript(pp.getAddLead());
		
		POMFillTheForm pf= new POMFillTheForm();
		pf.getFirstName().sendKeys(firstName);
		pf.getLastName().sendKeys(lastName);
		pf.getEmail().sendKeys(mailid);
		pf.getPhno().sendKeys(phone);
		pf.getSchedulingRequestDate().click();
		selectDate(date, pf.getMonth(), pf.getNextMonth());
		
		pf.getAddDocu().click();
		selectDocument(pf.getdocumentType(), "OTHER");
		String path = System.getProperty("user.dir");
		pf.getSelect().sendKeys(path+docpath);
		clickWithjavaScript(pf.getAddingDounmentToLead());
		pf.getAddingImage().sendKeys(path+img);
		Thread.sleep(7000);
		clickWithjavaScript(pf.getSubmit());
		waitTillElementVisible(pf.getLeadAdd(), firstName);
		takeScreenShot(firstName);
	}
	
	@AfterMethod
	private void quitBrowser() {

		Quit();
		
	}
	
}
