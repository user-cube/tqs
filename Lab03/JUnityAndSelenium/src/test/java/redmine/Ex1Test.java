package redmine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

public class Ex1Test {
    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void ex1() {
        driver.get("http://demo.redmine.org/");
        driver.manage().window().setSize(new Dimension(1552, 849));
        driver.findElement(By.linkText("Entrar")).click();
        driver.findElement(By.id("username")).sendKeys("bananasecocos");
        driver.findElement(By.id("password")).sendKeys("1234Abcd");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.id("loggedas")).click();
        driver.findElement(By.linkText("Sair")).click();
        {
            List<WebElement> elements = driver.findElements(By.linkText("Entrar"));
            assert(elements.size() > 0);
        }
    }
}