package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleResultsSearchPage {

	WebDriver driver;
	WebElement searchResults;
	String searchPhrase = "Web Development course in Berlin";

	public googleResultsSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForResultsPage()

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		searchResults = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchform")));

	}

	public boolean areSearchResultsVisible() {
		WebElement resultsStats = driver.findElement(By.id("searchform"));
		return resultsStats.isDisplayed();
	}

	public void openFirstNonAdResult() {

		List<WebElement> nonAdLinks = new WebDriverWait(driver, Duration.ofSeconds(6))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@jsname='UWckNb']")));

		if (!nonAdLinks.isEmpty()) {
			WebElement firstLink = driver.findElement(By.tagName("h3"));
			firstLink.click();
		}
	}

	public boolean isNewPageOpened(String expectedTitle) {
		String currentPageTitle = driver.getTitle();
		boolean pageOpened = currentPageTitle.contains(expectedTitle);
		if (!pageOpened) {
			System.err.println("The new page was not opened.");
			driver.quit();
		}
		return pageOpened;
	}

	public boolean doesNewPageContainSearchPhrase(String searchPhrase) {
		String pageSource = driver.getPageSource();
		boolean containsSearchPhrase = pageSource.contains(searchPhrase);
		if (!containsSearchPhrase) {
			System.err.println("The new page does not contain the initial search phrase.");
		}
		return containsSearchPhrase;
	}
}
