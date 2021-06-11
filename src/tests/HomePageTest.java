package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objects.Constants;
import objects.HomePage;

public class HomePageTest {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void homePage() {
		driver.get(Constants.URL);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HomePage.closeButton(driver);
		HomePage.closeCookie(driver);

		driver.manage().window().maximize();

		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl, Constants.URL);
	}

	@Test(priority = 2)
	public void aboutUs() {
		HomePage.aboutUsPage(driver);

		String currentUrl = driver.getCurrentUrl();

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		System.out.println(file.getPath());

		Assert.assertEquals(currentUrl, Constants.ABOUT_URL);

		// driver.close();
	}

	@Test(priority = 3)
	public void loginPage() {
		driver.get(Constants.URL);
		HomePage.loginPage(driver);

		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl, Constants.LOGIN_URL);

	}

	@Test(priority = 4)
	public void login() {
		HomePage.login(driver, "mionica@gmail.com", "lala123");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl, "https://mionamilcic.humanity.com/app/dashboard/");
	}

}
