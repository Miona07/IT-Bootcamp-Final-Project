package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Constants;
import objects.HomePage;
import objects.UserPage;

public class UserPageTest {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void dashboard() {
		driver.get(Constants.TEST_USER_URL);
		HomePage.login(driver, "mionica@gmail.com", "lala123");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.manage().window().maximize();
		UserPage.dashboard(driver);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://mionamilcic.humanity.com/app/dashboard/");
	}

	@Test(priority = 2)
	public void shiftPlanning() {
		UserPage.shiftPlanning(driver);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl,
				"https://mionamilcic.humanity.com/app/schedule/employee/week/overview/overview/11%2c5%2c2021/");
	}

	@Test(priority = 3)
	public void timeClock() {
		UserPage.timeClock(driver);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://mionamilcic.humanity.com/app/timeclock/");
	}

	@Test(priority = 4)
	public void leave() {
		UserPage.leave(driver);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://mionamilcic.humanity.com/app/requests/vacation/");
	}

	@Test(priority = 5)
	public void training() {
		UserPage.training(driver);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://mionamilcic.humanity.com/app/training/");
	}

	@Test(priority = 9)
	public void staff() {
		UserPage.staff(driver);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://mionamilcic.humanity.com/app/staff/list/load/true/");
	}

	@Test(priority = 6)
	public void availability() {
		UserPage.availability(driver);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl,
				"https://mionamilcic.humanity.com/fe/availability/#/requests/week/2021-06-06/1");
	}

	@Test(priority = 7)
	public void payroll() {
		UserPage.payroll(driver);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://mionamilcic.humanity.com/app/payroll/scheduled-hours/");
	}

	@Test(priority = 8)
	public void reports() {
		UserPage.reports(driver);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://mionamilcic.humanity.com/app/reports/dashboard/");
	}

	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	@Test(priority = 10)
	public void addEmployee() {
		String randomNumber = String.valueOf(getRandomNumber(1, 100000));
		String firstName = "Matija";
		String lastName = "Milcic" + randomNumber;
		String fullName = firstName + " " + lastName;
		UserPage.addEmployee(driver, firstName, lastName, "tralala" + randomNumber + "@gmail.com");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"StaffSchedules\"]/ul[1]/li[1]/a")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue(driver.getPageSource().contains(fullName));

	}

	@Test(priority = 11)
	public void changeName() {
		UserPage.changeName(driver, "RadnikMeseca");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement newName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));

		Assert.assertEquals(newName.getAttribute("value"), "RadnikMeseca");
	}

	@Test(priority = 12)
	public void addPhoto() {
		UserPage.uploadPhoto(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement upload = driver.findElement(By.xpath("//*[@id=\"fileupload_completedMessage\"]"));

		Assert.assertTrue(upload.isDisplayed());
	}

}
