package br.com.pointel.arkhing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Estrategia {

    private final String entrypoint;
    private final WebDriver webDriver;
    private final WebDriverWait webWait;

    public Estrategia(String entrypoint) {
        this.entrypoint = entrypoint;
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Chrome\\chrome\\chrome.exe");
        this.webDriver = new ChromeDriver(options);
        this.webWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
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
        waitFor(700);
        userEl.sendKeys("everton.muvi@gmail.com");
        passEl.click();
        waitFor(700);
        passEl.sendKeys(System.getenv("ESTRATEGIA_PASSWORD"));
        nextEl.click();
        waitFor(700);
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
        var divLesson = getHeader(headerIndex);
        var headerLesson = divLesson.findElement(By.cssSelector("h2.SectionTitle"));
        webDriver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
        scrollToElement(headerLesson);
        headerLesson.click();
        waitFor(700);
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

    public void getLessonMaterials(int headerIndex, boolean putHeaderTitleOnClipboard) {
        var divLesson = getHeader(headerIndex);
        if (putHeaderTitleOnClipboard) {
            var headerLesson = divLesson.findElement(By.cssSelector("div.LessonCollapseHeader-title"));
            var headerLessonParagraphh = headerLesson.findElement(By.tagName("p"));
            WizSwing.putStringOnClipboard(headerLessonParagraphh.getText().trim());
        }
        var divMaterials = divLesson.findElement(By.cssSelector("div.LessonButtonList"));
        var links = divMaterials.findElements(By.tagName("a"));
        for (var link : links) {
            if (link.getAttribute("href").contains("pdf")) {
                if (link.getText().toLowerCase().contains("versão original")) {
                    scrollToElement(link);
                    waitFor(1200);
                    altClickElement(link);
                    waitFor(1200);
                }
            }
        }
    }

    public void openDownloads(int headerIndex) {
        var divLesson = getHeader(headerIndex);
        var divLessonContent = divLesson.findElement(By.cssSelector("div.Lesson-content"));
        var iconDownload = divLessonContent.findElement(By.cssSelector("i.icon-download"));
        var iconNotes = divLessonContent.findElement(By.cssSelector("i.icon-notes"));
        iconDownload.click();
        waitFor(1200);
        scrollToElement(iconNotes);
        waitFor(2400);
    }

    public void openItem(int headerIndex, int itemIndex) {
        var divLesson = getHeader(headerIndex);
        var divsItems = divLesson.findElements(By.cssSelector("div.ListVideos-items-video"));
        var divItem = divsItems.get(itemIndex);
        scrollToElement(divItem);
        divItem.click();
        waitFor(1200);
    }

    public void makeDownloads(int headerIndex) {
        var divLesson = getHeader(headerIndex);
        var divLessonContent = divLesson.findElement(By.cssSelector("div.Lesson-content"));
        var divLessonPDFs = divLessonContent.findElement(By.cssSelector("div.LessonButtonList"));
        var linksLessonPDFs = divLessonPDFs.findElements(By.tagName("a"));
        for (var linkLessonPDFs : linksLessonPDFs) {
            if (linkLessonPDFs.getAttribute("href").contains("download")) {
                scrollToElement(linkLessonPDFs);
                altClickElement(linkLessonPDFs);
                waitFor(1200);
            }
        }
        var doneVideo = false;
        var doneAudio = true;
        var linksMedia = divLessonContent.findElements(By.tagName("a"));
        for (var linkMedia : linksMedia) {
            var contents = linkMedia.getText().toLowerCase();
            if (!doneVideo) {
                if (contents.contains("360p") || contents.contains("240p")) {
                    scrollToElement(linkMedia);
                    altClickElement(linkMedia);
                    waitFor(1200);
                    doneVideo = true;
                }
            }
            if (!doneAudio) {
                if (contents.contains("baixar áudio")) {
                    scrollToElement(linkMedia);
                    altClickElement(linkMedia);
                    waitFor(1200);
                    doneAudio = true;
                }
            }
            if (doneVideo && doneAudio) {
                break;
            }
        }
        waitFor(1200);
    }
    
    public void copyTitle(int headerIndex, int itemIndex) {
        var divLesson = getHeader(headerIndex);
        var divsItems = divLesson.findElements(By.cssSelector("div.ListVideos-items-video"));
        var divItem = divsItems.get(itemIndex);
        var spanTitle = divItem.findElement(By.cssSelector("span.VideoItem-info-title"));
        WizSwing.putStringOnClipboard(spanTitle.getText());
        waitFor(1200);
    }
    
    public void tickView(int headerIndex) {
        var divLesson = getHeader(headerIndex);
        var divView = divLesson.findElement(By.cssSelector("div.boxVisualizado"));
        var checkTick = divView.findElement(By.cssSelector("div[color='#1352aa']"));
        var checker = checkTick.findElement(By.cssSelector("div.Icon"));
        if ("none".equals(checker.getCssValue("display"))) {
            scrollToElement(checkTick);
            checkTick.click();
        }
        waitFor(1200);
        waitFor(9600);
    }
    
    private void waitFor(long millis) {
        webWait.withTimeout(Duration.ofMillis(millis));
        WizBase.sleep(millis);
    }

}
