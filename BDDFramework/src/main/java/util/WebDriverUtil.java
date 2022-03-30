package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.messages.internal.com.google.common.io.Files;


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

}
