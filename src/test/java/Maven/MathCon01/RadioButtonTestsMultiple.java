package Maven.MathCon01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RadioButtonTestsMultiple {

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
		driver.manage().window().maximize();
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
		for(int i=0; i<10; i++) {
		util.answerA.click();
		Thread.sleep(100);
		util.answerB.click();
		Thread.sleep(100);
		util.answerC.click();
		Thread.sleep(100);
		util.answerD.click();
		Thread.sleep(100);
		util.answerE.click();
		Thread.sleep(100);}
		util.nextButtonID.click();
		for(int i=0; i<10; i++) {
			util.answerA.click();
			Thread.sleep(100);
			util.answerB.click();
			Thread.sleep(100);
			util.answerC.click();
			Thread.sleep(100);
			util.answerD.click();
			Thread.sleep(100);
			util.answerE.click();
			Thread.sleep(100);}
		util.finishButtonID.click();
		String completeTestText = util.sureToCompleteText.getText();
		System.out.println("Text: " + completeTestText);	
		String text = "You have one or more not answered questions. Are you sure you want to complete the test?";		
		if(completeTestText.equalsIgnoreCase(text)) {
			util.goBackToTest.click();
			System.out.println("Incomplete test!");
		} else {
		util.completeTest.click();	
		System.out.println("Completed the test successfully!");
		}
	}

	@DataProvider
	public static Object [][] data () {
		Object [][] dt = new Object [2][2];
		dt [0][0] = "aa4009";
		dt [0][1] = "crgqvb";
		dt [1][0] = "bb7540";
		dt [1][1] = "k9qsnc";
		return dt;
	}
}
