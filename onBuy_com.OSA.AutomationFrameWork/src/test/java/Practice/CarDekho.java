package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarDekho {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.cardekho.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		
		Actions act= new Actions(driver);
		WebElement wbUsedCars =driver.findElement(By.xpath("//li[@class=' mainMenu ']/descendant::span[text()='USED CAR ']"));
		act.moveToElement(wbUsedCars).perform();
		Thread.sleep(2000);
		WebElement wbCarsInUrCity= driver.findElement(By.xpath("//a[@title='Cars In Your City']"));
		act.moveToElement(wbCarsInUrCity).perform();
		WebElement wbBanglore= driver .findElement(By.xpath("//a[@title='Used Cars In Bangalore']"));
		act.moveToElement(wbBanglore).click().perform();
		
		List<WebElement>lst=driver.findElements(By.xpath("//div[@class='listViewCard']/div[3]/div/div/div/div/div[2]"));
		
		List<WebElement>product_title= driver.findElements(By.xpath("//div[@class='listViewCard']/div[3]/div/div/div/div/div[2]/div/div/h3"));
		
		
		
		
		
		
		
		int count=0;
		for(WebElement wb: lst)
		{
			count++;
			System.out.println(wb.getText());
			
		}
		System.out.println(count);
		

	}

}
