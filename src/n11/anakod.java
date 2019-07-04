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
		//Bu metoda eþit olmasý gereken 2 deger gönderilir ve bunlar karþýlaþtýrýlýr.
		System.out.println("basarim");
		assertEquals( url, expected);
	}
	
	public static int  anakod() {
		
		//Degiþkenler ve gerekli tanýmlama iþlemleri
		String url;
		String expected;
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		FirstThread ft= new FirstThread();
		Actions action = new Actions(driver);
		  Thread t=new Thread(ft);
		  t.start();
		  long startTime=System.currentTimeMillis();
		
		  
		// Tarayýcýyý baþlatma ve n11.com'a girdiðinden emin olma
		driver.get("https://www.n11.com/");
		sleep(2000);
		expected="https://www.n11.com/";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		//Siteye login olma ve bu iþlemin baþarýsýndan emin olma
		WebElement href = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div/div/a[1]"));
		href.click();
		WebElement mail = driver.findElement(By.xpath("//*[@id='email']"));
		mail.sendKeys("znkldk2@gmail.com"); //kullanýcý adý
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("deneme1");       //þifre
		WebElement giris = driver.findElement(By.xpath("//*[@id='loginButton']"));
		giris.click();
		sleep(1000);
		expected="https://www.n11.com/";   //Ýþlem baþarýlý ise anasayfaya dönmüþ olmasý gerekir.
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		
		//Ýphone kelimesinin aratýlmasý ve emin olunmasý
		WebElement aramacubugu = driver.findElement(By.xpath("//*[@id='searchData']"));
		aramacubugu.sendKeys("iphone");
		WebElement ara = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[1]/a/span"));
		ara.click();
		sleep(1000);
		expected="https://www.n11.com/arama?q=iphone";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		
		//2. sayfaya gidilmesi ve emin olunmasý
		js.executeScript("window.scrollBy(0,10000)"); //Scroll vertically down by 10000 pixels
		WebElement ileri = driver.findElement(By.xpath("//*[@id='contentListing']/div/div/div[2]/div[4]/a[11]"));
		ileri.click();
		sleep(1000);
		expected="https://www.n11.com/arama?q=iphone&pg=2";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		
		//Favorilere ekleme, favoriler sayfasýnýn açýlmasý ve emin olunmasý
		//Bu kýsýmýn kararlý bir þekilde çalýþmasý için bazý iþlemler parça parça ve 500ms aralýklarla yapýldý
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
		WebElement hesabým = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[1]"));
		hesabým.click();
		WebElement favorilerim = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[5]/a"));
		favorilerim.click();
		sleep(1000);
		expected="https://www.n11.com/hesabim/istek-listelerim";
		url=driver.getCurrentUrl();
		dene(url,expected);
		
		
		
		//Ürünü silme ve emin olma iþlemi emin olmak için istek sayfam tekrar açýlýr ve favorilerim texti kontrol edilir
		// Favorilerim (0) texti içerisinde bir ürün olmadýgýný belirtir.
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
		
		
		
		//Hesabým barý açýlýr ve çýkýþ yapýlýr.
		//Bu kýsýmda fare kesinlikle tarayýcýnýn üzerinde olmamalýdýr. 
		WebElement hesabýmmauseover1 = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[1]"));
		action.moveToElement(hesabýmmauseover1).perform();
		sleep(500);
		WebElement cikis = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[8]"));
		cikis.click();
		sleep(200);
		
		
		
		// Eger kod buraya kadar gelebilmiþse çalýþmýþ demektir ve geriye 1 gönderir.
		return 1;
		
	}
}

