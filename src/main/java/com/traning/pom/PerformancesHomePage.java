package com.traning.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PerformancesHomePage {
	WebDriver driver;

    // Locate elements
    @FindBy(id = "employeeName")
    private WebElement employeeNameInput;
    @FindBy(id = "jobTitle") WebElement jobTitleDropdown;
    @FindBy(id = "subUnit") WebElement subUnitDropdown;
    @FindBy(id = "include") WebElement includeDropdown;
    @FindBy(id = "reviewStatus") WebElement reviewStatusDropdown;
    @FindBy(id = "fromDate") WebElement fromDateInput;
    @FindBy(id = "toDate") WebElement toDateInput;
    @FindBy(id = "searchBtn") WebElement searchButton;
    @FindBy(xpath = "//*[@id='resultTable']") WebElement searchResultsTable;

    // Constructor
    public PerformancesHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods for interacting with elements
    public void enterEmployeeName(String name) {
        employeeNameInput.sendKeys(name);
    }

    public void selectJobTitle(String jobTitle) {
        jobTitleDropdown.sendKeys(jobTitle);
    }

    public void selectSubUnit(String subUnit) {
        subUnitDropdown.sendKeys(subUnit);
    }

    public void selectInclude(String includeOption) {
        includeDropdown.sendKeys(includeOption);
    }

    public void selectReviewStatus(String reviewStatus) {
        reviewStatusDropdown.sendKeys(reviewStatus);
    }

    public void enterFromDate(String fromDate) {
        fromDateInput.sendKeys(fromDate);
    }

    public void enterToDate(String toDate) {
        toDateInput.sendKeys(toDate);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public String getSearchResultsText() {
        return searchResultsTable.getText();
    }

	

}
