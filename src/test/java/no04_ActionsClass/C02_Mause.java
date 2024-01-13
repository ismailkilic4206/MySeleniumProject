package no04_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C02_Mause {

    @Test
    public void mouseTest1(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        Actions actions = new Actions(driver);

        //1- https://demoqa.com/buttons adresine gidiniz
        driver.get("https://demoqa.com/buttons");

        //2- double click me elementine tiklayin
        WebElement doubleClick = driver.findElement(By.cssSelector("button[id='doubleClickBtn']"));
        actions.doubleClick(doubleClick).perform();

        //3- right click me elementine tiklayin
        WebElement rightClickButton = driver.findElement(By.cssSelector("button[id='rightClickBtn']"));
        actions.contextClick(rightClickButton).perform();

        //4- You have done a double click yazisinin gorunur oldugunu test ediniz
        WebElement doubleClickMessage = driver.findElement(By.cssSelector("p[id='doubleClickMessage']"));
        Assert.assertTrue(doubleClickMessage.isDisplayed());

        //5- You have done a double click yazisini yazdiriniz
        System.out.println(doubleClickMessage.getText());

        //6- You have done a right click yazisinin gorunur oldugunu test ediniz
        WebElement rightClickMessage = driver.findElement(By.cssSelector("p[id='rightClickMessage']"));
        Assert.assertTrue(rightClickMessage.isDisplayed());

        //7- You have done a right click yazisini yazdiriniz
        System.out.println(rightClickMessage.getText());

        //8- sayfayi kapatiniz
        driver.close();



    }
}
