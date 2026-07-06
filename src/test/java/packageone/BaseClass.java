package packageone;

import java.beans.Visibility;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass extends ExcelUtils {

	WebDriver driver;
	Alert alert;
	Select select;
	JavascriptExecutor executor;
	TakesScreenshot screenshot;
	Actions actions;
	
	public void BrowserLaunchChrome() {driver = new ChromeDriver();}
	
	public void BrowserLaunchEdge() {driver = new EdgeDriver();	}
	
	public void BrowserLaunchFireFox() {driver = new FirefoxDriver();}	

	
	public void BrowserLaunch(String browser)
	{if(browser.equals("Edge"))
	{driver=new EdgeDriver();}
	else if(browser.equals("Chrome"))
	{driver=new ChromeDriver();}
	else if(browser.equals("Firefox"))
	{driver=new FirefoxDriver();}
	else {System.out.println("Invalid Browser");}}
	
	public void urlLaunch(String url) 
	{driver.get(url);}
	
	public void browserMaximize() {driver.manage().window().maximize();}
	
	public boolean isElementDisplayed(WebElement element) {
		//WebElement element = driver.findElement(By.tagName(null));
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	
	public boolean isElementenabled(WebElement element) {
		//WebElement element = driver.findElement(By.tagName(null));
		boolean enabled = element.isEnabled();
		return enabled;
	}
	
	public boolean isElementselected(WebElement element) {
		//WebElement element = driver.findElement(By.tagName(null));
		boolean selected = element.isSelected();
		return selected;
	}
	
	public void clearTxtBoxElement(WebElement element) {
		//WebElement element = driver.findElement(By.tagName(null));
		element.clear();
	}
	
	public void switchToAlert() {driver.switchTo().alert();}
	
	
	public void sendkeysElement(WebElement element, String data) {
		//WebElement element = driver.findElement(By.tagName(null));
		if(isElementDisplayed(element) && isElementenabled(element)) //if(	element.isDisplayed() && element.isEnabled());
		clearTxtBoxElement(element);		//element.clear();
		element.sendKeys(data);
	}
	
	public void sendkeysElementandKeysAction(WebElement element, String data, Keys keyAction) {
		if(isElementDisplayed(element) && isElementenabled(element)) 
			clearTxtBoxElement(element);		
		element.sendKeys(data,keyAction);
	}
	
	public void clickElement(WebElement element) {
		//WebElement element = driver.findElement(By.tagName(null));
		if(isElementDisplayed(element) && isElementenabled(element)) //if(	element.isDisplayed() && element.isEnabled());
		element.click();
	}
	
	public void acceptAlert() {
		// TODO Auto-generated method stub
		switchToAlert();
		alert.accept();

	}
	
	public void dismissAlert() {
		switchToAlert();
		alert.dismiss();
	}
	
public String getTextForAlert() {
switchToAlert();
		String text = alert.getText();
		return text;
	}
	
	public void SendKeysforAlert(String Data) {
		switchToAlert();
		alert.sendKeys(Data);
	}
	
	public String getTextElement(WebElement element) {
		//WebElement element = driver.findElement(By.tagName(null));
		String text = null;
		if(isElementDisplayed(element))
		{
		text = element.getText();
		}
		return text;	
	}
	
	public String getTextboxValueE(WebElement element, String data) {
		//WebElement element = driver.findElement(By.tagName(null));
		@Nullable
		String attribute = element.getAttribute(data);
		return attribute;

	}
	
	public void BrowserClose() {driver.close();}
	
	public void BrowserQuit() {driver.quit();}
	
	public String GetTitle() {
		String title = driver.getTitle();
		return title;

	}
	
	public String CurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public void SelectDropDwnByVisibleTxt(WebElement element,String text) {
		//WebElement element = driver.findElement(By.tagName(null));
		select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectDpdwnbyValue(WebElement element,String value) {
		//WebElement element = driver.findElement(By.tagName(null));
		select = new Select(element);
		select.selectByValue(value);
	}
	
	public void SelectDrpdwnbyIndex(WebElement element,int index) {
		//WebElement element = driver.findElement(By.tagName(null));
				select = new Select(element);
				select.selectByIndex(index);
	}
	
	public void switchtoframebyIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public WebDriver switchToFrameElement(WebElement FrameElement) {
		//WebElement FrameElement = driver.findElement(By.tagName(null));
		WebDriver frame = driver.switchTo().frame(FrameElement);
		return frame;
		
	}

	public void switchToFramebyNameorID(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public WebElement findLocatorByID(String id) {
		WebElement element = driver.findElement(By.id(id));
		ExplicitWait(element);
		return element;

	}
	
	public WebElement findLocatorbyName(String text) {
		WebElement element = driver.findElement(By.name(text) );
		ExplicitWait(element);
		return element;
	}
	
	public WebElement findLocatorbyClassName(String text) {
		WebElement element = driver.findElement(By.className(text));
		ExplicitWait(element);
		return element;
	}
	
	public WebElement findLocatorbyXpath(String text) {
		//ExplicitWait(element);
		WebElement element = driver.findElement(By.xpath(text));
		ExplicitWait(element);
		return element;
	}
	
	public void sendKeysElementJs(WebElement element, String data) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}
	
	public void clickButtonsJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0.click();",element);
	}
	
	public  List<String> getAllOptionsFromDropDwn(WebElement element) {
		List<String> allOptionsTextList = new ArrayList<String>();
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement webElement : options)
		{
			String text = webElement.getText();
			allOptionsTextList.add(text);
		}
		return allOptionsTextList;
 
	}
	
	public List<String> getAllOptions(WebElement element) {
		List<String> allOptionsText = new ArrayList<String>();
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptionsText.add(text);

		}
		return allOptionsText;
	}
	
	public List<String> getAllOptionsusingValue(WebElement element) {
		List<String> allList = new ArrayList<String>();
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement option:options)
		{
			System.out.println(option.getText());
		}
		return allList;
	}

	public String getFirstOptioninDrpDwn(WebElement element) {
		select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
		

	}
	
	public WebElement getFirstOptioninDrpDwn1(WebElement element) {
		select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return firstSelectedOption;
		

	}
	
	public boolean multiSelectusingDrpdwn(WebElement element) {
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;

	}
	
	public void Implicitwait() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void ImplicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public void ExplicitWait(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void ExplicitWait(WebElement element,int secs) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(secs));
		driverWait.until(ExpectedConditions.visibilityOf(element));

	}
	
public void deselectall(WebElement element) {
	select = new Select(element);
	select.deselectAll();
}	
	
public void TakeScreenshots(String filepath) throws IOException {
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File Source = screenshot.getScreenshotAs(OutputType.FILE);
	File Dest = new File(filepath);
	FileUtils.copyFile(Source, Dest);

}
	
public void TakeScreenshotsElement(String filepath,WebElement element) throws IOException {
	File Source = element.getScreenshotAs(OutputType.FILE);
	File Dest = new File(filepath);
	FileUtils.copyFile(Source, Dest);

}

public void MouseOverActions(WebElement element) {
	actions = new Actions(driver);
	actions.moveToElement(element).perform();
}
	
public void MouseDragAndDrop(WebElement Src,WebElement dest) {
	actions = new Actions(driver);
	actions.dragAndDrop(Src, dest).perform();
}
		
public void MouseRightClick(WebElement element) {
	actions = new Actions(driver);
	actions.doubleClick(element).perform();
}

public void ScrollDown(WebElement element) {
	
	executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].scrollIntoView(true)", element);
}


public void ScrollUp(WebElement element) {
	// TODO Auto-generated method stub
	executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].ScrollIntoView(false)", element);

}

public String TrimData(String Data,String OriginalData,String TrimData) {
	// TODO Auto-generated method stub
	
	String TrimmedData = Data.replace(OriginalData, TrimData).trim();
	System.out.println(TrimmedData);
	return TrimmedData;

}

public void NavigateURL(String url) {driver.navigate().to(url);}

public void NavigateBack() {driver.navigate().back();}

public void NavigateFwd() {driver.navigate().forward();}
	
public void Refresh() {driver.navigate().refresh();}

public void Fluentwaits(int timeout,int polling, String text) {
			FluentWait<WebDriver> wait = new FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(timeout))
	        .pollingEvery(Duration.ofSeconds(polling))
	        .ignoring(NoSuchElementException.class);
			
			//WebElement s =wait.until(findLocatorbyXpath(text)null);
					// --(driver.findElement(By.xpath(text)));
			}

public void ThreadSleep(int sec) throws InterruptedException{Thread.sleep(sec);}
}