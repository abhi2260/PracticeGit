package connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Db {
	
	public static void main(String[] args) {
		// TODO Augenerated method stub
		Properties prop=null;
		Connection con=null;
		Statement s=null;
		ResultSet rs=null;
		String ss="";
		String ssa="";
		WebDriver driver=null;
		
		try {
		FileInputStream fis=new FileInputStream("C:\\Users\\Windows7\\eclipse-workspace\\DbConnection\\src\\resources\\data.properties");
		
			try{
				prop=new Properties();
				prop.load(fis);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(prop.get("host"));
		try {
		con=DriverManager.getConnection("jdbc:mysql://"+prop.get("host")+":"+prop.get("port")+"/demo","root","root123");
		
			try{
				s=con.createStatement();
				try {
					rs=s.executeQuery("select * from abcd having name='Vikash'");
					ss=rs.getString("name");
					ssa=rs.getString("age");
					
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Windows7\\Downloads\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(ss);
	}

}
