package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.HomePage;
import objects.Profile;
import objects.Constants;

public class ProfileTest {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void profilePage() {
		Profile.profilePage(driver);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Constants.PROFILE_URL);
	}

	@Test(priority = 2)
	public void editDetails() {

		Profile.editProfile(driver);
		Profile.editNickName(driver, "Mina");
		Profile.editID(driver, "22857");
		Profile.save(driver);
		WebElement nick = driver.findElement(By.xpath("//*[@id=\"nick_name\"]"));
		WebElement id = driver.findElement(By.xpath("//*[@id=\"eid\"]"));

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(nick.getAttribute("value").trim(), "Mina");
		sa.assertEquals(id.getAttribute("value").trim(), "22857");
		sa.assertAll();
	}
	
}
