package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchTheApplication {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		/**
		 * Admin Module
		 */
		
		
		//Step 1: Enter the Admin URL
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		System.out.println("entered Admin URL");
		//Step 2: Enter User name and Password
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		//Step 2: Click on category Major Tab
		driver.findElement(By.xpath("//a[normalize-space(text())='Create Category']")).click();
		//Step 3: Enter the Category Name
		driver.findElement(By.xpath("//input[@placeholder='Enter category Name']")).sendKeys("Furniture");
		//Step 4: Click on create button
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		//Step 5: Click on Sub-category Major Tab
		driver.findElement(By.xpath("//a[normalize-space(text())='Sub Category']")).click();
	
		//Step 6: Click on category Drop-down and select the valid text
		WebElement categoryDD = driver.findElement(By.name("category"));
		Select drop_Down=new Select(categoryDD);
		drop_Down.selectByVisibleText("Furniture");
		
		//Strp 7: Enter the Sub-Category Name
		driver.findElement(By.name("subcategory")).sendKeys("Tables");
		//Step 8: click on create Button
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		
		//Step 9: Click on Insert Prodct Major Tab
		driver.findElement(By.xpath("//a[normalize-space(text())='Insert Product']")).click();
		
		//Step 10: Select the valid input in the Drop down
		Select drop_Down2=new Select(categoryDD);
		drop_Down2.selectByVisibleText("Furniture");
		
		//Step 11: Select the Sub-category Dorp-down and select the Sub-Category
		WebElement sub_CategoryDD = driver.findElement(By.id("subcategory"));
		Select subCategoryDD= new Select(sub_CategoryDD);
		subCategoryDD.selectByVisibleText("Tables");
		
		//step 12: Enter all the details
		driver.findElement(By.name("productName")).sendKeys("");
		driver.findElement(By.name("productCompany")).sendKeys("");
		driver.findElement(By.name("productpricebd")).sendKeys("");
		driver.findElement(By.name("productprice")).sendKeys("");
		driver.findElement(By.name("productDescription")).sendKeys("");
		driver.findElement(By.name("productShippingcharge")).sendKeys("");
		WebElement availabilityDD = driver.findElement(By.name("productAvailability"));
		Select productAvailabilityDD=new Select(availabilityDD);
		productAvailabilityDD.selectByVisibleText("In Stock");
		
		driver.findElement(By.id("productimage1")).sendKeys("C:\\Users\\ELCOT\\Pictures.OIP.jpg");
		driver.findElement(By.name("productimage2")).sendKeys("C:\\Users\\ELCOT\\Pictures.OIP.jpg");
		driver.findElement(By.name("productimage3")).sendKeys("C:\\Users\\ELCOT\\Pictures.OIP.jpg");
		
		driver.findElement(By.xpath("//button[.='Insert']")).click();
		driver.findElement(By.xpath("//a[normalize-space(text())='Logout']")).click();
		System.out.println("Logged out of the application");
		driver.close();
		
		
		
		
		
		
		
		//User Module
		
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
		System.out.println("entered user URL");
		driver.findElement(By.xpath("//a[text()='Login']")).click();   //
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(" anuj.lpu1@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Test@123");
		driver.findElement(By.name("login")).click();
		
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.close();
		System.out.println("Closer the browser");
		

	}

}
