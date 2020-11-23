package producthunt;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class votecount {
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		File file = new File("/home/dinesh/old.txt");
	    String productUrl ="null",ProductName ="null",VoteCount= "null";
	    String url = "jdbc:mysql://localhost:3306/producthunt";
		String username = "root";
		String password = "dineshdd";
	  
		Scanner scan;
		scan = new Scanner(file);
		while (scan.hasNextLine()) {
			productUrl = scan.nextLine();
			try {
		driver.get(productUrl);
		driver.manage().window().maximize();
		 ProductName = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div[2]/div[2]/h1/a[1]"))
				.getText();
		 VoteCount = driver
				.findElement(By.xpath("/html/body/div[1]/div/main/div[2]/aside/div[1]/button/span/span[2]")).getText();
		System.out.println(VoteCount);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql;
		sql = "INSERT INTO votenov(ProductName,VoteCount) VALUES (?,?) ";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, ProductName);
		statement.setString(2,VoteCount );
		statement.executeUpdate();

			}catch (Exception e) {
				e.printStackTrace();
			}
			}
	}
}
