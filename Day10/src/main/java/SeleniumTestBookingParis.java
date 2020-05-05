import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class SeleniumTestBookingParis {

    public static void main(String[] args) throws InterruptedException {

        long time = System.currentTimeMillis();

        String pathToDriver= "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.navigate().to("https://www.booking.com/");

        assertEquals("Title is not as expected","Booking.com | Official site | The best hotels & accommodations", driver.getTitle());

        //WebElement direction = driver.findElement(By.id("ss"));
        WebElement direction = driver.findElement(By.cssSelector("#ss"));
        direction.sendKeys("Paris");

        WebElement checkin = driver.findElement(By.className("xp__dates-inner"));
        checkin.click();

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDays = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date tenDays = calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd") ;
        String threeDaysForward = formatter.format(threeDays);
        String tenDaysForward = formatter.format(tenDays);

        String dateTemplate = "//*[@class='bui-calendar']//*[@data-date='%s']";

        WebElement dayFrom = driver.findElement(By.xpath(String.format(dateTemplate,threeDaysForward)));
        dayFrom.click();
        WebElement dayTo = driver.findElement(By.xpath(String.format(dateTemplate,tenDaysForward)));
        dayTo.click();

        WebElement accommodation = driver.findElement(By.id("xp__guests__toggle"));
        accommodation.click();

        WebElement increaseNumberOfAdults = driver.findElement(By.xpath("//button[@aria-label='Increase number of Adults']"));
        increaseNumberOfAdults.click();
        increaseNumberOfAdults.click();

        WebElement increaseNumberOfRooms = driver.findElement(By.xpath("//button[@aria-label='Increase number of Rooms']"));
        increaseNumberOfRooms.click();

        driver.findElement(By.className("sb-searchbox__button")).click();

        WebElement maxPriceHotelsCheckbox = driver.findElement(By.xpath("//*[@id='filter_price']//a[5]"));
        maxPriceHotelsCheckbox.click();

        int highestPriceRange = Integer.parseInt(maxPriceHotelsCheckbox.getText().replaceAll("[^0-9]+",""));
        System.out.println("Prices for the most expensive hotels in Paris start from " + highestPriceRange + " BYN per night");

        By lowestPriceFilterLocator = By.xpath("//li[contains(@class, 'sort_price')]/a[contains(text(), 'Price') and contains(text(), 'owest')]");
        wait.until(ExpectedConditions.elementToBeClickable(lowestPriceFilterLocator));
        driver.findElement(lowestPriceFilterLocator).click();
        //WebElement sortLowestPrice = driver.findElement(By.partialLinkText("Price (lowest first)"));

        Thread.sleep(4000);

        WebElement cheapestHotel = driver.findElement(By.xpath("//*[@data-hotelid][1]//div[contains(@class,'bui-price-display__value')]"));
        int cheapestHotelperDay =  Integer.parseInt(cheapestHotel.getText().replaceAll("[^0-9]+", ""))/7;
        System.out.println("The cheapest hotel from the list costs " + cheapestHotelperDay + " BYN per night");

        assertTrue("The Price of the Hotel is not in the required Price Range! ", cheapestHotelperDay >= highestPriceRange);
        //assert cheapestHotelperDay >= highestPriceRange : "Something went wrong";


        driver.quit();

        System.out.println((double) (System.currentTimeMillis() - time)/1000);
    }
}
