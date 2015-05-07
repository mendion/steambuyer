import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import com.google.common.collect.Lists;

@RunWith(Parallelized.class)
public class FeatureTest {
    // This is the parameter for each instance of the test.
    private List<Item> items;

    public FeatureTest(List<Item> items)
    {
         this.items = items;
    }

    @Parameters
    public static List<Object> getParameters()     
    {         
        List<Item> items1 = new ArrayList<Item>();
        items1.add(new Item("http://steamcommunity.com/market/listings/730/USP-S%20|%20Guardian%20%28Minimal%20Wear%29", 0.1, 10));
        items1.add(new Item("http://steamcommunity.com/market/listings/730/AK-47%20|%20Redline%20%28Field-Tested%29", 0.1, 10));
        
        List<Item> items2 = new ArrayList<Item>();
        items2.add(new Item("http://steamcommunity.com/market/listings/730/AK-47%20|%20Elite%20Build%20%28Minimal%20Wear%29", 0.1, 10));
        items2.add(new Item("http://steamcommunity.com/market/listings/730/AWP%20|%20Asiimov%20%28Battle-Scarred%29", 0.1, 10));
        
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(new Object[] { items1 });
        parameters.add(new Object[] { items2 });
        return parameters;
    }
 
    @Test
    public void testOneFeature() throws InterruptedException {
    	ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		WebDriver driver = new FirefoxDriver(ffprofile);

		WebElement price = null;
		List<WebElement> priceslist;

		String priceString;
		String itemname;

		boolean flag = true;
		int listpos = 0;

		Double trimmedPrice;

		Calendar cal;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		driver.get("https://steamcommunity.com/login/");
		driver.findElement(By.id("steamAccountName")).sendKeys("weezer1988");
		driver.findElement(By.id("steamPassword")).sendKeys("esta");
		driver.findElement(By.id("SteamLogin")).click();

		Thread.sleep(5000);

		while (true) {

			for (Item item : items) {

				if (item.getQuantity() > 0) {

					flag = true;

					while (flag) {

						driver.get(item.getPageURL());

						try {

							priceslist = driver.findElements(By.className("market_listing_price"));

							driver.findElement(By.className("market_listing_price")).click();

							price = priceslist.get(listpos);
							priceString = price.getText();

							if (!"Sold!".equals(priceString)) {

								trimmedPrice = Double.valueOf(priceString.replaceAll("[^0-9.]", ""));
								cal = Calendar.getInstance();
								itemname = driver.findElement(By.xpath("//*[@id='mainContents']/div[1]/div/a[2]")).getText();
								System.out.println((items.indexOf(item)) + 1 + " - " + itemname + " - " + sdf.format(cal.getTime()) + ": " + trimmedPrice);
								listpos = 0;
								flag = false;
								if (trimmedPrice <= item.getBudgetPrice()) {

									driver.findElement(By.className("item_market_action_button")).click();
									driver.findElement(By.id("market_buynow_dialog_accept_ssa")).click();
									driver.findElement(By.xpath("//*[@id='market_buynow_dialog_purchase']/span")).click();
									Thread.sleep(8000);

									if ("overflow: visible;".equals(driver.findElement(By.id("market_buynow_dialog_purchasecomplete_message")).getAttribute("style"))) {
										item.substractItemQuantity();
									} else {
										System.out.println(driver.findElement(By.id("market_buynow_dialog_error_text")).getText());
									}

								}

							} else {

								listpos += 2;

							}

						} catch (NoSuchElementException e) {

							System.out.println("No vino el listado");
							Thread.sleep(2000);

						}

					}

				}

			}

		}

    }
} 