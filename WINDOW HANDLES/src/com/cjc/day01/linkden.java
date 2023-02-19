package com.cjc.day01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class linkden 
{
	public static void main(String[] args) 
	{
		
		System.out.println("Window Handles on WebSite");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\IT Folder\\chrome110\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://in.linkedin.com/");
		driver.manage().window().maximize();
		
		//FOOTER SECTION//
		WebElement footer=driver.findElement(By.xpath("/html/body/footer/ul"));
		List<WebElement> foot=footer.findElements(By.tagName("a"));
		int f=foot.size();
		System.out.println(f);
		
		for(int i=0;i<f;i++)
		{
			String k=Keys.chord(Keys.CONTROL,Keys.ENTER);
			footer.findElements(By.tagName("a")).get(i).sendKeys(k);
			
		}
		
		//WINDOW HANDLES//
		
		Set<String>wh=driver.getWindowHandles();
		ArrayList<String>al=new ArrayList<>(wh);
		Iterator<String>itr=al.iterator();
		while(itr.hasNext())
		{
			driver.switchTo().window(itr.next());
			String title=driver.getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase("About LinkedIn"))
			{
				driver.findElement(By.xpath("//*[@id=\"banner-content-container-banner_45524901\"]/p[2]/a[1]")).click();
			}
		}
		
		
	}

}
