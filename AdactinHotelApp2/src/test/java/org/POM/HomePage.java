package org.POM;
import org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement username;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(id="login")
	private WebElement login;
	
	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLogin() {
		return login;
	}
	
	public void HomePageOperations() {
		
		WebElement username2 = getUsername();
		sendingKeys(username2, readExcel(0,1));
		WebElement password2 = getPassword();
		sendingKeys(password2, readExcel(1,1));
		WebElement login2 = getLogin();
		click(login2);
	}
	
	}

