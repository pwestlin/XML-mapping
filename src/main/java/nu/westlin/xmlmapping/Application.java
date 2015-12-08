package nu.westlin.xmlmapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@SpringBootApplication
@ComponentScan(basePackages = "nu.westlin.xmlmapping")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(Application.class);

        ConfigurableApplicationContext ctx = springApplication.run(args);
        XMLHelper xmlHelper = ctx.getBean(XMLHelper.class);

        // load Customer
        Customer customer = (Customer) xmlHelper.load(new StreamSource(new FileInputStream("src/main/resources/customer.xml")));
        // update Customer
        PhoneNumber pn = new PhoneNumber();
        pn.setType("Additional");
        pn.setValue("613-123-1234");
        //customer.getPhoneNumbers().add(pn);
        // save Customer
        xmlHelper.save(customer, new StreamResult(new FileOutputStream("src/main/resources/customer2.xml")));
    }
}
