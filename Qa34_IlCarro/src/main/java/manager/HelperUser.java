package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        //wd.findElement(By.cssSelector("a[href='/login?url=%2Fsearch']")).click();
        //wd.findElement(By.cssSelector("a[href ^='/login']")).click();
        // wd.findElement(By.xpath("//a[starts-with(@href,'/login']")).click();
        wd.findElement(By.xpath("//a[text()=' Log in ']")).click();
    }

    public void fillLoginForm(String email,String password){
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    public void submitLogin(){
        // wd.findElement(By.cssSelector("button[type='submit']")).click();
        wd.findElement(By.xpath("//button[text()='Y’alla!']")).click();  // YЕalla!
    }

}
