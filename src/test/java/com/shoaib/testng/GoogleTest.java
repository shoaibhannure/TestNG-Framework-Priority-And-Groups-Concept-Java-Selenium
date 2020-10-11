package com.shoaib.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	@Test(priority=2,groups="Title")
	public void googleTitleTest(){
		String title = driver.getTitle();
		System.out.println("Title of Page is  "+title);
	}

	@Test(priority=1,groups="Logo")
	public void googleLogoTest(){
		driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
	}
	
	@Test(priority=3,groups="Link Test")
	public void mailLinkTest(){
		boolean b = driver.findElement(By.linkText("Mail")).isDisplayed();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
