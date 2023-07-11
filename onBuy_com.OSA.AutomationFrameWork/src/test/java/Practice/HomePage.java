package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {

	@Test
	public void HomePage() {
		// TODO Auto-generated method stub

				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				// Login to user module - enter the URL
				driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");

				//Enter Valid Creadentials
				driver.findElement(By.linkText("Login")).click();
				driver.findElement(By.id("exampleInputEmail1")).sendKeys("anuj.lpu1@gmail.com");
				driver.findElement(By.id("exampleInputPassword1")).sendKeys("Test@123");
				driver.findElement(By.xpath("//button[.='Login']")).click();
				//click on home 
				driver.findElement(By.xpath("//a[text()='Home']")).click();
				
				System.out.println("home page displayed ");
//				//click on category
//				driver.findElement(By.xpath("//a[normalize-space(text())='"+category+"']")).click();
//				//click on subcategory
//				driver.findElement(By.xpath("//a[normalize-space(text())='"+subCategory+"']")).click();
		
	}

}
