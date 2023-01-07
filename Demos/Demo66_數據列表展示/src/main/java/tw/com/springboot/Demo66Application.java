package tw.com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("tw.com.springboot.mapper")
@SpringBootApplication
public class Demo66Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo66Application.class, args);
	}

}
