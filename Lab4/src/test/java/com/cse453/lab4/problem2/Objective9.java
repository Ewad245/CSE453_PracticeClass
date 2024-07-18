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
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

class Objective9 {

	WebDriver driver;

	@BeforeAll
	static void setupDriver() {
		WebDriverManager.firefoxdriver().setup();
	}

	@BeforeEach
	void getDriver() {
		driver = new FirefoxDriver();
	}

	@Test
	@DisplayName("Place Order Test")
	void orderTest() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.linkText("Fusion Backpack")).click();
		WebElement addToCart = driver.findElement(By.cssSelector("button#product-addtocart-button"));
		addToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("shopping cart"))).click();
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/ul/li[1]/button")).click();
		driver.findElement(By.xpath(
				"/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[1]/fieldset/div/div/input"))
				.sendKeys("103green@belgianairways.com");
		driver.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("asfa");
		driver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys("safafa");
		driver.findElement(By.cssSelector("input[name=\"street[0]\"]")).sendKeys("sadsdaa");
		driver.findElement(By.cssSelector("input[name=\"street[1]\"]")).sendKeys("agagsagaf");
		driver.findElement(By.cssSelector("input[name=\"street[2]\"]")).sendKeys("afsafaa");
		driver.findElement(By.cssSelector("input[name=\"city\"]")).sendKeys("dgdfgdd");
		Select select = new Select(driver.findElement(By.cssSelector("select[name=\"region_id\"]")));
		select.selectByIndex(3);
		driver.findElement(By.cssSelector("input[name=\"postcode\"]")).sendKeys("12121");
		Select select2 = new Select(driver.findElement(By.cssSelector("select[name=\"country_id\"]")));
		select2.selectByIndex(3);
		driver.findElement(By.cssSelector("input[name=\"telephone\"]")).sendKeys("12121212331");
		By radioLocator = RelativeLocator.with(By.tagName("input")).below(By.cssSelector("div.step-title"));

		// List<WebElement> ratios = driver.findElements(By.cssSelector("input.ratio"));
		// ratios.get(0).click();
		WebElement radio = driver.findElements(radioLocator).get(0);
		if (!radio.isSelected()) {
			radio.click();
		}
		if (radio.isDisplayed() && radio.isSelected()) {
			driver.findElement(By.cssSelector("button.button.action.continue.primary")).click();
		}
		try {
			driver.findElement(By.xpath(
					"/html/body/div[3]/main/div[2]/div/div[2]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button"));
		} catch (NoSuchElementException ex) {
			driver.findElement(By.cssSelector("button.button.action.continue.primary")).click();
		}
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.primary.checkout")));
			element.click();
		} catch (ElementClickInterceptedException ex) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-mask")));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.primary.checkout")));
			element.click();
		}
		wait.until(ExpectedConditions.titleContains("Success Page"));
		String thank = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
		assertEquals("Thank you for your purchase!", thank);
	}
	@AfterEach
	void endDrive() {
		driver.quit();
	}

}
