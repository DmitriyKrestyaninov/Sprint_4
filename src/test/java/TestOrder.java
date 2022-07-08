import org.junit.After;
import org.junit.Before;
import pageObject.*;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOrder {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);

        mainPage.waitForLoadHomePage();
        mainPage.clickCookieButton();
        mainPage.clickOrderButton();

        testOrderScooter(driver,"Дмитрий", "Крестьянинов", "Быстрецкая 20","Сокольники","79105715592","11.07.2022","сутки","black");
        testOrderScooter(driver,"Евгений", "Демченко", "Костычева 17","Черкизовская","79105715599","12.07.2022", "двое суток", "grey");
    }
    @After
    public void teardown() {
        driver.quit();
    }

   public void testOrderScooter(WebDriver driver, String name, String secondName, String adress,String metroStation, String numberTelephone, String whenToBring,String rentalPeriod, String color){

       OrderPage orderPage =  new OrderPage(driver);
       orderPage.waitForLoadOrderPage();
       orderPage.setOrderDetails(name, secondName, adress,metroStation,numberTelephone);
       orderPage.waitAboutRent();
       orderPage.setAboutRent(whenToBring,rentalPeriod,color);
       orderPage.waitOrderConfirm();
       orderPage.clickButtonConfirmOrder();
       orderPage.waitWindowOrder();
       Assert.assertEquals(true, orderPage.getConfirmOrder());
   }
}
