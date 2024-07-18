package com.cse453.lab4.problem1;

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

class Objective4 {

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
	@DisplayName("Exist Check Box 1 Test")
	void getCheckBox1() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement checkBox = driver.findElement(By.cssSelector("input#my-check-1"));
	}
	@Test
	@DisplayName("Exist Check Box 2 Test")
	void getCheckBox2() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement checkBox = driver.findElement(By.cssSelector("input#my-check-2"));
	}
	@Test
	@DisplayName("Check Test 1")
	void testCheckBox1() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement checkBox = driver.findElement(By.cssSelector("input#my-check-1"));
		boolean isChecked = checkBox.isSelected();
		if(isChecked) {
			checkBox.click();
		}
		assertEquals(false, checkBox.isSelected());
	}
	@Test
	@DisplayName("Check Test 2")
	void testCheckBox2() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement checkBox = driver.findElement(By.cssSelector("input#my-check-2"));
		boolean isChecked = checkBox.isSelected();
		if(isChecked) {
			checkBox.click();
		}
		assertEquals(false, checkBox.isSelected());
	}

	@AfterEach
	void endDrive() {
		driver.quit();
	}

}
