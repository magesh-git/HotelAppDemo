package org.Runner;

import java.io.IOException;

import org.POM.HomePage;
import org.POM.SearchHotelPage;
import org.baseClass.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRunner extends BaseClass{
	@BeforeTest
	public void webDriverLaunch() throws IOException {
		driverIntialization();
	}
	
	@Test
	public void execution() throws IOException, InterruptedException {
		HomePage hp=new HomePage();
		hp.HomePageOperations();
		SearchHotelPage sh= new SearchHotelPage();
		sh.SearchHotelPageOperations();
	}
}
