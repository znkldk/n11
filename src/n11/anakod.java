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



public class anakod {
	
	public static void sleep(int zaman){ //bekleme metodu
		try {
            // putting thread on sleep
			Thread.sleep(zaman);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void dene(String url, String expected){ // Deneme metodu
		//Bu metoda e�it olmas� gereken 2 deger g�nderilir ve bunlar kar��la�t�r�l�r.
		System.out.println("basarim");
		assertEquals( url, expected);
	}
	
	public static int  anakod() {
		
		//Degi�kenler ve gerekli tan�mlama i�lemleri
		String url;
		String expected;
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		FirstThread ft= new FirstThread();
		Actions action = new Actions(driver);
		  Thread t=new Thread(ft);
		  t.start();
		  long startTime=System.currentTimeMillis();
		
		  
		// Taray�c�y� ba�latma ve n11.com'a girdi�inden emin olma
		driver.get("https://www.n11.com/");
		sleep(2000);
		expected="https://www.n11.com/";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		//Siteye login olma ve bu i�lemin ba�ar�s�ndan emin olma
		WebElement href = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div/div/a[1]"));
		href.click();
		WebElement mail = driver.findElement(By.xpath("//*[@id='email']"));
		mail.sendKeys("znkldk2@gmail.com"); //kullan�c� ad�
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("deneme1");       //�ifre
		WebElement giris = driver.findElement(By.xpath("//*[@id='loginButton']"));
		giris.click();
		sleep(1000);
		expected="https://www.n11.com/";   //��lem ba�ar�l� ise anasayfaya d�nm�� olmas� gerekir.
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		
		//�phone kelimesinin arat�lmas� ve emin olunmas�
		WebElement aramacubugu = driver.findElement(By.xpath("//*[@id='searchData']"));
		aramacubugu.sendKeys("iphone");
		WebElement ara = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[1]/a/span"));
		ara.click();
		sleep(1000);
		expected="https://www.n11.com/arama?q=iphone";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		
		//2. sayfaya gidilmesi ve emin olunmas�
		js.executeScript("window.scrollBy(0,10000)"); //Scroll vertically down by 10000 pixels
		WebElement ileri = driver.findElement(By.xpath("//*[@id='contentListing']/div/div/div[2]/div[4]/a[11]"));
		ileri.click();
		sleep(1000);
		expected="https://www.n11.com/arama?q=iphone&pg=2";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		
		//Favorilere ekleme, favoriler sayfas�n�n a��lmas� ve emin olunmas�
		//Bu k�s�m�n kararl� bir �ekilde �al��mas� i�in baz� i�lemler par�a par�a ve 500ms aral�klarla yap�ld�
		sleep(2000);
		js.executeScript("window.scrollBy(0,500)"); //Scroll vertically down by 1000 pixels
		sleep(500);
		js.executeScript("window.scrollBy(0,500)"); //Scroll vertically down by 1000 pixels
		sleep(500);
		js.executeScript("window.scrollBy(0,500)"); //Scroll vertically down by 1000 pixels
		sleep(500);
		WebElement favoriekle = driver.findElement(By.xpath("//*[@id='p-348957132']/div[2]/span[2]"));
		favoriekle.click();
		sleep(500);
		WebElement hesab�m = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[1]"));
		hesab�m.click();
		WebElement favorilerim = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[5]/a"));
		favorilerim.click();
		sleep(1000);
		expected="https://www.n11.com/hesabim/istek-listelerim";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		
		//�r�n� silme ve emin olma i�lemi emin olmak i�in istek sayfam tekrar a��l�r ve favorilerim texti kontrol edilir
		// Favorilerim (0) texti i�erisinde bir �r�n olmad�g�n� belirtir.
		WebElement favorilerimac = driver.findElement(By.xpath("//*[@id='myAccount']/div[3]/ul/li[1]/div/a/h4"));
		favorilerimac.click();
		WebElement sil = driver.findElement(By.xpath("//*[@id='p-348957132']/div[3]/span"));
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
		
		
		
		//Hesab�m bar� a��l�r ve ��k�� yap�l�r.
		//Bu k�s�mda fare kesinlikle taray�c�n�n �zerinde olmamal�d�r. 
		WebElement hesab�mmauseover1 = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[1]"));
		action.moveToElement(hesab�mmauseover1).perform();
		sleep(500);
		WebElement cikis = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[8]"));
		cikis.click();
		sleep(200);
		
		
		
		// Eger kod buraya kadar gelebilmi�se �al��m�� demektir ve geriye 1 g�nderir.
		return 1;
		
	}
}

