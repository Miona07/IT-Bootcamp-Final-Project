package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Omoguciti da se barata podesavanjima profila (izmene po vasem izboru, najmanje 2).

public class Profile {

	public static void profilePage(WebDriver driver) {
		driver.get(Constants.URL);
		HomePage.closeButton(driver);
		HomePage.closeCookie(driver);
		HomePage.loginPage(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HomePage.login(driver, "mionica@gmail.com", "lala123");
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"wrap_us_menu\"]/i")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"userm\"]/div/a[1]")).click();

	}

	public static void editProfile(WebDriver driver) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]")).click();

	} 

	public static void editNickName(WebDriver driver, String nickName) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement nick = driver.findElement(By.xpath("//*[@id=\"nick_name\"]"));
		nick.click();
		nick.sendKeys(nickName);
	}

	public static void editID(WebDriver driver, String ID) {
		WebElement id = driver.findElement(By.xpath("//*[@id=\"eid\"]"));
		id.click();
		id.sendKeys(ID);
	}

	public static void save(WebDriver driver) {
		WebElement save = driver.findElement(By.xpath("//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[42]/td/input"));
		save.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", save);
	} 
} 
