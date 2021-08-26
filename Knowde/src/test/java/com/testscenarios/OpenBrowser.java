package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srilekha\\git\\repository\\Knowde\\chromedriver.exe");
		ChromeOptions cop = new ChromeOptions();
		cop.setExperimentalOption("debuggerAddress", "localhost:9988");
		ChromeDriver driver = new ChromeDriver(cop);
	//	driver.get("https://www.flipkart.com/");
		//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//div[@class='YUhWwv']")).click();
	}

}
