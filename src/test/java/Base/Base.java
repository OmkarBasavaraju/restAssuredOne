package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class Base {
	
	public static Properties prop;
	public static FileInputStream FI;

	@BeforeTest
	public void setup() throws IOException {
		prop = new Properties();
		FI = new FileInputStream(".\\src\\test\\resources\\config.properties");
		prop.load(FI);
		RestAssured.baseURI = prop.getProperty("baseuri");
		System.out.println("test");
	}
}
