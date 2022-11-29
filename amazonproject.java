package amazon.in;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class amazonproject
{
	public static WebDriver d;
	public static WebDriverWait w;
	public static void main(String[] args) throws InterruptedException
	{
	
		registration();
		login();
		add_to_cart();
		order();
	}
	public static void path()
	{
		System.setProperty("webdriver.chrome.driver", "./Softwaredrivers/chromedriver.exe");
		d=new ChromeDriver();
		w=new WebDriverWait(d, 5);
		d.get("https://www.amazon.in/");
		d.manage().window().maximize();
	}
	public static void registration() throws InterruptedException
	{
		path();
		d.navigate().refresh();
		/*Actions act=new Actions(d);
		WebElement signin = d.findElement(By.xpath("//span[.='Hello, sign in']"));
		act.moveToElement(signin).perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[.='Start here.']")).click();*/
		//by using actions class(mouse hower)
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//span[.='Hello, sign in']")))).click();
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.id("createAccountSubmit")))).click();
		//by using only click action
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//input[@placeholder='First and last name']")))).sendKeys("sapnasantimaplar");
		d.findElement(By.xpath("//input[@id='ap_phone_number']")).sendKeys("8880513755");
		d.findElement(By.name("password")).sendKeys("sap1999@");
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.id("continue")))).click();
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//a[@href='/ref=ap_frn_logo']")))).click();
	}
	public static void login() throws InterruptedException
	{
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//span[.='Hello, sign in']")))).click();
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.id("ap_email")))).sendKeys("8880513755");
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.id("continue")))).click();
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.id("ap_password")))).sendKeys("Sap1999@dvg");
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.id("signInSubmit")))).click();
	}
	public static void add_to_cart() throws InterruptedException
	{
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//input[@id='twotabsearchtextbox']")))).sendKeys("iphone");
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//input[@id='nav-search-submit-button']")))).click();
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//span[.='RESULTS']/ancestor::div[5]/div[3]//h2/a")))).click();
		String main = d.getWindowHandle();
		Set<String> all = d.getWindowHandles();
		ArrayList<String> list=new ArrayList<String>(all);
		String child = list.get(1);
		d.switchTo().window(child);
		JavascriptExecutor srl = (JavascriptExecutor) d;
		WebElement add = w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//input[@value='Add to Cart']"))));
		srl.executeScript("arguments[0].scrollIntoView();", add);
		w.until(ExpectedConditions.visibilityOf(add)).click();
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//a[@href='/ref=nav_logo']")))).click();
	}
	public static void order() throws InterruptedException
	{
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//input[@id='twotabsearchtextbox']")))).sendKeys("iphone");
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//input[@id='nav-search-submit-button']")))).click();
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//span[.='RESULTS']/ancestor::div[5]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a")))).click();
		String main = d.getWindowHandle();
		Set<String> all = d.getWindowHandles();
		ArrayList<String> list=new ArrayList<String>(all);
		String child = list.get(2);
		d.switchTo().window(child);
		Thread.sleep(5000);
		Actions act=new Actions(d);
		//scroll to down
		act.sendKeys(Keys.PAGE_DOWN).perform();
		w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//input[@id='buy-now-button']")))).click();
		d.quit();
		}
}

