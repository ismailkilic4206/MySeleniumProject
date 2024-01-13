package no01_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_TestExercise {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.manage().window().maximize();
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");


        Thread.sleep(2000);
        //2- Add Element butonuna basin
        driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();


        Thread.sleep(2000);
        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));

        if (deleteButton.isDisplayed()){
            System.out.println("Test is PASSED");
        }
        else
            System.out.println("Test is FAILED");


        Thread.sleep(2000);
        //4- Delete tusuna basin
        deleteButton.click();


        Thread.sleep(2000);
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement add_RemoveElement = driver.findElement(By.tagName("h3"));

        if (add_RemoveElement.isDisplayed()){
            System.out.println("Test is PASSED");
        }
        else
            System.out.println("Test is FAILED");


        Thread.sleep(2000);
        driver.close();
    }
}