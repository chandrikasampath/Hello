package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class IntimationSearch {
	private WebDriver driver;

	private WebElement username;
	private WebElement password;
	private WebElement division;
	private WebElement submitButton;
	// private WebElement divlist;

	public IntimationSearch(WebDriver driver) {
		this.driver = driver;
		this.username = driver.findElement(By.id("txtUserID"));
		this.password = driver.findElement(By.id("txtPwd"));
		this.division = driver.findElement(By.xpath("//input[@id='txtDivision']"));
		// this.divlist = driver.findElement(By.xpath("//li[@class='ui-menu-item']"));
		this.submitButton = driver.findElement(By.xpath("//input[@value='SUBMIT']"));

	}

	public void login(String user, String pass, String div) throws InterruptedException {
		// Thread.sleep(2000);
		username.sendKeys(user);
		password.sendKeys(pass);
		division.sendKeys(div);
		Thread.sleep(2000);
		List<WebElement> lis = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for (WebElement a : lis) {
			String divelement = a.getText();
			System.out.println(divelement);
			// Thread.sleep(3000);
			if (divelement.equals("421010 - CHENNAI")) {
				Thread.sleep(3000);
				a.click();
			}
		}

		submitButton.click();
		String ExpectedMessage = "Welcome";
		Thread.sleep(2000);
		WebElement msg = driver.findElement(By.xpath("//label[@id='ctl00_User']"));
		String ActualMessage = msg.getText();
		Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
	}

	public void AddDetails() {

	}
}