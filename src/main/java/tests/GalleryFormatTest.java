package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import utils.BaseTest;

public class GalleryFormatTest extends BaseTest{
	
	@Test
	public void galleryFormatTest() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		NavMenuPage menu =  new NavMenuPage(driver);
		
		String javaScriptHover = "var obiect = document.createEvent('MouseEvent');"
				+ "obiect.initMouseEvent('mouseover', true);"
				+ "arguments[0].dispatchEvent(obiect);";
		
		jse.executeScript(javaScriptHover, menu.getElement(menu.blogLink));
		jse.executeScript("arguments[0].click()", menu.getElement(menu.postFormatsBlogLink));
		WebElement galleryFormat = driver.findElement(By.cssSelector("h4[class='post_title']>a[href*='gallery-format']"));
		jse.executeScript("arguments[0].scrollIntoView();", galleryFormat);
		jse.executeScript("arguments[0].click()", galleryFormat);
		Thread.sleep(1000);
		WebElement addComment = driver.findElement(By.cssSelector("h2[class*='comments_form_title']"));
		jse.executeScript("arguments[0].scrollIntoView();", addComment);
		jse.executeScript("arguments[0].value='My comment for this gallery format blog post'", menu.getElement(By.cssSelector("textarea[id='comment']")));
		jse.executeScript("arguments[0].value='My name'", menu.getElement(By.cssSelector("input[id='author']")));
		jse.executeScript("arguments[0].value='my_email@gmail.com'", menu.getElement(By.cssSelector("input[id='email']")));
		jse.executeScript("arguments[0].value='mywebsite.com'", menu.getElement(By.cssSelector("input[id='url']")));
		Thread.sleep(1000);
		WebElement postCommentButton = driver.findElement(By.cssSelector("p[class='form-submit']>input[name='submit']"));
		jse.executeScript("arguments[0].click()", postCommentButton);
	}
}
