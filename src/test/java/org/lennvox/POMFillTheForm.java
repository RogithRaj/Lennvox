package org.lennvox;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMFillTheForm extends BaseClass {
	
	public POMFillTheForm() {
		
		PageFactory.initElements(driver, this);
	 	}

	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="email")
	private WebElement phno;
	
	@FindBy(id="phNo")
	private WebElement email;
	
	@FindBy(id="calender1")
	private WebElement schedulingRequestDate;
	
	@FindBy(id="scheduleRequestTime")
	private WebElement scheduleRequestTime;
	
	@FindBy(xpath = "//span[@class=\"ui-datepicker-month\"]")
	private WebElement month;

	@FindBy(xpath = "//a[@class=\"ui-datepicker-next ui-corner-all\"]")
	private WebElement nextMonth;

	@FindBy(xpath = "//p[@class=\"m-0 add-document\"]")
	private WebElement addDocu;

	@FindBy(name = "documents[1].documentType")
	private WebElement documentType;

	@FindBy(id = "multipleFileSelect-1")
	private WebElement select;

	@FindBy(xpath = "//a[@class=\"btn btn-primary mr-15 add-documents-to-page mb-15\"]")
	private WebElement AddingDounmentToLead;

	@FindBy(id = "multipleImageSelect[0]")
	private WebElement AddingImage;

	@FindBy(id = "btn-addLeadsForm")
	private WebElement submit;
	
	@FindBy(xpath = "//h1[@class=\"m-0 mb-15 leads-details-heading introjs-1\"]")
	private WebElement leadAdd;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPhno() {
		return phno;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSchedulingRequestDate() {
		return schedulingRequestDate;
	}

	public WebElement getScheduleRequestTime() {
		return scheduleRequestTime;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getNextMonth() {
		return nextMonth;
	}

	public WebElement getAddDocu() {
		return addDocu;
	}

	public WebElement getdocumentType() {
		return documentType;
	}

	public WebElement getSelect() {
		return select;
	}

	public WebElement getAddingDounmentToLead() {
		return AddingDounmentToLead;
	}

	public WebElement getAddingImage() {
		return AddingImage;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getLeadAdd() {
		return leadAdd;
	}
	

	
	
}
