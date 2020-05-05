import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class SeleniumTestBookingMoscow {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");

        WebElement direction = driver.findElement(By.cssSelector("#ss"));
        direction.sendKeys("Moscow");

        WebElement checkin = driver.findElement(By.cssSelector(".xp__dates-inner"));
        checkin.click();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date tenDaysForward = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date fifteenDaysForward = calendar.getTime();

        SimpleDateFormat SDFormat = new SimpleDateFormat("yyyy-MM-dd");
        String checkInDate = SDFormat.format(tenDaysForward);
        String checkOutDate = SDFormat.format(fifteenDaysForward);

        String dateTemplate = ".bui-calendar [data-date='%s']";

        driver.findElement(By.cssSelector(String.format(dateTemplate,checkInDate))).click();
        driver.findElement(By.cssSelector(String.format(dateTemplate,checkOutDate))).click();
        driver.findElement(By.cssSelector(".sb-searchbox__button")).click();

        Actions actions = new Actions(driver);

        WebElement chooseAdults = driver.findElement(By.cssSelector("#group_adults"));
        actions.click(chooseAdults).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        WebElement chooseRooms = driver.findElement(By.cssSelector("#no_rooms"));
        actions.click(chooseRooms).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='group_adults']//option[@selected and @value='4']")));
        driver.findElement(By.cssSelector(".sb-searchbox__button")).click();

        WebElement minBudgetHotelCheckbox = driver.findElement(By.cssSelector("#filter_price a[data-id='pri-1']"));
        minBudgetHotelCheckbox.click();
        int minBudget = Integer.parseInt(minBudgetHotelCheckbox.getText().replaceAll("[^0-9]+", ""));
        System.out.println("Prices for budget hotels in Moscow are less than " + minBudget + " BYN per night");

        WebElement firstHotel = driver.findElement(By.xpath("//*[@data-hotelid][1]//div[contains(@class,'bui-price-display__value')]"));
        int cheapestHotelperDay =  Integer.parseInt(firstHotel.getText().replaceAll("[^0-9]+", ""))/7;
        System.out.println("The first from the list costs " + cheapestHotelperDay + " BYN per night");

        assertTrue("The Price of the Hotel is not in the required Price Range! ", cheapestHotelperDay <= minBudget);

        driver.quit();

        System.out.println((double) (System.currentTimeMillis() - time)/1000);
    }
}
