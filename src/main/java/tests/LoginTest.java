package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class LoginTest extends BaseTest{
	
	@Parameters({"user", "pass"})
	@Test(priority = 1, groups = "LoginFunctionality")
	public void loginTest(String username, String parola) throws InterruptedException {
		
		NavMenuPage navMenu= new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);

		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginInApp(username, parola);

		//varianta1
		assertTrue(loginPage.loginSuccessMessageIsDisplayed());
		//varianta2
		assertTrue(loginPage.loginMessageIsDisplayed(loginPage.loginSuccessMessage));
	    loginPage.logoutFromApp();
	}

	@Parameters({"invalidUser", "invalidPass"})
//	@Parameters({"user", "pass"})
	@Test(priority = 2, groups = "LoginFunctionality")
	public void invalidLoginTest(String username, String parola) throws InterruptedException {
		
		NavMenuPage navMenu= new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);

		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginInApp(username, parola);

		//varianta1
		assertTrue(loginPage.loginErrorMessageIsDisplayed());
		//varianta2
		assertTrue(loginPage.loginMessageIsDisplayed(loginPage.loginErrorMessage));
	}
}
