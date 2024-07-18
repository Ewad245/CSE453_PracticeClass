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

class Objective6 {

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
	@DisplayName("Sign In Not Exist Account Test")
	void signInTest() {
		driver.get("https://magento.softwaretestingboard.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement signIn= driver.findElement(By.linkText("Sign In"));
		signIn.click();
		WebElement email= driver.findElement(By.cssSelector("input#email"));
		WebElement pass= driver.findElement(By.cssSelector("input#pass"));
		email.sendKeys("dasda@gmail.com");
		pass.sendKeys("dsadadvc");
		driver.findElement(By.cssSelector("button[name=\"send\"]")).click();
		WebElement error = driver.findElement(By.cssSelector("div.message-error"));
		
	}

	@AfterEach
	void endDrive() {
		driver.quit();
	}

}
