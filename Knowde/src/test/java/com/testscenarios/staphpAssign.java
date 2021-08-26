package com.testscenarios;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utility.CommonFunctions;
import com.utility.StaticVariable;

public class staphpAssign extends StaticVariable {
	CommonFunctions cf = new CommonFunctions();
	Locators loc = new Locators();

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			cf.chromeBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			cf.firefoxBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			cf.edgeBrowserLaunch();

		}
	}

	@Test
	public void f() throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/main/resources/testdata/demo.properties");
		prop.load(fis);
		/************** develop code from here ************/
		cf.launchTheURL(prop.getProperty("STQAAssign"));
		cf.loopAllFramesCount(loc.BASIC_ALERT);
		cf.clickByAnyLocator(loc.BASIC_ALERT);

	}

	@AfterMethod
	public void afterMethod(ITestResult res) throws Exception {
		//cf.screenShot("NameOfTheClass");
		cf.screenshotStatus(res);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
 
 
