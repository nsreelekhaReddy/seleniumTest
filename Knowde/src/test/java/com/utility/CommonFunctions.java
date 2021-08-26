package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions extends StaticVariable {
//Constructor
	public CommonFunctions() {
		projectDir=System.getProperty("user.dir");
		File screenShotPath = new File("./screenshots");
		if (screenShotPath.exists()) {
			System.out.println("screenshot folder is already available in project location....");
		} else {
			System.out.println("screenshot folder is not available in project location....");

			screenShotPath.mkdir();
			System.out.println("screenshot folder is created");
		}
	}

	public void chromeBrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void firefoxBrowserLaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public void edgeBrowserLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	// **************Sendkeys using any locator********/

	public void sendkeyByAnyLocator(By locator, String inputdata) {
		WebElement ele = driver.findElement(locator);
		if (ele.isDisplayed() && ele.isEnabled()) {
			ele.clear();
			ele.sendKeys(inputdata);
		} else {
			System.out.println("web element is not displayed on Dom");
		}

	}
	// **************click using any locator********/

	public void clickByAnyLocator(By locator) {
		WebElement ele = driver.findElement(locator);
		if (ele.isDisplayed() && ele.isEnabled()) {
			ele.click();
		} else {
			System.out.println("web element is not displayed on Dom");
		}
	}

	/*********************
	 * Screenshot
	 * 
	 * @return
	 * @return
	 *******************/
	public String timeStamp() {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("ddMMMyyyy_HHMMSS");
		String timeStamp = df.format(d);
		return timeStamp;
	}

	public void screenShot(String FileName) throws Exception {
		File fi = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fi, new File("./screenshots/" + FileName + timeStamp() + ".JPEG"));

	}
	public void screenshotStatus(ITestResult res) throws Exception {
		className=res.getTestClass().getName().trim();
		methodName=res.getName().trim();
		if (res.getStatus()==ITestResult.SUCCESS) {
			File fi=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(fi, new File("./screenshots/"+"PASS_"+className+"_"+methodName+"_"+timeStamp()+".JPEG"));
		} else if (res.getStatus()==ITestResult.FAILURE){
			File fi=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(fi, new File("./screenshots/"+"FAIL_"+className+"_"+methodName+"_"+timeStamp()+".JPEG"));
		}
	}

	/********** launch url ****/
	public void launchTheURL(String URL) {
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		implicitWait(20);
	}

	/*********** implicit wait **************/
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/***********
	 * Frame handling
	 * 
	 * @return
	 **************/
	public int iframeCount() {
		driver.switchTo().defaultContent();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		int numberOfFrames = 0;
		numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("number of frames on iframe page :" + numberOfFrames);
		return numberOfFrames;

	}

	public void switchToFrameByInt(int i) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(i);
	}

	public int loopAllFramesCount(By locator) {
		int elementPresenceCount = 0;
		int loop = 0;
		int maxFrameCount = iframeCount();
		elementPresenceCount = driver.findElements(locator).size();
		while (elementPresenceCount == 0 && loop < maxFrameCount) {
			try {
				switchToFrameByInt(loop);
				elementPresenceCount = driver.findElements(locator).size();
				System.out.println("try loopallframesand return web element:" + loop + "; elementPresenceCount:"
						+ elementPresenceCount);
				if (elementPresenceCount > 0 || loop > maxFrameCount) {
					break;
				}
			} catch (Exception e) {
				System.out.println("catch all loopallframesand return web element old:" + loop + ";" + e);
			}
			loop++;
		}
		return elementPresenceCount;
	}

	/********************* DROPDOWN COMMON FUNCTIONS ******/
	public void selectVisibleText(By locator, String visibleText) {
		WebElement element = driver.findElement(locator);
		if (element.isEnabled() && element.isDisplayed()) {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(visibleText);
		} else {
			System.out.println("the element may not be displayed or enabled");

		}
	}

	public void selectByIndex(By locator, int Index) {
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed() && element.isEnabled()) {
			Select dropdown = new Select(element);
			dropdown.deselectByIndex(Index);
		} else {
			System.out.println("the element may not be displayed or enabled");
		}

	}

	public void printAllDropdownValues(By locator) {
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed() && element.isEnabled()) {
			Select dropdown = new Select(element);
			List<WebElement> dropdownvalues = dropdown.getOptions();
			System.out.println(dropdownvalues.size());
			for (WebElement allvalues : dropdownvalues) {
				System.out.println(allvalues.getText());
			}
		}
	}

	public void selectCustomiseOptionFromTheDropdownValues(By locater, String visibleText) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed() && element.isEnabled()) {
			Select dropdown = new Select(element);
			List<WebElement> dropdownValues = dropdown.getOptions();
			// Print the size of dropdown values
			System.out.println(dropdownValues.size());
			// Print the dropdown values
			for (int i = 0; i < dropdownValues.size(); i++) {
				System.out.println(dropdownValues.get(i).getText());

				// Select India option from the dropdown
				if (dropdownValues.get(i).getText().equals(visibleText)) {
					dropdown.selectByIndex(i);
					break;
				}
			}
		}

	}

	/**************** randomInt *************/
	public int randomInt(int maxRange) {
		Random r = new Random();
		int randomNUM = r.nextInt(maxRange);
		return randomNUM;
	}
}
