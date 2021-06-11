package objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class StaffPage {

	// 4. Koristeci apachePOI (ucitavanjem iz excel tabele), automatski dodati
	// minimum 5 novih zaposlenih i proveriti uspesnost dodavanja. Sami kreirate
	// tabelu sa potrebnim podacima.
	
	public static List<String> excelList() {
		
		List <String> emailEmployee = new ArrayList<String>();
		File f = new File("Employees.xlsx");
		try {
			InputStream in = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			Sheet sheet = wb.getSheetAt(0);

			for (int i = 0; i < 5; i++) {

				Row row = sheet.getRow(i);
			
				Cell c2 = row.getCell(2);

				String mail = c2.toString();
				
				emailEmployee.add(mail);
				
	} wb.close();
				}  catch (IOException e) {
			e.printStackTrace();
		
		} return emailEmployee;
	}
	public static void addStaff(WebDriver driver) {

		driver.findElement(By.xpath("//*[@id=\"act_primary\"]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 List <WebElement> list = driver.findElements(By.className("_ns_row"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File f = new File("Employees.xlsx");
		try {
			InputStream in = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			Sheet sheet = wb.getSheetAt(0);

			for (int i = 0; i < 5; i++) {

				Row row = sheet.getRow(i);
				Cell c0 = row.getCell(0);
				Cell c1 = row.getCell(1);
				Cell c2 = row.getCell(2);

				String fName = c0.toString();
				String lName = c1.toString();
				String mail = c2.toString();

				StaffPage.addEmployees(list.get(i), fName, lName, mail, i);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			wb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WebElement save = driver.findElement(By.xpath("//*[@id=\"_as_save_multiple\"]"));
		save.click();

	}
	
	public static void addEmployees(WebElement el, String firstName, String lastName, String email, int i) {
		
		WebElement name = el.findElement(By.className("_ns_fname"));
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
		WebElement lName = el.findElement(By.className("_ns_lname"));
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
		WebElement mail = el.findElement(By.className("_ns_email"));
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
}
}
