package n11;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

public class main {
	
	
	public static void sleep(int zaman){
		try {
            // putting thread on sleep
			Thread.sleep(zaman);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void dene(String url, String expected){
		n11test test= new n11test();
		//test.basarim++;
		assertEquals( url, expected);
		
		
	}
	public static void main(String[] args) {
		
		
		String url;
		String expected;
		
		
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		FirstThread ft= new FirstThread();
		Actions action = new Actions(driver);
		  Thread t=new Thread(ft);
		  t.start();
		  long startTime=System.currentTimeMillis();
		
		driver.get("https://www.n11.com/");
		
		sleep(2000);
		expected="https://www.n11.com/";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		WebElement href = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div/div/a[1]"));
		href.click();
		
		WebElement mail = driver.findElement(By.xpath("//*[@id='email']"));
		mail.sendKeys("znkldk2@gmail.com");
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("deneme1");
		WebElement giris = driver.findElement(By.xpath("//*[@id='loginButton']"));
		giris.click();
		
		sleep(1000);
		expected="https://www.n11.com/";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		WebElement aramacubugu = driver.findElement(By.xpath("//*[@id='searchData']"));
		aramacubugu.sendKeys("iphone");
		WebElement ara = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[1]/a/span"));
		ara.click();
		
		sleep(1000);
		expected="https://www.n11.com/arama?q=iphone";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		js.executeScript("window.scrollBy(0,10000)"); //Scroll vertically down by 1000 pixels
		WebElement ileri = driver.findElement(By.xpath("//*[@id='contentListing']/div/div/div[2]/div[4]/a[11]"));
		ileri.click();
		
		sleep(1000);
		expected="https://www.n11.com/arama?q=iphone&pg=2";
		url=driver.getCurrentUrl();
		dene(url,expected);
		sleep(500);
		js.executeScript("window.scrollBy(0,500)"); //Scroll vertically down by 1000 pixels
		sleep(4000);
		WebElement favoriekle = driver.findElement(By.xpath("//*[@id='p-302055788']/div[2]/span"));
		favoriekle.click();
		WebElement hesabým = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[1]"));
		hesabým.click();
		WebElement favorilerim = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[5]/a"));
		favorilerim.click();
		
		sleep(1000);
		expected="https://www.n11.com/hesabim/istek-listelerim";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		
		WebElement favorilerimac = driver.findElement(By.xpath("//*[@id='myAccount']/div[3]/ul/li[1]/div/a/h4"));
		favorilerimac.click();
		
		WebElement sil = driver.findElement(By.xpath("//*[@id='p-302055788']/div[3]/span"));
		sil.click();
		
		  
		sleep(2000);
		WebElement ok = driver.findElement(By.xpath("/html/body/div[5]/div/div/span"));
		ok.click();
		sleep(2000);
		
		WebElement favorilerimac2 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[5]/a"));
		favorilerimac2.click();
		sleep(200);
		WebElement favorilerimac1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[3]/ul/li[1]/div/a/h4"));
		expected="Favorilerim (0)";
		url=favorilerimac1.getText();
		dene(url,expected);
		
		WebElement hesabýmmauseover1 = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[1]"));
		action.moveToElement(hesabýmmauseover1).perform();
		sleep(500);
	
		
		WebElement cikis = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[8]"));
		System.out.println("burdayýmmmm");
		cikis.click();
		
	}
}
