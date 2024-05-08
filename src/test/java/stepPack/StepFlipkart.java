package stepPack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import basePack.BaseFlip;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pomPack.pomFlipkart;

public class StepFlipkart extends BaseFlip {

	pomFlipkart pom = new pomFlipkart();

	@Given("User enter the Flipkart url")
	public void user_enter_the_flipkart_url() {
		geturl("https://www.flipkart.com/");
		implicitWait();
	}

	@Then("User click the Electronics")
	public void user_click_the_electronics() throws InterruptedException, IOException {
		driver.findElement(pom.electronic).click();
	}

	@Then("User click Mobilecase")
	public void user_click_mobilecase() throws IOException, InterruptedException {
		
		try {
			WebElement mobileHover = driver.findElement(pom.mobile);
			Actions action = new Actions(driver);
			action.moveToElement(mobileHover).perform();

			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			File pathSrc = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img1.png");
			FileUtils.copyFile(srcFile, pathSrc);

			driver.findElement(pom.mobileCase).click();
			Thread.sleep(500);

		} catch (Exception e) {
			System.out.println("Don't click mobile case so, this is Error");
		}
	}

	@Then("User Select four type mobile case")
	public void user_select_four_type_mobile_case() throws InterruptedException {
		WebElement srl = driver.findElement(By.xpath("//div[text()=\"Compatible Mobiles\"]"));
		jsScroll(srl);
		Thread.sleep(1000);
		driver.findElement(pom.sltCase1).click();
		Thread.sleep(1000);
		driver.findElement(pom.sltCase2).click();
		Thread.sleep(500);
		jsScroll(srl);
		driver.findElement(pom.sltCase3).click();
		Thread.sleep(500);
		jsScroll(srl);
		driver.findElement(pom.sltCase4).click();
		Thread.sleep(1000);
//		WebElement srcDw = driver.findElement(pom.srlDown);
//		jsScroll(srcDw);

	}

	@Then("User Select one mobile case")
	public void user_select_one_mobile_case() throws IOException {
		implicitWait();
		driver.findElement(pom.caseSlt).click();

		Set<String> windowHandle = driver.getWindowHandles();
		Iterator<String> it = windowHandle.iterator();
		String parId = (String) it.next();
		String childId = it.next();

		driver.switchTo().window(childId);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File pathSrc = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img2.png");
		FileUtils.copyFile(srcFile, pathSrc);
	}

	@Then("User Click the Buynow button")
	public void user_click_the_buynow_button() throws InterruptedException, IOException {
		driver.findElement(pom.buyNow).click();
		Thread.sleep(500);
		driver.findElement(pom.entNo).sendKeys("8508502502");
		driver.findElement(pom.clkContinue).click();
		Thread.sleep(500);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File pathSrc = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img3.png");
		FileUtils.copyFile(srcFile, pathSrc);

	}

	@Then("User Click the Navigate back and close")
	public void user_click_the_navigate_back_and_close() throws InterruptedException, IOException {
		driver.navigate().back();
		Thread.sleep(1000);
		driver.close();
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> win = new ArrayList<String>(windowHandle);
		driver.switchTo().window(win.get(0));

	}

	@Then("User come to the Main page")
	public void user_come_to_the_main_page() throws IOException {
		
		for (int i = 0; i < 5; i++) {
			driver.navigate().back();
		}
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File pathSrc = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img4.png");
		FileUtils.copyFile(srcFile, pathSrc);

	}

	@Then("Click the Mobile")
	public void click_the_mobile() {
		
		try {
			Thread.sleep(1000);
			driver.findElement(pom.clsPop).click();
		} catch (Exception e) {
			System.out.println("No login page.so, skip this ");
		}

		driver.findElement(pom.clkMob).click();
	}

	@Then("Scrolldown the Apple mobile")
	public void scrolldown_the_apple_mobile() {

		WebElement vivo = driver.findElement(pom.srcVivo);
//		jsScroll(vivo);

	}

	@Then("Click the Iphone15 blue version")
	public void click_the_iphone_blue_version() throws IOException, InterruptedException {

		driver.findElement(pom.clkApple).click();
		Thread.sleep(500);

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File pathSrc = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img5.png");
		FileUtils.copyFile(srcFile, pathSrc);
	}

	@Then("Again click buynow and fill details")
	public void again_click_buynow_and_fill_details() throws InterruptedException, IOException {

		Set<String> windowHandle1 = driver.getWindowHandles();
		List<String> win1 = new ArrayList<String>(windowHandle1);
		driver.switchTo().window(win1.get(1));
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File pathSrc = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img6.png");
		FileUtils.copyFile(srcFile, pathSrc);
		
		driver.findElement(pom.buyNow).click();
		Thread.sleep(500);
		driver.findElement(pom.entNo).sendKeys("9876543210");
		driver.findElement(pom.clkContinue).click();
		Thread.sleep(500);
	}

	@Then("Take screenshot, navigate back and close")
	public void take_screenshot_navigate_back_and_close() throws IOException, InterruptedException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File pathSrc = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img7.png");
		FileUtils.copyFile(srcFile, pathSrc);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.close();

	}

	@Then("Again user Come to Main page")
	public void again_user_come_to_main_page() throws IOException {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handle.get(0));

		driver.navigate().back();

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File pathSrc = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img8.png");
		FileUtils.copyFile(srcFile, pathSrc);
	}

	@Then("Click Search and search a earbuds")
	public void click_search_and_search_a_earbuds() throws InterruptedException, IOException {
		
		try {
			Thread.sleep(1000);
			driver.findElement(pom.clsPop).click();
		} catch (Exception e) {
			System.out.println("No login page.so, skip this ");
		}

		driver.findElement(pom.clkSearch).sendKeys("Portronics earbuds", Keys.ENTER);

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File pathSrc = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img9.png");
		FileUtils.copyFile(srcFile, pathSrc);

	}

	@Then("Select one earbus and click")
	public void select_one_earbus_and_click() throws InterruptedException {
		
		driver.findElement(pom.sltEarbuds).click();
		Thread.sleep(500);

	}

	@Then("Add to cart  and take screenshot")
	public void add_to_cart_and_take_screenshot() throws IOException {
		
		TakesScreenshot screenshot1 = (TakesScreenshot) driver;
		File srcFile1 = screenshot1.getScreenshotAs(OutputType.FILE);
		File pathSrc1 = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img10.png");
		FileUtils.copyFile(srcFile1, pathSrc1);

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> hand = new ArrayList<String>(windowHandles);

		driver.switchTo().window(hand.get(1));

		driver.findElement(pom.clkAddcart).click();
		
	}

	@Then("Add the maximum quantity")
	public void add_the_maximum_quantity() throws InterruptedException, IOException {
		
		WebElement addQty = driver.findElement(pom.addQuty);

		for (int i = 1; i < 10; i++) {
			addQty.click();
			Thread.sleep(500); 
		}

		TakesScreenshot screenshot2 = (TakesScreenshot) driver;
		File srcFile2 = screenshot2.getScreenshotAs(OutputType.FILE);
		File pathSrc2 = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testin_Flipkart\\Flipkart_Image\\img11.png");
		FileUtils.copyFile(srcFile2, pathSrc2);
		
		driver.navigate().back();
		
	}

}
