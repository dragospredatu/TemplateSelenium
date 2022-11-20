package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import pages.NavMenuPage;
import utils.BaseTest;

public class SocialMediaRedirectTest extends BaseTest{
	
	@Test
	public void socialMediaRedirectTest() throws InterruptedException {
		
		NavMenuPage menu = new NavMenuPage(driver);
		
		menu.navigateTo(menu.facebookButtonTop);
		Thread.sleep(2000);
		List<String> browserTabs1 = new ArrayList<>(driver.getWindowHandles());
		System.out.println("Current handle: " + driver.getWindowHandle());
		System.out.println("The current tab url is: " + driver.getCurrentUrl());
		driver.switchTo().window(browserTabs1.get(1));
		Thread.sleep(2000);
		System.out.println("Current handle: " + driver.getWindowHandle());
		System.out.println("The current tab url is: " + driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/keytraining.ro");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(browserTabs1.get(0));
		
		menu.navigateTo(menu.twitterButtonTop);
		Thread.sleep(1000);
		List<String> browserTabs2 = new ArrayList<>(driver.getWindowHandles());
		System.out.println("Current handle: " + driver.getWindowHandle());
		System.out.println("The current tab url is: " + driver.getCurrentUrl());
		driver.switchTo().window(browserTabs2.get(1));
		Thread.sleep(2000);
		System.out.println("Current handle: " + driver.getWindowHandle());
		System.out.println("The current tab url is: " + driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://twitter.com/");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(browserTabs2.get(0));
		
		menu.navigateTo(menu.instagramButtonTop);
		Thread.sleep(2000);
		List<String> browserTabs3 = new ArrayList<>(driver.getWindowHandles());
		System.out.println("Current handle: " + driver.getWindowHandle());
		System.out.println("The current tab url is: " + driver.getCurrentUrl());
		driver.switchTo().window(browserTabs3.get(1));
		Thread.sleep(2000);
		System.out.println("Current handle: " + driver.getWindowHandle());
		System.out.println("The current tab url is: " + driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://instagram.com/");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(browserTabs3.get(0));
	}
}