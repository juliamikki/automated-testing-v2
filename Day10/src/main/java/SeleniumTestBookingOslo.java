import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SeleniumTestBookingOslo {

    private static final Color RED = Color.fromString("red");

    public static void main(String[] args) throws InterruptedException {

        long time = System.currentTimeMillis();

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        WebDriver driver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");

        WebElement direction = driver.findElement(By.cssSelector("#ss"));
        direction.sendKeys("Moscow");

        WebElement checkin = driver.findElement(By.cssSelector(".xp__dates-inner"));
        checkin.click();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,1);
        Date oneDayForward = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date twoDaysForward = calendar.getTime();

        SimpleDateFormat SDFormat = new SimpleDateFormat("yyyy-MM-dd");
        String checkInDate = SDFormat.format(oneDayForward);
        String checkOutDate = SDFormat.format(twoDaysForward);

        String dateTemplate = ".bui-calendar [data-date='%s']";

        driver.findElement(By.cssSelector(String.format(dateTemplate,checkInDate))).click();
        driver.findElement(By.cssSelector(String.format(dateTemplate,checkOutDate))).click();

        WebElement accommodation = driver.findElement(By.cssSelector("#xp__guests__toggle"));
        accommodation.click();

        WebElement increaseNumberOfAdults = driver.findElement(By.cssSelector("button[aria-label='Increase number of Adults']"));
        actions.doubleClick(increaseNumberOfAdults).perform();

        WebElement increaseNumberOfChildren = driver.findElement(By.cssSelector("button[aria-label='Increase number of Children']"));
        actions.click(increaseNumberOfChildren).perform();

        driver.findElement(By.cssSelector(".sb-searchbox__button")).click();

        WebElement threeStars = driver.findElement(By.cssSelector("#filter_class a[data-id='class-3']"));
        actions.click(threeStars).perform();
        WebElement fourStars = driver.findElement(By.cssSelector("#filter_class a[data-id='class-4']"));
        actions.click(fourStars).perform();

        Thread.sleep(3000);
        //all the following doesn't work properly:
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#hotellist_inner")));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-hotelid][10]")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-hotelid][10]")));
        //wait.until(webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete"));

        WebElement tenthHotelFromAbove = driver.findElement(By.xpath("//*[@data-hotelid][10]"));
        js.executeScript("arguments[0].scrollIntoView();", tenthHotelFromAbove);
        actions.moveToElement(driver.findElement(By.xpath("//*[@data-hotelid][10]//a[@class='bui-link']"))).build().perform();

        js.executeScript("arguments[0].setAttribute('style','background-color : palegreen')",tenthHotelFromAbove );

        WebElement tenthHotelTitle = driver.findElement(By.xpath("//*[@data-hotelid][10]//span[contains(@class,'sr-hotel__name')]"));
        js.executeScript("arguments[0].setAttribute('style', 'color : red')", tenthHotelTitle);

        Color tenthHotelTitleColor = Color.fromString(tenthHotelTitle.getCssValue("color"));

        assertEquals("The color of the tenth hotel title is not as expected! ", RED, tenthHotelTitleColor );

        //Why doesn't work?
        //assert tenthHotelTitleColor.equals(RED) : "The color of the tenth hotel title is not as expected";

        driver.quit();

        System.out.println((double) (System.currentTimeMillis() - time)/1000);

    }
}
