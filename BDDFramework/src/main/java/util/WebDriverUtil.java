package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtil {
	
	public void takeScreenshot(WebDriver driver,String scenarioName) throws Throwable {
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\screenshot\\"+scenarioName+sysDate()+".png");
		Files.copy(src, dest);
	}
	
	public String sysDate() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
		return dateFormat.format(new Date());
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void dropdownbyIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void dropdownByValue(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void awaitForVisibilityOfElement(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver input) {
				element.isDisplayed();
				return element;
			}
		});
	}
	
	public void awaitForPagetitle(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(d-> d.getTitle()); 
	}
	
	public void frame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void frame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	public void frame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void mouseHover(WebDriver driver,WebElement targetElement) {
		Actions actions=new Actions(driver);
		actions.moveToElement(targetElement).perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement sourceElement,WebElement targetElement) {
		Actions actions=new Actions(driver);
		actions.clickAndHold(sourceElement)
		.moveToElement(targetElement)
		.release(sourceElement)
		.perform();
	}
	
	 

}
