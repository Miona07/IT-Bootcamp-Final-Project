package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	//1. Doci do stranice ABOUT US i napraviti screenshot strane
	//2. Proveriti da li postojeci user uspesno moze da se loguje


	public static void closeCookie(WebDriver driver) {
		WebElement cookie = driver.findElement(By.xpath(Constants.COOKIE_XPATH));
		cookie.click();

	}

	public static void closeButton(WebDriver driver) {
		WebElement close = driver.findElement(By.xpath(Constants.CLOSE_BUTTON_XPATH));
		close.click();
	}

	public static void aboutUsPage(WebDriver driver) {
		WebElement aboutUs = driver.findElement(By.xpath(Constants.ABOUT_US_XPATH));
		aboutUs.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[1]/a")).click();

	}

	public static void loginPage(WebDriver driver) {
		WebElement login = driver.findElement(By.xpath(Constants.LOGIN_XPATH));
		login.click();

	}

	public static void login(WebDriver driver, String username, String password) {
		WebElement email = driver.findElement(By.id("email"));
		email.click();
		email.sendKeys(username);
		WebElement pass = driver.findElement(By.id("password"));
		pass.click();
		pass.sendKeys(password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement login = driver.findElement(By.name("login"));
		login.click();

	}
}
