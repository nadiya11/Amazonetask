package bookingProduct;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class proudctbooking {
	WebDriver driver;
	@Test
	public void booking() throws InterruptedException//watch
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\webdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement dropdownbox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		dropdownbox.click();
		Thread.sleep(4000);
		dropdownbox.sendKeys("ladies hand watches");
		Thread.sleep(5000);
		List<WebElement> list=driver.findElements(By.xpath( "//div[@class='s-suggestion']"));
		System.out.println(list.size());
		
		for(WebElement suggesion:list) {
			
			//System.out.println(suggesion.getAttribute("data-Keyword"));
			if(suggesion.getAttribute("data-Keyword").equalsIgnoreCase("ladies hand watches fastrack")) {
				Thread.sleep(2000);
				suggesion.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		
		//List<WebElement> suggwatches=driver.findElements(By.xpath("//div[@class='sg-col-inner']/div/h2/a"));
		List<WebElement> suggwatches=driver.findElements(By.xpath("//img[@class='s-image']"));
		Thread.sleep(3000);
		System.out.println(suggwatches.size());
		for(WebElement selectedwatch:suggwatches) {
			Thread.sleep(5000);
			//System.out.println(selectedwatch.getAttribute("alt"));
			if(selectedwatch.getAttribute("alt").equalsIgnoreCase("Fastrack Analog Silver Dial Women's Watch-NK6152SM01")) {
				Thread.sleep(4000);
				selectedwatch.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		
		String parentwin=driver.getWindowHandle();
		Set<String>handles=driver.getWindowHandles();
		for(String windowHandle  : handles)
	       {
	       if(!windowHandle.equals(parentwin))
	          {
	          driver.switchTo().window(windowHandle);
	         //!--Perform your operation here for new window-->
	  			WebElement cartbtn=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
	  			cartbtn.click();
	  			Thread.sleep(4000);
	  			driver.close(); //closing child window
	  			break;
	        // driver.switchTo().window(parentwin); //cntrl to parent window
	          }
	       }
		
		WebElement cartbtn=driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
		cartbtn.click();
		
	
		
	}
	
	

}
