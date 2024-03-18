package test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.annotations.Listeners;
import pojo.LaunchBrowser;
import pom.SwagLabLoginPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class SwagLabLoginTest extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
@BeforeTest
public void configureReports() {
	reports=Reports.createReports();
}
	
@BeforeMethod
 public void OpenBrowser() {
	driver=LaunchBrowser.chrome("https://www.saucedemo.com/");
}
	@Test
 public void loginWithValidCredentials() {
		test=reports.createTest("loginWithValidCredentials");
	SwagLabLoginPage swagLabLoginPage=new SwagLabLoginPage(driver);
	swagLabLoginPage.enterUserName("standard_user");
	swagLabLoginPage.enterPassword("secret_sauc");
	swagLabLoginPage.clickLogin();	
}
	@Test
public void loginWithLockedOutUser() {
		test=reports.createTest("loginWithLockedOutUser");
	SwagLabLoginPage swagLabLoginPage=new SwagLabLoginPage(driver);
	swagLabLoginPage.enterUserName("locked_out_user");
	swagLabLoginPage.enterPassword("secret_sauce");
	swagLabLoginPage.clickLogin();
}
	@Test
public void loginWithProblemUser() {
		test=reports.createTest("loginWithProblemUser");
	SwagLabLoginPage swagLabLoginPage=new SwagLabLoginPage(driver);
	swagLabLoginPage.enterUserName("problem_user");
	swagLabLoginPage.enterPassword("secret_sauce");
	swagLabLoginPage.clickLogin();
}
	@Test
public void loginWithPerformanceGlitchUser() {
		test=reports.createTest("loginWithPerformanceGlitchUser");
	SwagLabLoginPage swagLabLoginPage=new SwagLabLoginPage(driver);
	swagLabLoginPage.enterUserName("performance_glitch_user");
	swagLabLoginPage.enterPassword("secret_sauce");
	swagLabLoginPage.clickLogin();
}
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
				{
					test.log(Status.SKIP,result.getName());
				}
	}
	@AfterTest
	public void publishReports() {
		reports.flush();
	}
	
//public static void main(String[] args) {
	//SwagLabLoginTest swagLabLoginPage=new SwagLabLoginTest();
	//swagLabLoginPage.loginWithValidCredentials();
	//swagLabLoginPage.loginWithLockedOutUser();
	//swagLabLoginPage.loginWithProblemUser();
	//swagLabLoginPage.loginWithPerformanceGlitchUser();
	
	
}
