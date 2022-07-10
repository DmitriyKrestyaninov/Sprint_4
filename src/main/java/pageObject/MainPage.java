package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {

    //Логотип на основной основной страницы
    private By logoOfMainPage = By.className("Header_Logo__23yGT");

    // Кнопки выпадающего списка "Вопросы о важном"
    private By importantQuestionButton1 = By.id("accordion__heading-0");
    private By importantQuestionButton2 = By.id("accordion__heading-1");
    private By importantQuestionButton3 = By.id("accordion__heading-2");
    private By importantQuestionButton4 = By.id("accordion__heading-3");
    private By importantQuestionButton5 = By.id("accordion__heading-4");
    private By importantQuestionButton6 = By.id("accordion__heading-5");
    private By importantQuestionButton7 = By.id("accordion__heading-6");
    private By importantQuestionButton8 = By.id("accordion__heading-7");

    //Список ответов на "Вопросы о важном"
    private By importantAnswer1 = By.id("accordion__panel-0");
    private By importantAnswer2 = By.id("accordion__panel-1");
    private By importantAnswer3 = By.id("accordion__panel-2");
    private By importantAnswer4 = By.id("accordion__panel-3");
    private By importantAnswer5 = By.id("accordion__panel-4");
    private By importantAnswer6 = By.id("accordion__panel-5");
    private By importantAnswer7 = By.id("accordion__panel-6");
    private By importantAnswer8 = By.id("accordion__panel-7");

    // Кнопка "Заказать" на верхней панели
    private By orderButtonTopPaige = By.className("Button_Button__ra12g");

    //Кнопка  "заказать" внизу страницы
    private By orderButtonLowerPage = By.className("Button_Middle__1CSJM");
    //Кнопка "да все привыкли"
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    private WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;

    }

    public void waitForLoadHomePage(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(logoOfMainPage));
    }
    public void  clickOrderButtonTopPage () {
        driver.findElement(orderButtonTopPaige).click();
    }
    public void clickOrderButtonLowerPage()  {
        WebElement element = driver.findElement(orderButtonLowerPage);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        element.click();
    }

    public String clickQuestionButton1Result(){
        return  getAnswer(importantQuestionButton1,importantAnswer1);
    }
    public String clickQuestionButton2Result(){
        return getAnswer(importantQuestionButton2,importantAnswer2);
    }
    public String clickQuestionButton3Result(){
        return getAnswer(importantQuestionButton3,importantAnswer3);
    }
    public String clickQuestionButton4Result(){
        return getAnswer(importantQuestionButton4,importantAnswer4);
    }
    public String clickQuestionButton5Result(){
        return getAnswer(importantQuestionButton5,importantAnswer5);
    }
    public String clickQuestionButton6Result(){
        return getAnswer(importantQuestionButton6,importantAnswer6);
    }
    public String clickQuestionButton7Result(){
        return getAnswer(importantQuestionButton7,importantAnswer7);
    }
    public String clickQuestionButton8Result(){
        return getAnswer(importantQuestionButton8,importantAnswer8);
    }
    public String getAnswer(By selectorButton, By selectorQuestion){
        WebElement element = driver.findElement(selectorButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(selectorQuestion));
        return driver.findElement(selectorQuestion).getText();
    }
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }


}



