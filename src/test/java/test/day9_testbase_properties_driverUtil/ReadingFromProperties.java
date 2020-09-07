package test.day9_testbase_properties_driverUtil;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void reading_properties_file() throws IOException {
        //Properties class object allows us
        //to read from configuration.properties
        Properties properties = new Properties();

       String path = "configuration.properties";

       //We need to open this con.properties file in java memory
        FileInputStream file = new FileInputStream(path);

        //we need to load the opened file into the properties object
        properties.load(file);

        //we can read configuration.properties file using properties objectp
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));
    }


    @Test
    public void using_configuration_reader_utility(){
       String browser = ConfigurationReader.getProperty("browser");
        System.out.println("browser: "+browser);
    }

}
