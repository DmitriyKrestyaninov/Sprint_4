package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private By headingOfOrder = By.className("Order_Header__BZXOb");
    // Поле имя
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // Поле Фамилия
    private By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле Адрес
    private By adressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле станция метро
    private By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Станция метро
    private String metroStationSelect = ".//div[@class = 'Order_Text__2broi' and text()='%s']";

    //Поле телефон
    private By numberTelephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private By buttonAdditional = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    //Заголовок про Аренду
    private By logoAboutRent  = By.className("Order_Header__BZXOb");

    //Когда привезти заказ
    private By  whenToBringField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Выбранная дата
    private By selectDateField = By.xpath(".//div[@class='react-datepicker__week']/div[contains(@class,'day--selected')]");
    //Срок аренды
    private By  rentalPeriodField = By.className("Dropdown-placeholder");
    //Выбранный срок аренды
    private String  selectRentalPeriod = ".//div[@class = 'Dropdown-option' and text()='%s']";

    //Кнопка заказать
    private By orderButton = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Buttons__1xGrp > button:nth-child(2)");

    //Заголовов формы подтверждения заказа
    private By headingOrderConfirm = By.className("Order_ModalHeader__3FDaJ");

    //Кнопка подтвердить заказ
    private By confirmOrderButton = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button:nth-child(2)");

    //Окно заказа
    private By windowOrder = By.className("Order_Form__17u6u");
    private WebDriver driver;
    public OrderPage (WebDriver driver) {
        this.driver = driver;
    }
    public void setOrderDetails(String name, String secondName, String adress,String metroStation,String numberTelephone){
        setName(name);
        setSecondName(secondName);
        setAdress(adress);
        setMetroStation(metroStation);
        setNumberTelephone(numberTelephone);
        clickButtonAdditional();
    }

    public void setAboutRent(String date, String rentalPeriod, String color){
        setWhenToBring(date);
        setRentalPeriod(rentalPeriod);
        setColor(color);
        clickButtonOrder();

    }
    private void setName (String name){
        driver.findElement(nameField).sendKeys(name);
    }
   private void setSecondName (String secondName){
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    private void setAdress (String adress){
        driver.findElement(adressField).sendKeys(adress);
    }
    private void setMetroStation (String metroStation){
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(String.format(metroStationSelect,metroStation))).click();
    }
    private void setNumberTelephone (String numberTelephone){
        driver.findElement(numberTelephoneField).sendKeys(numberTelephone);
    }
    private void clickButtonAdditional() {
        driver.findElement(buttonAdditional).click();
    }
    private void setWhenToBring(String date){
        driver.findElement(whenToBringField).sendKeys(date);
        driver.findElement(selectDateField).click();

    }
    private void setRentalPeriod(String rentalPeriod){
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(String.format(selectRentalPeriod,rentalPeriod))).click();

    }
    private void setColor(String color){
        driver.findElement(By.id(color)).click();
    }

    public void clickButtonConfirmOrder(){
        driver.findElement(confirmOrderButton).click();
    }
    private void clickButtonOrder(){
        driver.findElement(orderButton).click();
    }
    public void waitForLoadOrderPage(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(headingOfOrder));
    }
    public WebElement returnOrderLogoPage (){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(headingOfOrder));
        return driver.findElement(headingOfOrder);
    }
    public void waitAboutRent(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(logoAboutRent));
    }

    public void waitOrderConfirm(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(headingOrderConfirm));
    }

    public void waitWindowOrder(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(windowOrder));
    }

    public boolean getConfirmOrder(){
      return driver.findElement(headingOrderConfirm).getText().contains("Заказ оформлен");
    }
}
