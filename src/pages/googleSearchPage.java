package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class googleSearchPage {

	private WebDriver driver;
    private WebElement searchBox;
    private WebElement acceptCookiesButton;

    public googleSearchPage(WebDriver driver) {
        this.driver = driver;
        searchBox = driver.findElement(By.id("APjFqb"));
        acceptCookiesButton = driver.findElement(By.id("L2AGLb"));
    }

    public void acceptCookies() {
        acceptCookiesButton.sendKeys(Keys.RETURN);
    }

    public void fillSearchForm(String searchPhrase) {
        searchBox.sendKeys(searchPhrase);
    }

    public void submitSearchForm() {
        searchBox.sendKeys(Keys.RETURN);
    }
}
