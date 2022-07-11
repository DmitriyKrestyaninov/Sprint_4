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

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
    }
    @Test
    public void testOrderScooterClickOnButtonTopPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadHomePage();
        mainPage.clickCookieButton();
        mainPage.clickOrderButtonTopPage();
        testOrderScooter(driver,"Дмитрий", "Крестьянинов", "Быстрецкая 20","Сокольники","79105715592","11.07.2022","сутки","black");
    }
    @Test
    public void testOrderScooterClickOnButtonLowerPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadHomePage();
        mainPage.clickCookieButton();
        mainPage.clickOrderButtonLowerPage();
        testOpenpaigeOrder(driver);
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
       Assert.assertTrue(orderPage.getConfirmOrder());
   }
   public void testOpenpaigeOrder (WebDriver driver){
       OrderPage orderPage =  new OrderPage(driver);
       orderPage.waitForLoadOrderPage();
       Assert.assertTrue(orderPage.returnOrderLogoPage().isDisplayed());
   }
}

