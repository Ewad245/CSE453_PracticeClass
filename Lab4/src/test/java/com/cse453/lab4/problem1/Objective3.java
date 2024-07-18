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

class Objective3 {

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
	@DisplayName("Exist Dropbox Test")
	void getDropDown() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement dropDown = driver.findElement(By.cssSelector("select[name=\"my-select\"]"));
	}
	@Test
	@DisplayName("Size Test")
	void getSize() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement dropDown = driver.findElement(By.cssSelector("select[name=\"my-select\"]"));
		Select select = new Select(dropDown);
		List<WebElement> list = select.getOptions();
		assertEquals(3, list.size());
	}
	
	@Test
	@DisplayName("Value Test")
	void getValue() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement dropDown = driver.findElement(By.cssSelector("select[name=\"my-select\"]"));
		Select select = new Select(dropDown);
		select.selectByValue("2");
	}

	@AfterEach
	void endDrive() {
		driver.quit();
	}

}
