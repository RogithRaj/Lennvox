package org.lennvox;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMLogin extends BaseClass {
	
	public POMLogin() {
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(linkText="Sign In")
	private WebElement signIn;
	
	@FindBy(id="j_username")
	private WebElement username;
	
	@FindBy(id="j_password")
	private WebElement password;
	
	@FindBy(id="loginSubmit")
	private WebElement submit;

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	
}
