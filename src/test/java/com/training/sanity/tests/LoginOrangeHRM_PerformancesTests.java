package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.traning.pom.PerformancesHomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginOrangeHRM_PerformancesTests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private PerformancesHomePage performanceshomepage;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest eTest;
	private PerformancesHomePage performancehomepage;
	@BeforeTest
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseUrl);
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("PerformancesTestReport.html");
		extent.attachReporter(htmlReporter);
		
	}
	@Test
	public void loginPassTest() throws IOException {
		loginPOM.sendUserName("Admin");
		loginPOM.sendPassword("admin123");
		loginPOM.clickLoginBtn();	
	}
	@Test
    public void testSearchEmployeePerformance() {
        eTest = extent.createTest("Search Employee Performance Test");

        // Input employee details
        performanceshomepage.enterEmployeeName("Lakshmi");
        performancehomepage.selectJobTitle("Software Engineer");
        performancehomepage.selectSubUnit("Engineering");
        performancehomepage.selectInclude("Current and Past Employees");
        performancehomepage.selectReviewStatus("Completed");
        performancehomepage.enterFromDate("2024-01-01");
        performancehomepage.enterToDate("2024-12-31");
        performancehomepage.clickSearch();

        // Assert search result text
        String searchResultsText = performancehomepage.getSearchResultsText();
        eTest.info("Search Results Text: " + searchResultsText);

        Assert.assertTrue(searchResultsText.contains("Lakshmi"), "Employee not found in search results");
    }
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		extent.flush();
	}

}
