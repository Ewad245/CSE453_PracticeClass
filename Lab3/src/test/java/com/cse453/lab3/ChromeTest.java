package com.cse453.lab3;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

class ChromeTest {
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
	@DisplayName("Title test")
	void getTitle() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		String title = driver.getTitle();
		assertEquals("Web form", title);
	}

	@Test
	@DisplayName("Elements test")
	void getElements() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		textBox.sendKeys("Selenium");
		submitButton.click();
		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		assertEquals("Received!", value);
	}

	@Test
	@DisplayName("Locator Test1")
	void getElementById() {
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement input = driver.findElement(By.id("input-email"));
		input.sendKeys("seleniumtesting@yahoo.com");
		assertEquals("input", input.getTagName());
	}
	
	@Test
	@DisplayName("Locator Test Name")
	void getElementsByName() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textBox = driver.findElement(By.name("my-text"));
	}

	@Test
	@DisplayName("Locator Test3")
	void getElementByLinkText() {
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement link = driver.findElement(By.partialLinkText("Con"));
	}

	@Test
	@DisplayName("Locator Test4")
	void getElementByTagName() {
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement link = driver.findElement(By.tagName("a"));
	}

	@Test
	@DisplayName("Locator Test5")
	void getElementByPartialLinkText() {
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement link = driver.findElement(By.linkText("Continue"));
	}

	@Test
	@DisplayName("Locator Test6")
	void getElementByTagAndId() {
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement link = driver.findElement(By.cssSelector("input#input-password"));
	}

	@DisplayName("Locator Test7")
	@Test
	void getElementByTagAndClass() {
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement link = driver.findElement(By.cssSelector("input.form-control"));
	}

	@DisplayName("Locator Test8")
	@Test
	void getElementByTagAndAttributes() {
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement link = driver.findElement(By.cssSelector("input[name=\"password\"]"));
	}

	@DisplayName("Locator Test9")
	@Test
	void getElementByRelativeLocators() {
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		By emailLocator = RelativeLocator.with(By.id("input-email")).above(By.id("input-password"));
		WebElement input = emailLocator.findElement(driver);
		input.sendKeys("seleniumtesting@yahoo.com");
		assertEquals("input", input.getTagName());
	}

	@DisplayName("Selector Test")
	@Test
	void getSelector() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		Select oselect = new Select(driver.findElement(By.name("my-select")));
	}

	@DisplayName("Selector Index Test")
	@Test
	void getSelectorAndSelectByIndex() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement selector = driver.findElement(By.name("my-select"));
		Select oselect = new Select(selector);
		oselect.selectByIndex(1);
	}

	@DisplayName("Selector Value Test")
	@Test
	void getSelectorAndSelectByValue() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement selector = driver.findElement(By.name("my-select"));
		Select oselect = new Select(selector);
		oselect.selectByValue("1");
	}

	@AfterEach
	void endDrive() {
		driver.quit();
	}

}
