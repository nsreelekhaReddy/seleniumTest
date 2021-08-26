package com.testscenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utility.CommonFunctions;
import com.utility.StaticVariable;

import org.testng.annotations.Test;

public class WebAssign extends StaticVariable {

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
		cfn.launchTheURL(prop.getProperty("web_Table_url"));
		cfn.clickByAnyLocator(loc.click_Edit_pencil);
		cfn.implicitWait(20);
		driver.findElement(loc.Click_First_Name).clear();
		driver.findElement(loc.Click_First_Name).sendKeys(prop.getProperty("web_Table_FN"));
		driver.findElement(loc.Click_Second_Name).clear();
		driver.findElement(loc.Click_Second_Name).sendKeys(prop.getProperty("web_Table_SN"));
		driver.findElement(loc.Click_Middle_Name).clear();
		driver.findElement(loc.Click_Middle_Name).sendKeys(prop.getProperty("web_Table_MN"));
		cfn.implicitWait(20);
		cfn.clickByAnyLocator(loc.Click_Update);

	}

	@AfterMethod
	public void afterMethod() throws Exception {
		cfn.screenShot("Nameof the " + "");
	}

	// @AfterClass
	// public void afterClass() {
	// driver.quit();
	// }

}
