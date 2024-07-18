package com.cse453.lab4.problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

class Objective5 {

	WebDriver driver;

	@BeforeAll
	static void setupDriver() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void getDriver() {
		driver = new ChromeDriver();
	}

	@Test
	@DisplayName("Exist Create an Account button Test")
	void getCheckBox1() {
		driver.get("https://magento.softwaretestingboard.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement link= driver.findElement(By.linkText("Create an Account"));
	}
	@Test
	@DisplayName("Create Account Test")
	void createAccount() {
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement username= driver.findElement(By.cssSelector("input[name=\"firstname\"]"));
		WebElement lastname= driver.findElement(By.cssSelector("input[name=\"lastname\"]"));
		WebElement email= driver.findElement(By.cssSelector("input[name=\"email\"]"));
		WebElement password= driver.findElement(By.cssSelector("input[name=\"password\"]"));
		WebElement passwordconfirm= driver.findElement(By.cssSelector("input#password-confirmation"));
		username.sendKeys("aac");
		lastname.sendKeys("bbc");
		email.sendKeys("yellowmadeleine@belgianairways.com");
		password.sendKeys("asdQWE!@#");
		passwordconfirm.sendKeys("asdQWE!@#");
		driver.findElement(By.cssSelector("button.action.submit")).click();
		WebElement loggedIn = driver.findElement(By.cssSelector("span.logged-in"));
	}

	@AfterEach
	void endDrive() {
		driver.quit();
	}

}
