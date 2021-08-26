package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.objectrepository.Locators;
import com.utility.CommonFunctions;
import com.utility.StaticVariable;

public class Assign extends StaticVariable {
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
		cf.launchTheURL(prop.getProperty("LB-MP-URL"));
		
		//to move the iframe/frame
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame("Menu");
		driver.switchTo().frame(driver.findElement(By.name("p-2alist")));*/
//to find how many index we use java script
		driver.switchTo().defaultContent();
		JavascriptExecutor exe= (JavascriptExecutor)driver;
		int numberOfFrames=0;
		numberOfFrames=Integer.parseInt(exe.executeAsyncScript("return window length").toString());
		System.out.println(numberOfFrames);
		
	}

	@AfterMethod
	public void aafterMethod() throws Exception {
		cf.screenShot("NameOfTheClass");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
