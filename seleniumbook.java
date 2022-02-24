package mindtree.newproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumbook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mindtreedec243\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.indiabookstore.net");
		driver.findElement(By.id("searchBox")).click();
		driver.findElement(By.id("searchBox")).sendKeys("Selenium");
		driver.findElement(By.id("searchBox")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//img[@title='Selenium testing tools Cookbook | By: Roy De Kleijn']")).click();
		Thread.sleep(2000);
		
		String isbn=driver.findElement(By.xpath("//div[@class='isbnContainer']")).getText();
		
		System.out.println("isbn  in indiabookstore: "+isbn);
		//driver.findElement(By.xpath("//*[co'https://www.indiabookstore.net/redirect?url=https%3A%2F%2Fwww.amazon.in%2Fdp%2F1849515743%3Ftag%3Dindi08-21%26linkCode%3Dosi%26th%3D1%26psc%3D1&source=buyLinkModal&name=Amazon&ibsId=9781849515740&urlDisplay")).click();
		//driver.findElement(By.linkText("https://www.indiabookstore.net/redirect?url=https%3A%2F%2Fwww.amazon.in%2Fdp%2F1849515743%3Ftag%3Dindi08-21%26linkCode%3Dosi%26th%3D1%26psc%3D1&source=buyLinkModal&name=Amazon&ibsId=9781849515740&urlDisplay=https%3A%2F%2Fwww.amazon.in%2Fdp%2F1849515743%3Ftag%3Dindi08-21%26linkCode%3Dosi%26th%3D1%26psc%3D1&sellingPrice=2519&storeId=17&isbn13=9781849515740&rank=1&minPrice=1019&storesCount=3&searchId=")).click();
		driver.findElement(By.xpath(("//*[@id='bookInfoWindow']/div/div/div[2]/div[2]/div[2]/div[3]/a"))).click();
		String winHandleBefore1 = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		
		String price=driver.findElement(By.id("price")).getText();
		System.out.println("Price is "+price);
		String stock=driver.findElement(By.id("availability")).getText();
		
		if(stock.contains("left")) {
			System.out.println("Stock available ");
		}
		System.out.println(stock);
		String isbn2=driver.findElement(By.xpath("//*[@id=\"detailBullets_feature_div\"]/ul/li[5]/span/span[2]")).getText();
		System.out.println("ISBN in amazon website is  "+isbn2);
		int check=0;
		for(int i=0,j=0;i<isbn2.length();)
		{
			if(isbn2.charAt(i)=='-')
			{
				i++;
			}
			else
			{
				if(isbn2.charAt(i)!=isbn.charAt(j))
				{
					check=1;
					break;
				}
				else
				{
					i++;
					j++;
				}
			}
			
		}
		if(check==0)
			System.out.println("Isbn matched");
		else
			System.out.println("Isbn not matched");
			
	}

}
