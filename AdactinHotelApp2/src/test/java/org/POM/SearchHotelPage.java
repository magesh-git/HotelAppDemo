package org.POM;

import org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SearchHotelPage extends BaseClass {
	
	public SearchHotelPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement location;
	@FindBy(id="hotels")
	private WebElement hotels;
	@FindBy(id="room_type")
	private WebElement roomType;
	@FindBy(id="room_nos")
	private WebElement roomNos;
	@FindBy(id="datepick_in")
	private WebElement checkInDate;
	@FindBy(id="datepick_out")
	private WebElement checkOutDate;
	@FindBy(id="adult_room")
	private WebElement adultRoom;
	@FindBy(id="child_room")
	private WebElement childRoom;
	@FindBy(id="Submit")
	private WebElement search;
	
	public WebElement getLocation() {
		return location;
	}
	
	public WebElement getHotels() {
		return hotels;
	}
	
	public WebElement getRoomType() {
		return roomType;
	}
	
	public WebElement getRoomNos() {
		return roomNos;
	}
	
	public WebElement getCheckInDate() {
		return checkInDate;
	}
	
	public WebElement getCheckOutDate() {
		return checkOutDate;
	}
	
	public WebElement getAdultRoom() {
		return adultRoom;
	}
	
	public WebElement getChildRoom() {
		return childRoom;
	}
	
	public WebElement getSearch() {
		return search;
	}
		
    public void SearchHotelPageOperations() throws InterruptedException{
    	
    	WebElement location2 = getLocation();
    	staticDropDown(location2, "London");
    	WebElement hotels2 = getHotels();
    	staticDropDown(hotels2, "Hotel Sunshine");
    	WebElement roomType2 = getRoomType();
    	staticDropDown(roomType2, "Double");
    	WebElement roomNos2 = getRoomNos();
    	staticDropDown(roomNos2, "2");
    	WebElement checkInDate2 = getCheckInDate();
    	checkInDate2.clear();
    	sendingKeys(checkInDate2, readExcel(2,1));
    	WebElement checkOutDate2 = getCheckOutDate();
    	checkOutDate2.clear();
    	sendingKeys(checkOutDate2, readExcel(3,1));
    	WebElement adultRoom2 = getAdultRoom();
    	staticDropDown(adultRoom2, "2");
    	WebElement childRoom2 = getChildRoom();
    	staticDropDown(childRoom2, "1");
    	SoftAssert as = new SoftAssert();
    	as.assertTrue(false);
    	Thread.sleep(3000);
    	WebElement search2 = getSearch();
    	click(search2);
    	as.assertAll();
    }
}
