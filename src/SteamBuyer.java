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

public class SteamBuyer {
	
	@Test
	public void steamBuyerTest() throws Exception{
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		WebDriver driver = new FirefoxDriver(ffprofile);
		
		
		WebElement price = null;
		List<WebElement> priceslist;
		String priceString;
		String itemname01;
		String itemname02;
		String itemname03;
		String itemname04;
		String itemname05;
		int qtyflag01 = 0;
		int qtyflag02 = 0;
		int qtyflag03 = 6;
		int qtyflag04 = 0;
		int qtyflag05 = 0;
		int flag;
		int listpos = 0;
		Double trimmedPrice01;
		Double trimmedPrice02;
		Double trimmedPrice03;
		Double trimmedPrice04;
		Double trimmedPrice05;
		Double budgetPrice01 = 3.25;
		Double budgetPrice02 = 2.85;
		Double budgetPrice03 = 1.00;
		Double budgetPrice04 = 2.40;
		Double budgetPrice05 = 1.35;
		
		Calendar cal;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		driver.get("https://steamcommunity.com/login/");
		driver.findElement(By.id("steamAccountName")).sendKeys("mendion82");
		driver.findElement(By.id("steamPassword")).sendKeys("paranoia290");
		driver.findElement(By.id("SteamLogin")).click();
		
		Thread.sleep(5000);
		
		/*ofertarButton = driver.findElement(By.id("bid_button_index_" + idSubasta));
		countdown = driver.findElement(By.id("counter_index_page_" + idSubasta));
		winner = driver.findElement(By.id("winner_index_page_" + idSubasta));
		*/ 
		

			
		while(true){
			
		
		
			if(qtyflag01 != 0){
				
				flag = 1;
			
				while(flag == 1){
				
					driver.get("https://steamcommunity.com/market/listings/730/M4A1-S%20%7C%20Dark%20Water%20%28Minimal%20Wear%29");
				
					priceslist = driver.findElements(By.className("market_listing_price"));
				
					driver.findElement(By.className("market_listing_price")).click();
				
				
					price = priceslist.get(listpos);
					priceString = price.getText();
				
				
				
					if(!priceString.equals("Sold!")){
					
						trimmedPrice01 = Double.valueOf(priceString.replaceAll( "[^0-9.]", "" ));
						cal = Calendar.getInstance();
						itemname01 = driver.findElement(By.xpath("//*[@id='mainContents']/div[1]/div/a[2]")).getText();
						System.out.println( "01 - " + itemname01 + " - " + sdf.format(cal.getTime()) + ": " + trimmedPrice01);
						listpos = 0;
						flag = 0;
						if(trimmedPrice01 <= budgetPrice01){
						
							driver.findElement(By.className("item_market_action_button")).click();
							driver.findElement(By.id("market_buynow_dialog_accept_ssa")).click();
							driver.findElement(By.xpath("//*[@id='market_buynow_dialog_purchase']/span")).click();
							qtyflag01 --;
							Thread.sleep(8000);
							}
						
						}else{
						
							listpos += 2;
						
						}
				
					}
				
				}
			
			
			if(qtyflag02 != 0){
				
				flag = 1;
				
				while(flag == 1){
				
					driver.get("https://steamcommunity.com/market/listings/730/StatTrak%E2%84%A2%20USP-S%20%7C%20Guardian%20%28Field-Tested%29");
					
					priceslist = driver.findElements(By.className("market_listing_price"));
					
					driver.findElement(By.className("market_listing_price")).click();
					
					
					price = priceslist.get(listpos);
					priceString = price.getText();
					
					
				
					if(!priceString.equals("Sold!")){
					
						trimmedPrice02 = Double.valueOf(priceString.replaceAll( "[^0-9.]", "" ));
						cal = Calendar.getInstance();
						itemname02 = driver.findElement(By.xpath("//*[@id='mainContents']/div[1]/div/a[2]")).getText();
						System.out.println( "02 - " + itemname02 + " - " + sdf.format(cal.getTime()) + ": " + trimmedPrice02);
						listpos = 0;
						flag = 0;
						if(trimmedPrice02 <= budgetPrice02){
						
							driver.findElement(By.className("item_market_action_button")).click();
							driver.findElement(By.id("market_buynow_dialog_accept_ssa")).click();
							driver.findElement(By.xpath("//*[@id='market_buynow_dialog_purchase']/span")).click();
							qtyflag02 --;
							Thread.sleep(8000);
							}
						
						}else{
						
							listpos += 2;
						
						}
						
					}
				
				}
		
			
			if(qtyflag03 != 0){
				
				flag = 1;
				
				while(flag == 1){
				
					driver.get("https://steamcommunity.com/market/listings/730/StatTrak%E2%84%A2%20Tec-9%20%7C%20Isaac%20%28Field-Tested%29");
					
					priceslist = driver.findElements(By.className("market_listing_price"));
					
					driver.findElement(By.className("market_listing_price")).click();
					
					
					price = priceslist.get(listpos);
					priceString = price.getText();
					
					
				
					if(!priceString.equals("Sold!")){
					
						trimmedPrice03 = Double.valueOf(priceString.replaceAll( "[^0-9.]", "" ));
						cal = Calendar.getInstance();
						itemname03 = driver.findElement(By.xpath("//*[@id='mainContents']/div[1]/div/a[2]")).getText();
						System.out.println( "03 - " + itemname03 + " - " + sdf.format(cal.getTime()) + ": " + trimmedPrice03);
						listpos = 0;
						flag = 0;
						if(trimmedPrice03 <= budgetPrice03){
						
							driver.findElement(By.className("item_market_action_button")).click();
							driver.findElement(By.id("market_buynow_dialog_accept_ssa")).click();
							driver.findElement(By.xpath("//*[@id='market_buynow_dialog_purchase']/span")).click();
							qtyflag03 --;
							Thread.sleep(8000);
							}
						
						}else{
						
							listpos += 2;
						
						}
						
					}
				
				}
			
			
			if(qtyflag04 != 0){
				
				flag = 1;
				
				while(flag == 1){
				
					driver.get("https://steamcommunity.com/market/listings/730/StatTrak%E2%84%A2%20P250%20%7C%20Supernova%20%28Minimal%20Wear%29");
					
					priceslist = driver.findElements(By.className("market_listing_price"));
					
					driver.findElement(By.className("market_listing_price")).click();
					
					
					price = priceslist.get(listpos);
					priceString = price.getText();
					
					
				
					if(!priceString.equals("Sold!")){
					
						trimmedPrice04 = Double.valueOf(priceString.replaceAll( "[^0-9.]", "" ));
						cal = Calendar.getInstance();
						itemname04 = driver.findElement(By.xpath("//*[@id='mainContents']/div[1]/div/a[2]")).getText();
						System.out.println( "04 - " + itemname04 + " - " + sdf.format(cal.getTime()) + ": " + trimmedPrice04);
						listpos = 0;
						flag = 0;
						if(trimmedPrice04 <= budgetPrice04){
						
							driver.findElement(By.className("item_market_action_button")).click();
							driver.findElement(By.id("market_buynow_dialog_accept_ssa")).click();
							driver.findElement(By.xpath("//*[@id='market_buynow_dialog_purchase']/span")).click();
							qtyflag04 --;
							Thread.sleep(8000);
							}
						
						}else{
						
							listpos += 2;
						
						}
						
					}
				
				}
			
			
			if(qtyflag05 != 0){
				
				flag = 1;
				
				while(flag == 1){
				
					driver.get("https://steamcommunity.com/market/listings/730/StatTrak%E2%84%A2%20Five-SeveN%20%7C%20Urban%20Hazard%20%28Field-Tested%29");
					
					priceslist = driver.findElements(By.className("market_listing_price"));
					
					driver.findElement(By.className("market_listing_price")).click();
					
					
					price = priceslist.get(listpos);
					priceString = price.getText();
					
					
				
					if(!priceString.equals("Sold!")){
					
						trimmedPrice05 = Double.valueOf(priceString.replaceAll( "[^0-9.]", "" ));
						cal = Calendar.getInstance();
						itemname05 = driver.findElement(By.xpath("//*[@id='mainContents']/div[1]/div/a[2]")).getText();
						System.out.println( "05 - " + itemname05 + " - " + sdf.format(cal.getTime()) + ": " + trimmedPrice05);
						listpos = 0;
						flag = 0;
						if(trimmedPrice05 <= budgetPrice05){
						
							driver.findElement(By.className("item_market_action_button")).click();
							driver.findElement(By.id("market_buynow_dialog_accept_ssa")).click();
							driver.findElement(By.xpath("//*[@id='market_buynow_dialog_purchase']/span")).click();
							qtyflag05 --;
							Thread.sleep(8000);
							}
						
						}else{
						
							listpos += 2;
						
						}
						
					}
				
				}
			
			
			}
		
		/*
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
        WebDriverWait wait = new WebDriverWait(driver, 300);
        
        countdown.click();
        
        while(true){
        
        	try{
        		
        		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("counter_index_page_" + idSubasta), "00:00:01"));
        		
        		winnerString = winner.getText();
        		
        		if(!winnerString.equals("Mendion")){

        			Thread.sleep(300);
        			ofertarButton.click();
        			Thread.sleep(1000);
        			winnerString = winner.getText();
        			System.out.println(winnerString);
        			if(winnerString.equals("Mendion")){
	        			Calendar cal = Calendar.getInstance();
	        			System.out.println( sdf.format(cal.getTime()) + ": Oferta " + i + ": " + price.getText());
	        			i++;
	        			Thread.sleep(1000);
        			}else{
        				System.out.println("Oferta No Aceptada");
        			}
			
        		}else{
        			Calendar cal = Calendar.getInstance();
        			System.out.println( sdf.format(cal.getTime()) + ": Voy ganando! Espero 5 segundos.");
        			Thread.sleep(5000);
        		}

        	
        	}catch(TimeoutException e){
        
        	countdown.click();
        	Calendar cal = Calendar.getInstance();
        	System.out.println( sdf.format(cal.getTime()) + ": Hago Click para que no de Timeout");
			
        	}
        
        }
       */ 	
	}
}

