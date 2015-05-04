import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class SteamBuyerv2 {
	
	@Test
	public void steamBuyerTest() throws Exception{
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		WebDriver driver = new FirefoxDriver(ffprofile);
		
		
		WebElement price = null;
		List<WebElement> priceslist;
		
		
		String priceString;
		String itemname;
		
		String[] pageURL = {"https://steamcommunity.com/market/listings/730/M4A1-S%20%7C%20Dark%20Water%20%28Minimal%20Wear%29",
							"https://steamcommunity.com/market/listings/730/StatTrak%E2%84%A2%20USP-S%20%7C%20Guardian%20%28Field-Tested%29",
							"https://steamcommunity.com/market/listings/730/StatTrak%E2%84%A2%20Tec-9%20%7C%20Isaac%20%28Field-Tested%29",
							"https://steamcommunity.com/market/listings/730/StatTrak%E2%84%A2%20P250%20%7C%20Supernova%20%28Minimal%20Wear%29",
							"https://steamcommunity.com/market/listings/730/StatTrak%E2%84%A2%20Five-SeveN%20%7C%20Urban%20Hazard%20%28Field-Tested%29",	
							};
		
		
		int qty[] = new int[] {0,0,4,0,0};
		Double budgetPrice[] = new Double[] {3.25,2.85,1.00,2.40,1.35};
		
		
		int flag;
		int listpos = 0;
		int i;
		
		Double trimmedPrice;
		
		Calendar cal;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		driver.get("https://steamcommunity.com/login/");
		driver.findElement(By.id("steamAccountName")).sendKeys("mendion82");
		driver.findElement(By.id("steamPassword")).sendKeys("paranoia290");
		driver.findElement(By.id("SteamLogin")).click();
		
		Thread.sleep(5000);

		while(true){
			
			for(i=0 ; i<budgetPrice.length ; i++){
						
			
				if(qty[i] != 0){
					
					flag = 1;
				
					while(flag == 1){
					
						driver.get(pageURL[i]);
					
						priceslist = driver.findElements(By.className("market_listing_price"));
					
						driver.findElement(By.className("market_listing_price")).click();				
					
						price = priceslist.get(listpos);
						priceString = price.getText();
									
					
						if(!priceString.equals("Sold!")){
						
							trimmedPrice = Double.valueOf(priceString.replaceAll( "[^0-9.]", "" ));
							cal = Calendar.getInstance();
							itemname = driver.findElement(By.xpath("//*[@id='mainContents']/div[1]/div/a[2]")).getText();
							System.out.println( "0" + (i+1) + " - " + itemname + " - " + sdf.format(cal.getTime()) + ": " + trimmedPrice);
							listpos = 0;
							flag = 0;
							if(trimmedPrice <= budgetPrice[i]){
							
								driver.findElement(By.className("item_market_action_button")).click();
								driver.findElement(By.id("market_buynow_dialog_accept_ssa")).click();
								driver.findElement(By.xpath("//*[@id='market_buynow_dialog_purchase']/span")).click();
								qty[i] --;
								Thread.sleep(8000);
								}
							
							}else{
							
								listpos += 2;
							
						}
					
					}
					
				}						
				
			}
			
		}
		
	}
	
}

