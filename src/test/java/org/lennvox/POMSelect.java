package org.lennvox;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMSelect extends BaseClass {
	
	public POMSelect() {
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//i[@class='far fa-bars v2-hamburger-menu']")
	private WebElement selectOption;
	
	@FindBy(xpath="(//a[@class='btn-v2'])[7]")
	private WebElement selectSalesTool;
	
	@FindBy(xpath="(//a[@data-moby='show'])[1]")
	private WebElement bulidAProspal;
	
	@FindBy(linkText="SELECT LEAD")
	private WebElement selectLead;
	
	@FindBy(xpath="//a[@class='btn btn-primary hide-mobile introjs-l-9 introjs-l-83']")
	private WebElement addLead;

	public WebElement getSelectOption() {
		return selectOption;
	}

	public WebElement getSelectSalesTool() {
		return selectSalesTool;
	}

	public WebElement getBulidAProspal() {
		return bulidAProspal;
	}

	public WebElement getSelectLead() {
		return selectLead;
	}

	public WebElement getAddLead() {
		return addLead;
	}
	
	
}
