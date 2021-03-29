package com.seleniumpractice.practiceall;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver","C://chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		List<WebElement> linkTags = driver.findElements(By.xpath("//a"));
		List<WebElement> imageTags = driver.findElements(By.xpath("//img"));
		linkTags.addAll(imageTags);
		
		List<WebElement> activeLinks = new ArrayList<>();
		for(WebElement webElement:linkTags) {
			
			if(webElement.getAttribute("href")!=null && (!webElement.getAttribute("href").contains("javascript"))) {
				
				activeLinks.add(webElement);
			}
				
				
		}
		
		System.out.println("Size of linkTags "+linkTags.size());
		System.out.println("Size of activeLinks "+activeLinks.size());
		
		for(WebElement webElement:activeLinks) {
			
			HttpURLConnection connection = (HttpURLConnection)new URL(webElement.getAttribute("href")).openConnection();
			connection.connect();
			String responseMessage = connection.getResponseMessage();
			System.out.println(webElement.getAttribute("href")+responseMessage);
			connection.disconnect();
			
		}

	}

}
