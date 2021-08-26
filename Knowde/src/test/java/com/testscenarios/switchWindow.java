package com.testscenarios;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class switchWindow extends StaticVariable {
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
		//cf.launchTheURL(prop.getProperty("switchTab_URL"));
		//cf.loopAllFramesCount(loc.OPEN_NEW_WINDOW);
		//cf.clickByAnyLocator(loc.OPEN_NEW_WINDOW);
		//driver.findElement(loc.OPEN_NEW_WINDOW);
		//cf.clickByAnyLocator(loc.OPEN_NEW_WINDOW);
		
       cf.launchTheURL(prop.getProperty("AUTOMPRAC_URL"));
          cf.implicitWait(30);		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",driver.findElement(loc.AUTOMATION_ADD_TO_CART));
       System.out.println("the random number is:" + cf.randomInt(7));
       cf.selectByIndex(loc.AUTOMATION_ADD_TO_CART, cf.randomInt(7));

	}

	@AfterMethod
	public void aafterMethod() throws Exception {
		cf.screenShot("NameOfTheClass");
	}

	/*@AfterClass
	public void afterClass() {
		driver.quit();*/
	}

 

