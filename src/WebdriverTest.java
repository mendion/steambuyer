import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverTest {
	
	@Test
	public void subastasLocasTest() throws Exception{
		
		WebDriver driver = new FirefoxDriver();

		WebElement ofertarButton = null;
		WebElement countdown = null;
		WebElement winner = null;
		WebElement price = null;
		int i = 1;
		String winnerString;
		String idSubasta = "32365";
		
		driver.get("http://www.subastaslocas.com");
		driver.findElement(By.id("dnn_CreditBalance1_LoginSmall1_txtUserName")).sendKeys("Mendion");
		driver.findElement(By.id("dnn_CreditBalance1_LoginSmall1_txtPassword")).sendKeys("paranoia290");
		driver.findElement(By.id("dnn_CreditBalance1_LoginSmall1_cmdLogin")).click();
		
		Thread.sleep(10000);
		
		driver.get("http://www.subastaslocas.com/Auctions/View.aspx?AuctionID=" + idSubasta);
		
		ofertarButton = driver.findElement(By.id("bid_button_index_" + idSubasta));
		countdown = driver.findElement(By.id("counter_index_page_" + idSubasta));
		winner = driver.findElement(By.id("winner_index_page_" + idSubasta));
		price = driver.findElement(By.id("price_index_page_" + idSubasta));
		
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
        	
	}
}

