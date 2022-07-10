import org.junit.After;
import org.junit.Before;
import pageObject.*;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGetAnswerOnQuestion {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
    }

    @Test
    public void testDropDownListButtons(){


        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadHomePage();
        testClickButtonResult(mainPage.clickQuestionButton1Result(), "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        testClickButtonResult(mainPage.clickQuestionButton2Result(), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        testClickButtonResult(mainPage.clickQuestionButton3Result(), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        testClickButtonResult(mainPage.clickQuestionButton4Result(), "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        testClickButtonResult(mainPage.clickQuestionButton5Result(), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        testClickButtonResult(mainPage.clickQuestionButton6Result(), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        testClickButtonResult(mainPage.clickQuestionButton7Result(), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        testClickButtonResult(mainPage.clickQuestionButton8Result(), "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }
    @After
    public void teardown() {
        driver.quit();
    }
    public void testClickButtonResult(String expected,String actual){
        Assert.assertEquals(expected, actual);
    }
}
