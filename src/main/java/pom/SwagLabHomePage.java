package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabHomePage {
	@FindBy (xpath="//input[@id='user-name']")private WebElement userName;
	@FindBy (xpath="//input[@id='password']")private WebElement password;
	@FindBy (xpath="//input[@id='login-button']")private WebElement login;
}
