package merinnewproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.primitives.Ints;

public class Assignmentmaven {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://janasya.com/");
	}
	@Test
	public void test() {
		driver.findElement(By.xpath("//*[@id=\"HeaderNavigation\"]/nav/ul/li[1]/a/span")).click();
		boolean logo=driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16316676800682__9c03747e-b054-4db8-8194-5a35c71f82ca\"]/sticky-header/div/div/div[1]/div/a/img")).isDisplayed();
		System.out.println(logo);
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"CollectionProductGrid\"]/div/toolbar-item/div[2]/div[3]/div[1]/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"CollectionProductGrid\"]/div/toolbar-item/div[2]/div[3]/div[1]/div/ul/li[2]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"halo-sidebar\"]/div[2]/div[1]/div[1]/h3")).click();
		driver.findElement(By.xpath("//*[@id=\"halo-sidebar\"]/div[2]/div[1]/div[2]/div/ul/li[1]/a/span")).click();
		List<WebElement>li=driver.findElements(By.tagName("a"));
		System.out.println("no of links:"+li.size());
		for(int i=0;i<=li.size();i++) {
			System.out.println(li.get(i).getText());
		}
	}
}
