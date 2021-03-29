package com.seleniumpractice.practiceall;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		selectValueFromDropDown(day,"10");
		selectValueFromDropDown(month,"May");
		selectValueFromDropDown(year,"1990");

	}

	private static void selectValueFromDropDown(WebElement webElement,String value) {
		
		Select select = new Select(webElement);
		select.selectByVisibleText(value);
		
	}

}
