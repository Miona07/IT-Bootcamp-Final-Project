package tests;

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
import objects.SettingsPage;

public class SettingsPageTest {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void settingsPage() {
		SettingsPage.settings(driver);
		driver.manage().window().maximize();

		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl, Constants.SETTINGS_URL);
	}
	@Test(priority = 2)
	public void languageChange() {
		SettingsPage.changeLanguage(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement podesavanja = driver.findElement(By.xpath("//*[@id=\"_cd_admin\"]/div[1]/div/div/div[1]/div/div"));
		String string = podesavanja.getAttribute("innerHTML").trim();
		Assert.assertEquals(string, "Postavke");
	}

	@Test(priority = 3)
	public void checkboxNotifications() {
		SoftAssert sa = new SoftAssert();
		SettingsPage.checkboxNotifications(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement parentElement = driver.findElement(By.xpath("//*[@id=\"adminSettingsForm\"]/div[2]/table"));

		List<WebElement> children = parentElement.findElements(By.xpath(".//input"));
		for (int i = 0; i < 3; i++) {

			sa.assertNull(children.get(i).getAttribute("checked"));

		}
		sa.assertAll();
	}

}
