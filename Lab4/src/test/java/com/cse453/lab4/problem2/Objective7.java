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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

class Objective7 {

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
	@DisplayName("Search Test")
	void searchTest() {
		driver.get("https://magento.softwaretestingboard.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement search = driver.findElement(By.cssSelector("input#search"));
		search.sendKeys("Tank");
		search.sendKeys(Keys.ENTER);
		WebElement tank = driver.findElement(By.linkText("Primo Endurance Tank"));
		tank.click();
		String title = driver.getTitle();
		assertEquals("Primo Endurance Tank", title);

	}

	@AfterEach
	void endDrive() {
		driver.quit();
	}

}
