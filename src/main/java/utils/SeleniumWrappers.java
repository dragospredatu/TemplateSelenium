package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers {
	
	public WebDriver driver;
	
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Custom sendKeys method/ Wraps Selenium default sendKeys and enhances it
	 * with clear() method before sending the test
	 * @param locator --> used inside method to create a WebElement object
	 * @param value --> String value to be used as text input
	 */
	public void sendKeys(By locator, String value) {
		
		WebElement element = driver.findElement(locator);
		waitForElementToBeVisible(element);
		
		try {
			Log.info("Called method <clear> on element " + element.getAttribute("outerHTML"));
			element.clear();
			Log.info("Called method <sendKeys> on element " + element.getAttribute("outerHTML"));
			element.sendKeys(value);
		}catch(Exception e) {
			Log.error("Element not found in method <sendKeys>");
			Log.error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param locator
	 */
	public void click(By locator) {
		
		WebElement element = driver.findElement(locator);
		Log.info("Called method <click> on element " + element.getAttribute("outerHTML"));
		
		try {
			waitForElementToBeClickable(element);
			element.click();
		}catch(NoSuchElementException e) {
			Log.error("Element not found in method <click> after 10 seconds");
			Log.error(e.getMessage());
		}catch(StaleElementReferenceException e) {
			element = driver.findElement(locator);
			Log.error("Called method <StaleElementReferenceException> on element " + element.getAttribute("outerHTML"));
			element.click();
		}
	}
	
	/**
	 * 
	 * @param element
	 */
	public void waitForElementToBeClickable(WebElement element) {
		
		try {
			Log.info("Called method <waitForElementToBeClickable> " + element.getAttribute("outerHTML"));
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));	
		}catch(NoSuchElementException e) {
			Log.error("Element not found in method <waitForElementToBeClickable> after 10 seconds");
			Log.error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param element
	 */
	public void waitForElementToBeVisible(WebElement element) {
		try {
			Log.info("Called method <waitForElementToBeVisible> " + element.getAttribute("outerHTML"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(NoSuchElementException e) {
			Log.error("Element not found in method <waitForElementToBeVisible> after 10 seconds");
			Log.error(e.getMessage());
		}
	}
	
	public void dragAndDrop(By locator, int x, int y) {
		
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, x, y).perform();
		//Other examples
		//action.clickAndHold(element).moveByOffset(300, 0).release().build().perform();
		//action.sendKeys(Keys.TAB).click().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
	}
	
	public void hoverElement(By locator) {
		
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public String readUrl() {
		
		return driver.getCurrentUrl();
	}

}
