package producthunt;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IndividualDetailsProductHunt {
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		File file = new File("/home/dinesh/new.txt");
		String url = "jdbc:mysql://localhost:3306/producthunt";
		String username = "root";
		String password = "dineshdd";
	    String productUrl ="null",ProductName ="null",site ="null",officalsite ="null",VoteCount= "null",tag1 ="null",tag2 ="null";
		java.util.Date Date=new java.util.Date();
		java.sql.Date date=new java.sql.Date(Date.getTime());
		Scanner scan;
		scan = new Scanner(file);
		while (scan.hasNextLine()) {
			productUrl = scan.nextLine();
			try {
		driver.get(productUrl);
		driver.manage().window().maximize();
		 ProductName = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div[2]/div[2]/h1/a[1]"))
				.getText();
		 site = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[2]/aside/div[2]/a/div/span")).getText();
		 System.out.println(site);
		 officalsite = "https://"+site+"/";
		 System.out.println(officalsite);
		 VoteCount = driver
				.findElement(By.xpath("/html/body/div[1]/div/main/div[2]/aside/div[1]/button/span/span[2]")).getText();
		 tag1 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div[2]/div[2]/div/div[1]"))
				.getText();
		 tag2 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div[2]/div[2]/div/div[2]"))
				.getText();
		System.out.println(ProductName);
		System.out.println(VoteCount);
		System.out.println(tag1);
		System.out.println(tag2);
			}catch (Exception e) {
				e.printStackTrace();
			}
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql;
		sql = "INSERT INTO november(productUrl,ProductName,officalsite,date,VoteCount,tag1,tag2) VALUES (?,?,?,?,?,?,?) ";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, productUrl);
		statement.setString(2, ProductName);
		statement.setString(3, officalsite);
		statement.setDate(4, date);
		statement.setString(5, VoteCount);
		statement.setString(6, tag1);
		statement.setString(7, tag2);
		statement.executeUpdate();
		}
	}
}
