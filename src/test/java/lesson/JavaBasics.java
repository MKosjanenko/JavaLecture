package lesson;

import model.Article;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qa on 3/4/2018.
 */
public class JavaBasics {
    private static  final String MAIN_PAGE_WEB_URL ="http://www.delfi.lv/");
    private static final By ARTICLE = By.className("top2012-big");
    private static  final By TITLE = By.xpath(".//a[contains(@class, 'top2012-title')]");
    private static  final By COMMENT = By.xpath(".//a[@class = 'top2012-title']");

    @Test
    public void  FirstFiveArticlesTest() {
        System.setProperty("webdriver.firefox.bin", "C:/Users/qa/AppData/Local/Mozilla Firefox/firefox.exe/");
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get(MAIN_PAGE_WEB_URL);

        List<WebElement> articles = driver.findElement(ARTICLE);

        List <Article> firstFive = new ArrayList<Article>();

        for (int i = 0; i<5; i++) {
            //Create object
            //set field values
            //put into List

            Article a = new Article();
            WebElement we = articles.get(i);

            a.setTitle(we.findElement(TITLE).getText());
            if (we.findElements(COMMENT).isEmpty()){
                a.setCommentCount(0)
            } else {
                a.setCommentCount(we.findElement(COMMENT).getText());
            }

            a.setLink((we.findElement(TITLE).getAttribute("href")));


        }
    }
}
