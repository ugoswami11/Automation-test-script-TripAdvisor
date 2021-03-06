package testObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import userDefinedLibraries.DatePicker;

public class HolidayHomesPage {

	final WebDriver driver;
	public static WebDriverWait wait;

	// Locate the Check-in web element and return it
	@FindBy(how = How.XPATH, using = "//div[@class='cYOaT z f u']")
	public WebElement checkIn;

	// Locate the Check-out web element and return it
	@FindBy(how = How.XPATH, using = "//div[@class='ecYkW z f u']")
	public WebElement checkOut;

	// Locate the Calender web element and return it
	@FindBy(how = How.XPATH, using = "//div[@class='cBtAm Za f e']")
	public WebElement calendar;

	// Locate the Guests web element and return it
	@FindBy(how = How.XPATH, using = "//div[text()='Guests']")
	public WebElement guestSelection;

	// Locate the Guest Number web element and return it
	@FindBy(how = How.XPATH, using = "//div[@class='fqdlM P4']/div[2]//div[@class='cLKZK']/input")
	public WebElement guestNumber;

	// Locate the Add web element and return it
	@FindBy(how = How.XPATH, using = "//div[@class='fqdlM P4']/div[2]//div[@class='cLKZK']/span[2]/span")
	public WebElement addGuest;

	// Locate the Apply web element and return it
	@FindBy(how = How.XPATH, using = "//button[text()='Apply']")
	public WebElement applyGuest;

	// Locate the Sort By web element and return it
	@FindBy(how = How.XPATH, using = "//div[@class='eiluo']") /******* ### ***/
	public WebElement sortBy;

	// Locate all the Sort By elements and store them in a list and return it
	@FindBy(how = How.XPATH, using = "//div[@class='eiluo']/div/div[2]//span")
	public List<WebElement> sortByItems;

	// Locate all the Show More elements and store them in a list and return it
	@FindBy(how = How.XPATH, using = "//div[@class='eduCX Cj b S4 H3 _S']/span[1]")
	public List<WebElement> amenitiesShowMore;

	// Locate the Lift Access web element and return it
	@FindBy(how = How.XPATH, using = "//span[@class='fhxxE']/div[contains(text(),'Elevator')]")
	public WebElement liftAccess;

	// Locate all the Hotel Name elements and store them in a list and return it
	@FindBy(how = How.XPATH, using = "//div[@class='bRCzV f']/h2/a")
	public List<WebElement> hotelNames;

	// Locate all the Total Price elements and store them in a list and return it
	@FindBy(how = How.XPATH, using = "//div[@class='ciZLE']")
	public List<WebElement> totalPrice;

	// Locate all the Per Night Cost elements and store them in a list and return it
	@FindBy(how = How.XPATH, using = "//div[@class='bWUxM']/div/div[1]")
	public List<WebElement> pricePerNight;

	// Locate the Cruises element and return it
	@FindBy(how = How.XPATH, using = "//span[text()='Cruises']")
	public WebElement cruisesBtn;

	// Create a constructor to invoke the driver and initialize wait
	public HolidayHomesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	// Method to click on Check In
	public void checkInDateClick() {
		checkIn.click();
	}

	// Method to select Check In Date
	public void setCheckInDate(String checkInDate) {
		wait.until(ExpectedConditions.visibilityOf(calendar));
		DatePicker.getDateValue(checkInDate, driver);
	}

	// Method to click on Check Out
	public void checkOutDateClick() {
		checkOut.click();
	}

	// Method to select Check Out Date
	public void setCheckOutDate(String checkOutDate) {
		wait.until(ExpectedConditions.visibilityOf(calendar));
		DatePicker.getDateValue(checkOutDate, driver);
	}

	// Method to click on Guests
	public void guestButton() {
		guestSelection.click();
	}

	// Method to Add Guest
	public void addPerson(String guestNum) {
		wait.until(ExpectedConditions.visibilityOfAllElements(guestNumber));
		guestNum = guestNum.substring(0, 1);
		while (true) {
			if (guestNumber.getAttribute("value").contains(guestNum)) {
				break;
			}
			addGuest.click();
		}
	}

	// Method to click on Apply
	public void applyButton() {
		applyGuest.click();
	}

	// Method to click on Sort By
	public void sortByDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(sortBy));
		sortBy.click();
	}

	// Method to select an option from Sort By list
	public void sortByOptions(String sortCategory) {
		wait.until(ExpectedConditions.visibilityOfAllElements(sortByItems));
		sortByItems.get(3).click();
		for (WebElement a : sortByItems) {
			if (a.getText().equals(sortCategory)) {
				a.click();
			}
		}
	}

	// Method to click on 2nd Show More
	public void showMoreBox() {

		amenitiesShowMore.get(1).click();
	}

	// Method to click on List Access
	public void liftAccessCheckbox() {
		wait.until(ExpectedConditions.visibilityOf(liftAccess));

		liftAccess.click();
	}

	// Method to fetch Hotel Names
	public String[] getHotelNames(int num) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// int size = hotelNames.size();
		String[] names = new String[num];
		for (int i = 0; i < num; i++) {
			names[i] = hotelNames.get(i).getText();
		}
		return names;
	}

	// Method to fetch Total Price of the Hotels
	public String[] getTotalPrice(int num) {

		String[] totalValue = new String[num];
		for (int i = 0; i < num; i++) {
			totalValue[i] = totalPrice.get(i).getText().substring(1);
		}
		return totalValue;
	}

	// Method to fetch Per Night Cost of the Hotels
	public String[] getPerNightPrice(int num) {

		String[] pernightPrice = new String[num];
		for (int i = 0; i < num; i++) {
			pernightPrice[i] = pricePerNight.get(i).getText().substring(1);
		}
		return pernightPrice;
	}

	// Method to click on Cruises
	public void cruisesTab() {

		cruisesBtn.click();
	}

}
