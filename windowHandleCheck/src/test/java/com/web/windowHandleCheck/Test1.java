package com.web.windowHandleCheck;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
	public static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",".\\imp\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@Test
	public void test1() throws AWTException {
		String parent=driver.getWindowHandle();
		Robot robot = new Robot();                          
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_T); 
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		robot.keyRelease(KeyEvent.VK_T);

		Set<String> windows=driver.getWindowHandles();
		Iterator<String> i=windows.iterator();
		//while(i.hasNext()) {
			 String childWindow=i.next();
			 System.out.println("Mamoni1");
			// if(childWindow!=parent) {
			 driver.switchTo().window(childWindow);
			 driver.get("https://www.facebook.com/");
		//}}
		 driver.switchTo().window(parent);
		 driver.get("https://www.cspire.com");
	}
}
