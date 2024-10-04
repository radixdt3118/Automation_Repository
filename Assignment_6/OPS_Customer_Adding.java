import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OPS_Customer_Adding {
	
	
	
	public static void waitFunction(double n) throws InterruptedException {
		Thread.sleep((long)n*1000);
	}

	public static void main(String[] args) throws IOException {
		File file = new File("Output.txt");
		FileWriter writer = new FileWriter(file,false);		
		
		WebDriver driver=null;
		
		System.out.println("Enter browser index\n1.Chrome\n2.Edge\n3.Firefox");
		Scanner sc = new Scanner(System.in);
		int index=sc.nextInt();
		
		if(index==1) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions handlingSSL = new ChromeOptions();
			handlingSSL.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(handlingSSL);
		}else if(index==2) {
			EdgeOptions handlingSSL = new EdgeOptions();
			handlingSSL.setAcceptInsecureCerts(true);
			driver = new EdgeDriver(handlingSSL);
		}else if(index==3) {
		    FirefoxOptions handlingSSL = new FirefoxOptions();
		    handlingSSL.setAcceptInsecureCerts(true);
		    driver = new FirefoxDriver(handlingSSL);
		} else {
			System.out.println("Incorrect index!!");
			System.exit(0);
		}
				
		
		try {
			driver.get("https://ops-qa.radixdev79.com/admin");
			driver.manage().window().maximize();
			WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
			uname.sendKeys("admin");
			pwd.sendKeys("Admin095");
			login.click();
			
			//Customer adding
			driver.get("https://ops-qa.radixdev79.com/admin/user_action.php");

			//Filling Customer details
			driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Vaibhav");
			driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Darji");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("vaibhav.darji@radixweb.com");
			driver.findElement(By.xpath("//input[@id='secondary_emails']")).sendKeys("vaibhav.darji+101@radixweb.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Radixweb@8");
			driver.findElement(By.xpath("//input[@id='phone_number']")).sendKeys("8798788787");
			driver.findElement(By.xpath("//input[@id='companyname']")).sendKeys("XYZ");
			driver.findElement(By.xpath("//input[@id='street_address']")).sendKeys("A1");
			driver.findElement(By.xpath("//input[@id='suburb']")).sendKeys("A2");
			driver.findElement(By.xpath("//button[@class='btn dropdown-toggle bs-placeholder btn-light']")).click();
			driver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York City");			
			driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("356987");
			driver.findElement(By.xpath("//button[@id='btn-action-saveback']")).click();
			
			//Verify whether customer is actually added or not
			waitFunction(2);
			try {
				driver.findElement(By.xpath("//*[text()='vaibhav.darji@radixweb.com']"));
				writer.write("User found");
			} catch (Exception e) {
				// TODO: handle exception
				writer.write("User not found");
			}
						
		} catch (Exception e) {
			System.out.format("\n\nError : %s\n\n",e.getLocalizedMessage());
		}finally {
			driver.close();
			writer.close();
		}
		
	}
	
}
