package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utility.CommonFunctions;
import com.utility.StaticVariable;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest extends StaticVariable {
	Locators loc= new Locators();
	CommonFunctions cf=new CommonFunctions();
	@BeforeClass
	public void beforeClass() {
		cf.chromeBrowserLaunch();
	}

	@Test
	
	public void f() throws Exception {
		//Thread.sleep(5000);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("./src/main/resources/testdata/demo.properties");
		prop.load(fis);
		driver.get(prop.getProperty("FB-URL"));
		cf.sendkeyByAnyLocator(loc.FBLOGIN_USERNAME_EDITBOX, prop.getProperty("FB-USERNAME"));
		cf.sendkeyByAnyLocator(loc.FBLOGIN_PASSWORD_EDITBOX, prop.getProperty("FB-PASSWORD"));
		cf.clickByAnyLocator(loc.FBLOGIN_LOGIN_BUTTON);
		
	}

}
