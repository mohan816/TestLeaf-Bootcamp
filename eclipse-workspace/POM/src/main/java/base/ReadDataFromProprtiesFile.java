package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromProprtiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream("./src/main/resources/config.properties");
Properties prop=new Properties();
prop.load(fis);
System.out.println(prop.getProperty("LoginPage.Username.id"));



	}

}
