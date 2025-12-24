package com.omrbranch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.omrbranch.com/");

		driver.manage().window().maximize();

		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("gnanaseeligandhi@gmail.com");

		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("Gnanaseeli@2012");

		WebElement btnLogin = driver.findElement(By.xpath("//button[@value='login']"));
		btnLogin.click();
		Thread.sleep(5000);
		WebElement txtWelcomeMessage = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"));
		String textMsg = txtWelcomeMessage.getText();
		System.out.println(textMsg);

		WebElement txtExploreHotel = driver.findElement(By.xpath("//h5[contains(text(),'Explore')]"));
		String textHotelMsg = txtExploreHotel.getText();
		System.out.println(textHotelMsg);

		WebElement ddnState = driver.findElement(By.id("state"));
		Select selectState = new Select(ddnState);
		selectState.selectByVisibleText("Kerala");

		WebElement ddnCity = driver.findElement(By.id("city"));
		Select selectCity = new Select(ddnCity);
		selectCity.selectByVisibleText("Kochi");

		WebElement ddnRoomType = driver.findElement(By.id("room_type"));
		Select selectRoom = new Select(ddnRoomType);
		selectRoom.selectByVisibleText("Standard");
		selectRoom.selectByVisibleText("Deluxe");
		selectRoom.selectByVisibleText("Suite");
		selectRoom.selectByVisibleText("Luxury");
		selectRoom.selectByVisibleText("Studio");

		WebElement txtCheckIn = driver.findElement(By.name("check_in"));
		txtCheckIn.click();
		WebElement txtDateCheckIn = driver.findElement(By.xpath("//a[contains(text(),'25')]"));
		txtDateCheckIn.click();

		WebElement txtCheckOut = driver.findElement(By.name("check_out"));
		txtCheckOut.click();
		WebElement txtDateCheckOut = driver.findElement(By.xpath("//a[contains(text(),'27')]"));
		txtDateCheckOut.click();

		WebElement ddnNoofRoom = driver.findElement(By.id("no_rooms"));
		Select selectNoofRoom = new Select(ddnNoofRoom);
		selectNoofRoom.selectByVisibleText("3-Three");

		WebElement ddnNoofAdults = driver.findElement(By.id("no_adults"));
		Select selectNoofAdults = new Select(ddnNoofAdults);
		selectNoofAdults.selectByVisibleText("2-Two");

		WebElement ddnNoofChild = driver.findElement(By.id("no_child"));
		ddnNoofChild.sendKeys("1");
	

		driver.switchTo().frame("hotelsearch_iframe");
		WebElement btnSearch = driver.findElement(By.id("searchBtn"));
		btnSearch.click();
		driver.switchTo().defaultContent();
		
		WebElement txtHotel = driver.findElement(By.xpath("//h5[contains(text(),'Select Hotel')]"));
		String text = txtHotel.getText();
		System.out.println(text);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hotellist")));

		List<WebElement> hotels = driver.findElements(By.xpath("//div[@id='hotellist']//h5"));
		System.out.println("---------------");
		System.out.println("Hotels List:");
		for (WebElement hotel : hotels) {
		    System.out.println(hotel.getText());
		}
		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='prize']/strong"));
		System.out.println("---------------");
		System.out.println("Price ");
		for(WebElement price : prices) {
			System.out.println(price.getText());
		}
		
		WebElement fifthHotel = hotels.get(4);
		WebElement selectBtn = fifthHotel.findElement(By.xpath("//a[contains(@class,'filter_btn')]"));
		selectBtn.click();

		Alert al = driver.switchTo().alert();
		al.accept();
		
		WebElement txtBookHotel = driver.findElement(By.xpath("//h2[contains(text(),'Book Hotel - Evoma Studio')]"));
		String txtHotelName = txtBookHotel.getText();
		System.out.println(txtHotelName);
		
		WebElement btnMyself = driver.findElement(By.id("own"));
		btnMyself.click();
		
		WebElement ddnSaturation = driver.findElement(By.id("user_title"));
		Select selectsaturation = new Select(ddnSaturation);
		selectsaturation.selectByVisibleText("Ms.");
		
		WebElement txtFirstName = driver.findElement(By.id("first_name"));
		txtFirstName.sendKeys("Riya");
		
		WebElement txtLastName = driver.findElement(By.id("last_name"));
		txtLastName.sendKeys("G");
		
		WebElement txtNumber = driver.findElement(By.id("user_phone"));
		txtNumber.sendKeys("8778823467");
		
		WebElement txtMail = driver.findElement(By.id("user_email"));
		txtMail.sendKeys("riya2012@gmail.com");
		
		WebElement chkboxGSt = driver.findElement(By.id("gst"));
		chkboxGSt.click();
				
		WebElement txtRegNo = driver.findElement(By.id("gst_registration"));
		txtRegNo.sendKeys("9043592058");
		
		WebElement txtCompanyName = driver.findElement(By.id("company_name"));
		txtCompanyName.sendKeys("Greens Tech OMR Branch");

		WebElement txtCompanyAddress = driver.findElement(By.id("company_address"));
		txtCompanyAddress.sendKeys("Thoraipakkam");
		
		WebElement btnNxt = driver.findElement(By.id("step1next"));
		btnNxt.click();
		
		WebElement btnSplRequest = driver.findElement(By.id("high"));
		btnSplRequest.click();

		WebElement btnNext = driver.findElement(By.id("step2next"));
		btnNext.click();
		
		WebElement txtCardType = driver.findElement(By.xpath("//h5[contains(text(),'Credit/Debit/ATM Card')]"));
		txtCardType.click();
		
		WebElement ddnPaymentType = driver.findElement(By.id("payment_type"));
		Select select = new Select(ddnPaymentType);
		select.selectByVisibleText("Debit Card");
		
		WebElement ddnCardType = driver.findElement(By.id("card_type"));
		Select selectCartType = new Select(ddnCardType);
		selectCartType.selectByVisibleText("Visa");
		
		WebElement txtCardNo = driver.findElement(By.id("card_no"));
		txtCardNo.sendKeys("5555555555552222");

		WebElement txtCardName = driver.findElement(By.id("card_name"));
		txtCardName.sendKeys("Riya");

		WebElement ddnMonth = driver.findElement(By.id("card_month"));
		Select selectMonth = new Select(ddnMonth);
		selectMonth.selectByVisibleText("December");

		WebElement txtCVV = driver.findElement(By.id("cvv"));
		txtCVV.sendKeys("789");
		
		WebElement btnSubmit = driver.findElement(By.id("submitBtn"));
		btnSubmit.click();

		WebElement txtOrderID = driver.findElement(By.xpath("//h2[@name='booking-code']"));
		String txtID = txtOrderID.getText();
		String ID = txtID.split(" ")[0].replace("#", "");
		System.out.println("Order id is : " + ID);
		
		WebElement txtMessage = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"));
		txtMessage.click();
		
		WebElement txtAccount = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
		txtAccount.click();

		WebElement txtBooking = driver.findElement(By.xpath("//h4[contains(text(),'Bookings')]"));
		String txtbooking = txtBooking.getText();
		System.out.println(txtbooking);
		
		WebElement txtEnterID = driver.findElement(By.xpath("//input[@name='search']"));
		txtEnterID.sendKeys(ID);
		
		WebElement txtEdit = driver.findElement(By.xpath("//button[@class='edit btn filter_btn']"));
		txtEdit.click();
		
		WebElement txtEditedDate = driver.findElement(By.xpath("//input[@name='check_in']"));
		txtEditedDate.click();
		
		WebElement txtEditedDateCheck = driver.findElement(By.xpath("//a[contains(text(),'26')]"));
		txtEditedDateCheck.click();
		
		WebElement txtEditConfirm = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
		txtEditConfirm.click();

		WebElement txtSts = driver.findElement(By.xpath("//li[contains(text(),'Booking updated successfully')]"));
		String txtConfirmation = txtSts.getText();
		System.out.println(txtConfirmation);
		
		WebElement txtEnterId = driver.findElement(By.xpath("//input[@name='search']"));
		txtEnterId.sendKeys(ID);

		WebElement txtCancel = driver.findElement(By.xpath("//a[@onclick=\"return confirm('Are you sure you want to cancel this booking?')\"]"));
		txtCancel.click();
		
		Alert alert =driver.switchTo().alert();
		alert.accept();

		WebElement txtStatus = driver.findElement(By.xpath("//li[contains(text(),'Your booking cancelled successfully')]"));
		String txtCancelConfirmation = txtStatus.getText();
		System.out.println(txtCancelConfirmation);

		
//		driver.close();
	}

}
