/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news_scraping;

import java.awt.HeadlessException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author abigail
 */
public class News_Scraping {
    private static final String username="root";
   private static final String password="";
   private static final String conn_string="jdbc:mysql://localhost:3306/fornews";
    
    
    public static void main(String[] args) throws ClassNotFoundException {
       System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe"); 
        
         WebDriver driver;          
          
         driver = new ChromeDriver();  

         driver.get("https://www.bbc.com/news"); 
         
     String titleone= "Zehabesha-Latest Ethiopian News Provider";
       
    // driver.findElement(By.xpath("//*[@id=\"primarymid\"]/div[1]/h2/a")).click();
       
      String newsone = driver.findElement(By.xpath("//*[@id=\"responsive-news\"]/body")).getText();
        

        Connection conn=null;
       try {
          // Class.forName("com.mysql.jdbc.Driver").newInstance();
       conn=DriverManager.getConnection(conn_string, username, password);
           System.out.println("Connected");
       //pstmt=conn.prepareStatement("insert into newstable values(?,?)");
       //pstmt.setString(1, titleone);
       //pstmt.setString(2, newsone);
       
       String sql="insert into newstable(title,news)values(?,?)";
       PreparedStatement ps=conn.prepareStatement(sql);
       ps.setString(1, titleone);
       ps.setString(2, newsone);
       ps.execute();
       
           System.out.println("saved sucessfully");
       }
       catch(SQLException e){
           System.err.print(e);
       
       }
       
       
   
   
   
    
    
    }
    
    
        
    
    
}
