package merinnewproject;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Project {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.kayak.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	@Test
	public void flowtest() {
		driver.findElement(By.cssSelector(".ZGw- > svg")).click();
	    driver.findElement(By.cssSelector(".pRB0-nav-items:nth-child(3) li:nth-child(1) .dJtn-menu-item-title")).click();
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0,800)");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  //  driver.findElement(By.xpath("//*[@value=\"nonstop\"]")).click();
	  
	   

	}
@Test
	public void test() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("Scrolling down to the bottom");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/footer/div[2]/div/div/div[2]/div/span[3]/a/span")).click();
		driver.navigate().back();
		driver.findElement(By.cssSelector(".ZGw- > svg")).click();
		driver.findElement(By.cssSelector(".ZGw- > svg > path")).click();
		//driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).click();
}
@Test
public void testflow() {
	driver.findElement(By.cssSelector(".ZGw- > svg")).click();
	driver.findElement(By.cssSelector(".ZGw- > svg > path")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.xpath("//*[@id=\"main-search-form\"]/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[1]/div/div")).click();
    	driver.findElement(By.xpath("//li[@id=\"oneway\"]")).click();
   
    	//date picker
    /*	driver.findElement(By.xpath("//*[@id=\"main-search-form\"]/div/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/div[4]/div/div/div[1]/svg")).click();
    WebElement month=driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div/div/div/div[3]/div/div/div/div/div[2]/table/caption"));
    String monthname=month.getText();
    if(monthname.equals("June 2024")) {
    	System.out.println("month");
    }*/

    }
  	@Test
	public void verification() throws IOException {
		String title=driver.getTitle();
		System.out.println(title);
		String exp="Search Flights, Hotels & Rental Cars | KAYAK";
		if(exp.equals(title)) {
			System.out.println("pass");
		}else {
			System.out.println("title not matching");
		}
	String source=driver.getPageSource();
	//System.out.println(source);
	if(source.contains("kayak")) {
		System.out.println("pass source test");
	}
	//Response code testing
	URL ob=new URL("https://www.kayak.co.in/");
	HttpURLConnection con=(HttpURLConnection)ob.openConnection();
	con.connect();
	if(con.getResponseCode()==200) {
		System.out.println("valid url");
		
	}
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src,new File("D://error7.png"));
	}
	
	@Test
	public void test1() {
		//logo test
	boolean logo=driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[1]/div[2]/div[1]/div[2]")).isDisplayed();
	Assert.assertTrue(logo);
	System.out.println("logo is displayed");
	
	
	//clicking dashboard menu  and an option
	driver.findElement(By.cssSelector(".ZGw- > svg")).click();
	driver.findElement(By.cssSelector(".ZGw- > svg > path")).click();
	//no of links and link attribute
    List<WebElement> li= driver.findElements(By.tagName("a"));
    int n=li.size();
    System.out.println("no of links----"+n);
    for(WebElement e:li) {
    	String links=e.getAttribute("href");
    	String text=e.getText();
    	System.out.println(links+"---------"+text);
    }
	 }
}



