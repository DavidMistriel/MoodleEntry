
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class Main{


    public static void main(String[] args)throws Exception{
        String password, userName;
        Scanner s = new Scanner(System.in);
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement personalInfo = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div[1]/div/nav/ul/li[7]/a"));
        personalInfo.click();
        System.out.println("Please enter your UserName and Password");
        userName = s.next();
        password = s.next();
        WebElement userId = driver.findElement(By.id("Ecom_User_ID"));
        userId.sendKeys(userName);
        WebElement userPassword = driver.findElement(By.id("Ecom_Password"));
        userPassword.sendKeys(password);
        WebElement Enter = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/form/p[2]/input"));
        Enter.click();
        WebElement enterMoodle = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div[4]/div[1]/a"));
        enterMoodle.click();
        Thread.sleep(3000);

        List<WebElement> webElements = driver.findElements(new By.ByTagName("h6"));
        int subjectCount = 0;
        for(int i =0;i<webElements.size()-1;i++) {
            String Text = webElements.get(i).getText();
            System.out.println(Text);
            subjectCount=i;


        }
        System.out.println("What Subject would you like to enter to.\nPlease choose between numbers 1 to "+subjectCount);
        int subject = s.nextInt();
        while (subject>subjectCount||subject<1){
            System.out.println("Sorry but that number doesn't match with any subject\nPlease choose between numbers 1 to "+subjectCount);
            subject = s.nextInt();
        }
        WebElement pickedSubject = webElements.get(subject-1);
        pickedSubject.click();

        System.out.println("To EXIT the moodle please enter -1");
        int exitMoodle = s.nextInt();
        while(exitMoodle != -1){
            System.out.println("To EXIT the moodle please enter -1");
            exitMoodle = s.nextInt();
        }
        WebElement userMenu = driver.findElement(By.className("usermenu"));
        userMenu.click();
        Thread.sleep(200);
        WebElement exit = driver.findElement(By.id("actionmenuaction-6"));
        exit.click();
        Thread.sleep(1000);
        WebElement finalExit = driver.findElement(By.xpath("//*[@id=\"menu-top-header\"]/li[2]/a"));
        finalExit.click();
        }
    }



