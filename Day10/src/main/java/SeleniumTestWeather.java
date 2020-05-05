import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTestWeather {

    public static void main(String[] args) {

        String pathToDriver= "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");                                                                          //метод загружает страницу в текущее окно браузера
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("Погода Минск");

        driver.findElement(By.xpath(" //div[@id='lga']")).click(); //click aside

        WebElement search = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[contains(@value,'Google')]")); //first button
        //WebElement search = driver.findElement(By.xpath("//div[@jsname='VlcLAe']//input[contains(@value,'Google')]")); //second button
        search.click();

        WebElement tomorrowTab = driver.findElement(By.xpath("//div[@class='wob_df'][1]"));
        tomorrowTab.click();

        WebElement tomorrowDayOfWeek = driver.findElement(By.xpath("//*[@id='wob_dp']/div[2]/div[@class='vk_lgy']"));

        String day = tomorrowDayOfWeek.getAttribute("aria-label");
        String time = "12:00";
        String scale = "Celsius";
        String weatherInfo = "//*[contains(@aria-label, '%s %s') and contains(@aria-label, '%s')][1]";

        WebElement dayOfWeekWeather = driver.findElement(By.xpath(String.format(weatherInfo, day, time, scale)));

        String tomorrowWeather = dayOfWeekWeather.getAttribute("aria-label");

        String MSG = "The temperature tomorrow at %s will be %s%s";
        System.out.println(String.format(MSG, time, tomorrowWeather.substring(0,tomorrowWeather.indexOf("C")), scale.substring(0,1)));

        driver.quit();


        /*
        driver.getTitle();
        driver.getCurrentUrl());

        driver.navigate().to("https://yandex.ru/");                 //метод ходит по страницам
        driver.navigate().back();                                   //на предыдущую страницу
        driver.navigate().forward();                                //на следующую страницу

        driver.navigate().refresh();                                //метод перезаружает текущую страницу
        driver.close();                                             //метод закрывает текущее окно
        driver.quit();                                              //метод закрывает все окна и завершает сессию

        List<WebElement> els = driver.findElements(By.tagName());   //возвращает несколько найденных элементов
        element.sendKeys();                                         //напечататать ввод
        */
    }
}

