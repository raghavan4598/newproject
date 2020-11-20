package testcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Orangehrm {
	static WebDriver driver;

	@Test(priority = 0)
	public void opening_chrome() {
		System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void url() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.getTitle();
	}

	@Test(priority = 2)
	public void login() throws InvalidFormatException, IOException {

		File file = new File("C:\\Users\\Dell1\\git\\repository2\\SeleniumGit\\src\\test\\java\\testcode\\userdata.properties");
		FileInputStream readData = new FileInputStream(file);
		Properties p = new Properties();
		p.load(readData);
		driver.findElement(By.name("txtUsername")).sendKeys(p.getProperty("user"));
		driver.findElement(By.name("txtPassword")).sendKeys(p.getProperty("pswd"));
		driver.findElement(By.id("btnLogin")).click();
	}
}