package Assignments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OPS_Add_Quote {
	public static void waitFunction(double n) throws InterruptedException {
		Thread.sleep((long)n*1000);
	}

	public static void main(String[] args) throws IOException {
		File file = new File("Output.txt");
		FileWriter writer = new FileWriter(file,false);		
		
		WebDriverManager.edgedriver().setup();
		
		EdgeOptions handlingSSL = new EdgeOptions();
		handlingSSL.setAcceptInsecureCerts(true);
		WebDriver driver = new EdgeDriver(handlingSSL);
		try {
			driver.get("https://ops-qa.radixdev79.com/admin");
			driver.manage().window().maximize();
			WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
			uname.sendKeys("admin");
			pwd.sendKeys("Admin095");
			login.click();
			
			WebElement quote_panel = driver.findElement(By.xpath("(//div[@class='flex-grow-1 ace-scroll']//following-sibling::a[@class='nav-link dropdown-toggle'])[2]"));
			quote_panel.click();
			WebElement view_quotes = driver.findElement(By.xpath("//span[text()='View Quotes']"));
			view_quotes.click();
			WebElement add_new = driver.findElement(By.xpath("//a[@class='btn btn-success btn-sm btn-sm ml-1 rounded']"));
			add_new.click();
			waitFunction(1);
			//Quote details from here
			driver.findElement(By.xpath("//input[@name='quote_title']")).sendKeys("Quote_1");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("vaibhav.darji@radixweb.com");
			driver.findElement(By.xpath("//input[@name='quote_title']")).click();
			driver.findElement(By.xpath("//input[@id='custom_products_title']")).sendKeys("Prod_1");
			driver.findElement(By.xpath("//input[@id='quote_quantity[1]']")).sendKeys("50");
			driver.findElement(By.xpath("//input[@id='text_34']")).sendKeys("TextBox");
			driver.findElement(By.xpath("//textarea[@id='area_64']")).sendKeys("This is quote description");
			driver.findElement(By.xpath("//input[@id='checkbox_Single']")).click();
			driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Vaibhav");
			driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Darji");
			driver.findElement(By.xpath("//input[@id='phonenumber']")).sendKeys("8787878787");
			driver.findElement(By.xpath("//button[@id='save_continue']")).click();
			
			
			waitFunction(2);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error : "+e.getLocalizedMessage());
		} finally {
			driver.close();
			writer.close();
		}
		
		
	}
	
}
