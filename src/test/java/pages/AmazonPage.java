package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
	private WebDriver driver;
	
	public AmazonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy (id="search_query")
	public WebElement twotabsearchtextbox; 
//	works for name OR id only. Also, it has to comply
//	with variable naming protocols. it has to be unique
//	too.
	
	

	public void goToWebsite() {
		driver.get("https://www.amazon.com");
	}
	
	public void searchFor(String item) {
		twotabsearchtextbox.clear();
		twotabsearchtextbox.sendKeys(item+Keys.ENTER);
	}
	
	public boolean atAmazonPage() {
		return driver.getTitle().equals("Amazon.com: Online "
				+ "Shopping for Electronics, Apparel, "
				+ "Computers, Books, DVDs & more");
	}
	
	@FindBy (css="img[alt='Product Details']")
	List<WebElement> searchResultItems;
	
	public boolean resultsRdisplayed() {
		return searchResultItems!=null 
				&& searchResultItems.size()>0;
	}
	
	public void checkTheCheckbox(WebElement element) {
		if(!element.isSelected()) {
			element.click();
		}
	}
}
