package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
             public final By FBLOGIN_USERNAME_EDITBOX = By.id("email");
             public final By FBLOGIN_PASSWORD_EDITBOX = By.id("pass");
             public final By FBLOGIN_LOGIN_BUTTON = By.name("login");
             public final By ZONAL_LINK = By.name("P-24Alist");
             public final By Last_Updated_text= By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[8]/td[2]/span[1]");
             
          //   assign no:19
             public final By DRAG_ELEMENT = By.xpath("//div[@id='draggable']");
             public final By DROP_ELEMENT = By.xpath("//div[@id='droppable']");
           //  assign 20
             public final By BASIC_ALERT = By.xpath("//button[@id='btnAlert']");
             
             //SWITCHTAB
             public final By OPEN_NEW_WINDOW = By.xpath("//button[text()=' Click to open new Window ']");
             
             
             public final By AUTOMATION_ADD_TO_CART = By.xpath("//a[@title=\"Add to cart\"]");
          
             
             
             
             //ENDTOEND
             public final By Leaving_From = By.xpath("//input[@id=\"orgAC_value\"]");
             public final By Arrived_To = By.xpath("//input[@id=\"desAC_value\"]");
             public final By Date_Picker = By.xpath("//input[@id=\"depDT_value\"]");
             //select date
             public final By Select_Date = By.xpath("(//table[@role='grid'])[2]/tbody/tr[2]/td[2]");
             public final By Return_Date_picker = By.xpath("//input[@id='retDT_value']");
             //select return date
             public final By Select_Return_Date = By.xpath("(//table[@role='grid'])[2]/tbody/tr[3]/td[1]");
             public final By Click_Search_Button = By.xpath("//input[@value='Search']");
             //Select_Hotel
             public final By Select_Hotel = By.xpath("/html/body/form/div[9]/div[4]/div[3]/div[4]/ul/li[+num+]/div[2]/div[1]/h3/span[1]/a");
            
             
             
             
             
             
             
             
             
             
             
             //web_table
             public final By click_Edit_pencil = By.xpath("//table[@class=\"table table-hover table-responsive table-list-search\"]/tbody/tr[2]/td[5]");
             public final By Click_First_Name= By.xpath("//input[@id='fn']");
             public final By Click_Second_Name= By.xpath("//input[@id='ln']");
             public final By Click_Middle_Name= By.xpath("//input[@id='mn']");
             public final By Click_Update = By.xpath("//button[@class='btn btn-warning']");
             
             
             
}
