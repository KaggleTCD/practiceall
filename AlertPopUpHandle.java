package com.seleniumpractice.practiceall;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {
	
	public static void main(String args[]) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		WebElement signInButton = driver.findElement(By.xpath("//input[@type='submit']"));
		signInButton.click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		driver.quit();
	}

}
