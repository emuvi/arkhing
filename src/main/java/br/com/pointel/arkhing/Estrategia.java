package br.com.pointel.arkhing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Estrategia {

    private final String entrypoint;
    private final WebDriver webDriver;
    private final WebDriverWait webWait;

    public Estrategia(String entrypoint) {
        this.entrypoint = entrypoint;
        this.webDriver = new ChromeDriver();
        this.webWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField")));
    }

    public void start() {
        webDriver.navigate().to(entrypoint);
    }

    public void stop() {
        webDriver.quit();
    }

    public void login() {
        var inputs = webDriver.findElements(By.tagName("input"));
        var userEl = inputs.stream().filter(el -> "loginField".equals(el.getAttribute("name"))).findFirst().orElseThrow();
        var passEl = inputs.stream().filter(el -> "passwordField".equals(el.getAttribute("name"))).findFirst().orElseThrow();
        var buttons = webDriver.findElements(By.tagName("button"));
        var nextEl = buttons.stream().filter(el -> el.getText().contains("Continuar")).findFirst().orElseThrow();
        userEl.click();
        userEl.sendKeys("everton.muvi@gmail.com");
        passEl.click();
        passEl.sendKeys(System.getenv("ESTRATEGIA_PASSWORD"));
        nextEl.click();
    }

    public void clean() {
        webDriver.findElement(By.cssSelector("a#pushActionRefuse")).click();
        var test = webDriver.findElement(By.tagName("getsitecontrol-widget"));
        if (webDriver instanceof JavascriptExecutor) {
            var xcord = test.getRect().width - 60;
            var ycord = test.getRect().y + 30;
            ((JavascriptExecutor) webDriver).executeScript("el = document.elementFromPoint(" + xcord + ", " + ycord + "); el.click();");
        }
    }

    public void openHeader(int headerIndex) {
        WebElement divLesson = getHeader(headerIndex);
        var headerLesson = divLesson.findElement(By.cssSelector("h2.SectionTitle"));
        webDriver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
        scrollToElement(headerLesson);
        headerLesson.click();
    }

    private void scrollToElement(WebElement element) {
        var webActions = new Actions(webDriver);
        webActions.scrollToElement(element);
        webActions.perform();
    }

    private void altClickElement(WebElement element) {
        var webActions = new Actions(webDriver);
        webActions
                .keyDown(Keys.ALT)
                .click(element)
                .keyUp(Keys.ALT)
                .build().perform();
    }

    private WebElement getHeader(int headerIndex) {
        var divsLessons = webDriver.findElements(By.cssSelector("div.LessonList-item"));
        var divLesson = divsLessons.get(headerIndex);
        return divLesson;
    }

    public void getLessonMaterials(int headerIndex) {
        WebElement divLesson = getHeader(headerIndex);
        var divMaterials = divLesson.findElement(By.cssSelector("div.LessonButtonList"));
        var links = divMaterials.findElements(By.tagName("a"));
        for (var link : links) {
            if (link.getAttribute("href").contains("pdf")) {
                scrollToElement(link);
                altClickElement(link);
                WizBase.sleep(1000);
            }
        }
    }

}