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

class Objective1 {

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
	@DisplayName("Exist Page test")
	void getTitle() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		String title = driver.getTitle();
		assertEquals("Web form", title);
	}

	@Test
	@DisplayName("Exist return to index test")
	void getElements() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement link= driver.findElement(By.linkText("Return to index"));
	}
	@Test
	@DisplayName("Title test")
	void testTitle() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.findElement(By.linkText("Return to index")).click();
		String title = driver.getTitle();
		assertEquals("Index of Available Pages", title);
	}
	@AfterEach
	void endDrive() {
		driver.quit();
	}

}
