package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.ContactPage;
import pages.EventsPage;
import pages.NavMenuPage;
import pages.SingleEventPage;
import utils.BaseTest;

public class IFrameExample extends BaseTest{
	
	//@Test
	public void iFrameExample() throws InterruptedException {
		
		NavMenuPage menu = new NavMenuPage(driver);
		menu.navigateTo(menu.contactLink);
		ContactPage contactPage = new ContactPage(driver);
		contactPage.zoomMap(contactPage.zoomIn);
		Thread.sleep(3000);
	}
	
	@Test
	public void iFrameExample2() throws InterruptedException {
		
		NavMenuPage menu = new NavMenuPage(driver);
		menu.navigateTo(menu.eventsLink);
		EventsPage events = new EventsPage(driver);
		events.click(events.festivalOfOldFilmsLink);
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 800).perform();
		
		SingleEventPage sePage = new SingleEventPage(driver);
		sePage.clickMap();
		Thread.sleep(3000);
		
		System.out.println("All: " + driver.getWindowHandles());
		System.out.println("Current: " + driver.getWindowHandle());
		
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(browserTabs.size());
		driver.switchTo().window(browserTabs.get(1));
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		System.out.println("Current2: " + driver.getWindowHandle());
		sePage.clickMap();
		Thread.sleep(3000);
	}

}
