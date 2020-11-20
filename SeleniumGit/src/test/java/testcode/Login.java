package testcode;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	static WebDriver driver;

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		File f = new File("E:\\selenium\\testdata.xlsx");
		Workbook w = new XSSFWorkbook(f);
		org.apache.poi.ss.usermodel.Sheet s = w.getSheet("Sheet1");
		for (int i = 1; i <= 1; i++) {
			String username = s.getRow(i).getCell(0).getStringCellValue();
			String password = s.getRow(i).getCell(1).getStringCellValue();
			WebElement user = driver.findElement(By.name("txtUsername"));
			user.sendKeys(username);
			WebElement pswd = driver.findElement(By.name("txtPassword"));
			pswd.sendKeys(password);
		}

		
		
		driver.findElement(By.id("btnLogin")).click();
	}
}