package tw.com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "tw.com.springboot")
@SpringBootApplication
public class Demo56Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo56Application.class, args);
	}
}

