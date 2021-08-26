package com.testscenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utility.CommonFunctions;
import com.utility.StaticVariable;

public class EndToEndAssignment extends StaticVariable {
	CommonFunctions cfn = new CommonFunctions();
	Locators loc = new Locators();

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			cfn.chromeBrowserLaunch();
		}
		if (browserName.equalsIgnoreCase("Edge")) {
			cfn.edgeBrowserLaunch();
		}
		if (browserName.equalsIgnoreCase("FireFox")) {
			cfn.firefoxBrowserLaunch();
		}
	}

	@Test
	public void f() throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/main/resources/testdata/demo.properties");

		prop.load(fis);
		// DEVloping code from here
		cfn.launchTheURL(prop.getProperty("EndToEndASS_URL"));
		cfn.implicitWait(40);

		driver.findElement(loc.Leaving_From).sendKeys(prop.getProperty("LeavinPLace_Name"));
		//cfn.clickByAnyLocator(loc.Leaving_From);
		
		WebElement element = driver.findElement(loc.Leaving_From);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		cfn.implicitWait(20);

		driver.findElement(loc.Arrived_To).sendKeys(prop.getProperty("Arrived_To"));
		cfn.clickByAnyLocator(loc.Arrived_To);

		// start date picker
		cfn.clickByAnyLocator(loc.Date_Picker);
		driver.findElement(loc.Select_Date).click();
		cfn.implicitWait(20);
		cfn.clickByAnyLocator(loc.Return_Date_picker);
		driver.findElement(loc.Select_Return_Date).click();
		cfn.implicitWait(20);
		// click on search button
		cfn.clickByAnyLocator(loc.Click_Search_Button);

		// wait page to load
		cfn.implicitWait(500);

		// click to select random hotel
		int num=cfn.randomInt(20);
          Actions abc= new Actions(driver);
		WebElement selectHotel=driver.findElement(loc.Select_Hotel);
		
          abc.moveToElement(selectHotel).build().perform();
          cfn.clickByAnyLocator(loc.Select_Hotel);
			
	}

	// @AfterMethod
	// public void afterMethod() throws Exception {
	// cfn.screenShot("Nameof the " + "");
	// }

	// @AfterClass
	// public void afterClass() {
	// driver.quit();
//  }

}
