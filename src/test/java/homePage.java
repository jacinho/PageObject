
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class homePage {
    private ChromeDriver driver
            ;

    @BeforeMethod
    public void ouvrirChrome() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();

        By cookiesSelector = By.name("accept");
        driver.findElement(cookiesSelector).click();
    }

    @AfterMethod
    public void fermerChrome() {
      //  driver.quit();
    }


    @Test
    public void testNintendo() {
        String resultatattendu = "Nintendo Switch";
        By barreRecherche = By.id("twotabsearchtextbox");
        driver.findElement(barreRecherche).sendKeys("Nintendo Switch ");
        driver.findElementById("nav-search-submit-button").click();
        List<WebElement> listeImage = driver.findElements(By.cssSelector(".a-section.a-spacing-medium"));
        listeImage.get(0).click();
        By titleSelector = By.cssSelector("#productTitle");
       String resultatTrouve = driver.findElement(titleSelector).getText();
       // System.out.println(resultatTrouve);


        Assert.assertTrue(resultatTrouve.contains(resultatattendu),"Le resultat n'est pas le bon");

    }


    }











