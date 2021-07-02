package com.example.springWeather;

// Testing using Selenium - JUnit

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;


public class LoginPageTestByJunit {

    static WebDriver driver;
    static WebDriver foxDriver;

    @Test
    void contextLoads() {

    }

    @BeforeAll
    static void beforeAll() {

        System.out.println("**--- Executed once before all test methods in this class ---**");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\msubr\\Webdriver\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\msubr\\Webdriver\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        //initialise the WebDriver
        foxDriver = new FirefoxDriver();
        driver = new ChromeDriver();
    }



    /* reference Test
    @Test
    public void loginTest(){
        driver.get("https://opensource-demo.orangehrmlive.com/"); //define the url
        String pageTitle = driver.getTitle();       //get the title of the webpage
        System.out.println("The title of this page is ===> " +pageTitle);
        Assert.assertEquals("OrangeHRM", pageTitle);    //verify the title of the webpage

        driver.findElement(By.id("txtUsername")).clear();//clear the input field before entering any value
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");//enter the value of username
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");//enter the value of password
        driver.findElement(By.id("btnLogin")).click();      //click Login button

    }
    */

    @Test
    public void loginTest(){
        driver.get("https://opensource-demo.orangehrmlive.com/"); //define the url
        String pageTitle = driver.getTitle();       //get the title of the webpage
        System.out.println("The title of this page is ===> " +pageTitle);
        Assertions.assertEquals("OrangeHRM", pageTitle);    //verify the title of the webpage

        driver.findElement(By.id("txtUsername")).clear();//clear the input field before entering any value
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");//enter the value of username
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");//enter the value of password
        driver.findElement(By.id("btnLogin")).click();      //click Login button

    }

    @Test
    public void testgooglrsearch(){

        //it will open the goggle page
        foxDriver.get("http://google.in");
        //we expect the title “Google “ should be present
        String Expectedtitle = "Google";
        //it will fetch the actual title
        String Actualtitle = foxDriver.getTitle();
        System.out.println("Before Assetion " + Expectedtitle + Actualtitle);
        //it will compare actual title and expected title
        Assertions.assertEquals(Actualtitle, Expectedtitle);
        //print out the result
        System.out.println("After Assertion " + Expectedtitle + Actualtitle + " Title matched ");
    }


    @AfterAll
    static void afterAll() {
        driver.quit();
        foxDriver.quit();
        System.out.println("**--- Executed once after all test methods in this class ---**");
    }

}
