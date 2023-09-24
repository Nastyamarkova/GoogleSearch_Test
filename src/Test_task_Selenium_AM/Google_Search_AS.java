package Test_task_Selenium_AM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.googleSearchPage;
import pages.googleResultsSearchPage;

public class Google_Search_AS {

	private static final String SEARCH_PHRASE = "Web Development course in Berlin";
	private static final String GECKO_DRIVER_PATH = "C:\\selenium-webdriver\\FirefoxDriver\\geckodriver.exe";

	private static WebDriver driver = null;

	public static void main(String[] args) {

		googleSearch();
	}

	public static void googleSearch() {
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.google.com/");

		googleSearchPage searchPage = new googleSearchPage(driver);
		searchPage.acceptCookies();
		searchPage.fillSearchForm(SEARCH_PHRASE);
		searchPage.submitSearchForm();

		googleResultsSearchPage resultsPage = new googleResultsSearchPage(driver);

		resultsPage.waitForResultsPage();
		boolean searchResultsVisible = resultsPage.areSearchResultsVisible();
		
		if (searchResultsVisible) {
			
			resultsPage.openFirstNonAdResult();
			boolean newPageOpened = resultsPage.isNewPageOpened(SEARCH_PHRASE);
			boolean pageContainsSearchPhrase = resultsPage.doesNewPageContainSearchPhrase(SEARCH_PHRASE);
			
			if (newPageOpened && pageContainsSearchPhrase) {
				System.out.println("Test completed successfully.");

			} else {
				System.err.println("Test failed: New page not opened or doesn't contain the search phrase.");
			}
		} else {
			System.err.println("Test failed: Search results not visible.");
		}

		driver.close();
	}

}
