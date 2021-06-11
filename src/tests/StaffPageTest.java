package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Constants;
import objects.HomePage;
import objects.SettingsPage;
import objects.StaffPage;
import objects.UserPage;

public class StaffPageTest {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		driver = new ChromeDriver();
		
	}

	@Test(priority = 1)
	public void staffPage() {
		driver.get(Constants.TEST_USER_URL);
		HomePage.login(driver, "mionica@gmail.com", "lala123");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.manage().window().maximize();
		UserPage.staff(driver);

		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl, Constants.STAFF_URL);
	}

	@Test(priority = 2)
	public void addStaff() {
		
		StaffPage.addStaff(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"StaffSchedules\"]/ul[1]/li[1]/a")).click();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> emailList = driver.findElements(By.xpath("//*[@data-prop=\"email\"]"));
		System.out.println(emailList.size());

		List<String> emailExcel = StaffPage.excelList();

		List<String> allStaffEmails = new ArrayList<String>();

		for (int i = 0; i < emailList.size(); i++) {

			String mail = emailList.get(i).findElement(By.xpath(".//span")).getAttribute("innerHTML");
			allStaffEmails.add(mail);

		}
		Assert.assertTrue(allStaffEmails.containsAll(emailExcel));

	}
}
