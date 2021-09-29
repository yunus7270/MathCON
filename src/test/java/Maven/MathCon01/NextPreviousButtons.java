package Maven.MathCon01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NextPreviousButtons {
	public static WebDriver driver;
	@Test
	public static void test01 () throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\ogurlu\\eclipse-workspace\\MathCon01\\src\\main\\java\\Maven\\MathCon01\\file.properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ogurlu\\Desktop\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test (dataProvider = "data")
	public static void test02 (String username, String password) {
		Utility util = new Utility(driver);
		util.usernameID.sendKeys(username);
		util.passwordID.sendKeys(password);
		util.signInID.click();
		util.practiceTest1.click();
	}
	
	@Test
	public static void test03 () throws InterruptedException {
		Utility util = new Utility(driver);
		
		util.answerC.click();
		for(int i=0; i<16; i++) {
		util.nextButtonID.click();
		}
		for(int i=0; i<16; i++) {
			util.previousButtonID.click();
			}
			
		util.finishButtonID.click();
		
		String completeTestText = util.sureToCompleteText.getText();
		System.out.println("Text: " + completeTestText);
		
		String text = "You have one or more not answered questions. Are you sure you want to complete the test?";		
		if(completeTestText.equalsIgnoreCase(text)) {
			util.goBackToTest.click();
		} else {
			util.completeTest.click();
		}
	}
	
	@DataProvider
	public static Object [][] data () {
		Object [][] dt = new Object [1][2];
		dt [0][0] = "aa4009";
		dt [0][1] = "crgqvb";
		return dt;
	}
	@AfterTest
	public static void afterTest() {
	driver.close();
	}
	
	
}
