package Maven.MathCon01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Utility {
	public WebDriver driver;
	public Utility(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[id='Input_Email']")
	WebElement usernameID;
	
	@FindBy(css="input[id='Input_Password']")
	WebElement passwordID;
	
	@FindBy(css="button[class='btn btn-lg btn-primary btn_reg sign_in_btn']")
	WebElement signInID;
	
	@FindBy(css="a[id='1374']")
	WebElement practiceTest1;
	
	@FindBy(xpath="//div[@id='answerOptions1']/label[1]")
	WebElement answerA;
	
	@FindBy(xpath="//div[@id='answerOptions1']/label[2]")
	WebElement answerB;
	
	@FindBy(xpath="//div[@id='answerOptions1']/label[3]")
	WebElement answerC;
	
	@FindBy(xpath="//div[@id='answerOptions1']/label[4]")
	WebElement answerD;
	
	@FindBy(xpath="//div[@id='answerOptions1']/label[5]")
	WebElement answerE;
	
	@FindBy(css="button[id='next-button']")
	WebElement nextButtonID;
	
	@FindBy(css="button[id='previous-button']")
	WebElement previousButtonID;
	
	@FindBy(css="button[id='finish-button']")
	WebElement finishButtonID;
	
	@FindBy(xpath="//div[@class='modal-content']/div[1]")
	WebElement sureToCompleteText;
	
	@FindBy(xpath="//body/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/button[1]")
	WebElement goBackToTest;
	
	@FindBy(css="button[id='complete-test-btn']")
	WebElement completeTest;
	
	@FindBy(xpath="//span[contains(text(),'Support')]")
	WebElement supportID;
	
	@FindBy(xpath="//span[contains(text(),'Sign out')]")
	WebElement signOutID;
	
	
	
	
	
	
	
	
	
	
	
}
