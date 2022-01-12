import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import com.MainPage;
import static com.codeborne.selenide.WebDriverConditions.*;
import static org.junit.Assert.*;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class UserLoginTest {

    MainPage mainPage = open(MainPage.URL, MainPage.class);
    //НАДО РЕАЛИЗОВАТЬ АВТОРИЗАЦИЮ ПОЛЬЗОВАТЕЛЯ ЧЕРЕЗ ИМЕЕЮЩИЕСЯ МЕТОДЫ
    String email = "test123@test.ru";
    String password = "123123";

//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("/Users/sergey/Desktop/automation/WebDriver/yandexdriver");
//        WebDriverRunner.setWebDriver(new ChromeDriver(options));

    @Test
    //@Description("Авторизация пользователя. Кнопка "Войти в аккаунт"")
    public void loginUserWithLoginButtonTest(){

    // 2. Действия

        mainPage
                .clickLoginButton()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick();

        boolean buttonShow = mainPage.arrangeOrderButtonVisible();

    // 3. Проверки
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        assertTrue("Button invisible", buttonShow);

    }

    @Test
    //@Description("Авторизация пользователя. Кнопка "Личный кабинет"")
    public void loginUserWithCabinetButtonTest(){

        mainPage
                .clickCabinetButton()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick();

        boolean buttonShow = mainPage.arrangeOrderButtonVisible();

    // 3. Проверки
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        assertTrue("Button invisible", buttonShow);
    }

    @Test
    //@Description("Авторизация пользователя. Кнопка "Войти" на странице регистрации")
    public void loginUserWithLoginButtonInRegPageTest(){

        mainPage
                .clickLoginButton()
                .regLinkClick()
                .loginLinkClick()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick();

        boolean buttonShow = mainPage.arrangeOrderButtonVisible();

        // 3. Проверки
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        assertTrue("Button invisible", buttonShow);

    }

    @Test
    //@Description("Авторизация пользователя. Кнопка "Войти" страница востановления пароля")
    public void loginUserWithResetPasswordLinkTest(){

        mainPage
                .clickLoginButton()
                .resetPasswordLinkClick()
                .loginLinkClick()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick();

        boolean buttonShow = mainPage.arrangeOrderButtonVisible();

        // 3. Проверки
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        assertTrue("Button invisible", buttonShow);

    }

    @Test
    //@Description("Выход пользователя")
    public void logoutUserTest(){

        mainPage
                .clickLoginButton()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick()
                .clickCabinetButton()
                .exitButtonClick();

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
    }
}

