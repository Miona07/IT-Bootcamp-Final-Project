package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {

	// 1. Proveriti sve elemente iz gornjeg menija - da li naziv iz menija odgovara
	// strani na koju sajt redirektuje prilikom kliktanja na dugme
	// 2. Dodati novog zaposlenog i proveriti uspesnost dodavanja
	// 3. Zaposlenom promeniti ime
	// 3.1. Dodatni zadatak: zaposlenom dodati fotografiju
	

	public static void dashboard(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"sn_dashboard\"]/span")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void shiftPlanning(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"sn_schedule\"]/span")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void timeClock(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"sn_timeclock\"]/span")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void leave(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"sn_requests\"]/span")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void training(WebDriver driver) {
		driver.findElement(By.cssSelector("#sn_training > span")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void staff(WebDriver driver) {
		driver.findElement(By.cssSelector("#sn_staff > span")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void availability(WebDriver driver) {
		driver.findElement(By.cssSelector("#sn_availability > span")).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void payroll(WebDriver driver) {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[1]/div/div/div[2]/div[8]/a")).click();
	
		try { 
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void reports(WebDriver driver) {
		driver.findElement(By.cssSelector("#sn_reports > span")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addEmployee(WebDriver driver, String firstName, String lastName, String email) {
		driver.findElement(By.xpath("//*[@id=\"act_primary\"]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement name = driver.findElement(By.xpath("//*[@id=\"_asf1\"]"));
		name.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name.sendKeys(firstName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement lName = driver.findElement(By.xpath("//*[@id=\"_asl1\"]"));
		lName.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lName.sendKeys(lastName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement mail = driver.findElement(By.xpath("//*[@id=\"_ase1\"]"));
		mail.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mail.sendKeys(email);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"_as_save_multiple\"]")).click();

	}

	public static void changeName(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"StaffSchedules\"]/ul[1]/li[1]/a")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"7\"]/a")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement firstNameBox = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
		firstNameBox.click();
		firstNameBox.clear();
		firstNameBox.sendKeys(name);
		driver.findElement(By.xpath("//*[@id=\"act_primary\"]")).click();
	}
	public static void uploadPhoto (WebDriver driver) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement photo = driver.findElement(By.id("fileupload"));
		//photo.click();
		photo.sendKeys("/Users/admin/Desktop/defect.png");
	}
}
