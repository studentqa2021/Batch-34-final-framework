package com.generic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.page.object.model.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	WebDriver driver ;
	@Given("Open browser and  go to application")
	public void open_browser_and_go_to_application() {
	    //code 
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/sarow/OneDrive/Desktop/Banking%20Application/Batch%2034/Statements/dev_online%20Banking%20monthly_yearly%20statement.html");
	    
	}

	@When("put valid user name")
	public void put_valid_user_name() {
		driver.findElement(LoginPage.userName).sendKeys("Batch34");
	    
	}

	@When("put valid password value")
	public void put_valid_password_value() {
		driver.findElement(LoginPage.passWord).sendKeys("student123@");
	    
	}

	@When("click login button")
	public void click_login_button() {
		driver.findElement(LoginPage.logIn).click();;
	    
	}

	@Then("logout should there")
	public void logout_should_there() {
	    // TestNG/Junit>> Assertion = Hard Assert & SoftAssert
	
	//Assert.assertEquals(false, false);
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(driver.findElement(LoginPage.logOut).isDisplayed());
	    
		sf.assertAll();
	}

	@When("put invalid user name")
	public void put_invalid_user_name() {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dasdasd");
	    
	}

	@When("put invalid password value")
	public void put_invalid_password_value() {
	    
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("xsadasd");
	}

	@Then("alert msg showed Invalid username or password")
	public void alert_msg_showed_invalid_username_or_password() {
	    // Alert interface
		
		Alert alert = driver.switchTo().alert();
		String alertMsg =alert.getText();
		
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(alertMsg,"Invalid username or password" );
	    
	}

	@When("put null user")
	public void put_null_user() {
	    
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("");
	}

	@When("put null password")
	public void put_null_password() {
	    
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("");
	}

	@When("click login")
	public void click_login() {
	    
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}




}
