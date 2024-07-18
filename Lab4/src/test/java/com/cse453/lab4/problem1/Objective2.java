package com.cse453.lab4.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class Objective2 {

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
	@DisplayName("Exist Text Box 1 Test")
	void getTextBox1() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textBox= driver.findElement(By.cssSelector("input[name=\"my-text\"]"));
	}
	@Test
	@DisplayName("Exist Text Box 2 Test")
	void getTextBox2() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textBox= driver.findElement(By.cssSelector("input[name=\"my-password\"]"));
	}
	@Test
	@DisplayName("Set Text Box 1 Test")
	void setTextBox1() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textBox= driver.findElement(By.cssSelector("input[name=\"my-text\"]"));
		textBox.sendKeys("User01");
	}
	@Test
	@DisplayName("Set Text Box 2 Test")
	void setTextBox2() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textBox= driver.findElement(By.cssSelector("input[name=\"my-text\"]"));
		textBox.sendKeys("Password01");
	}
	@AfterEach
	void endDrive() {
		driver.quit();
	}

}
