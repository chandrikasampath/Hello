package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.IntimationSearch;

public class IntimationAdd {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void FAR() throws InterruptedException {
		driver.get("http://172.23.1.62/novacbs_testing/GI.Common/Home/Login.aspx");
		IntimationSearch Intimation = new IntimationSearch(driver);
		// Login Process using the utility-based structure
		Intimation.login("admin", "nova@1234", "421010");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}