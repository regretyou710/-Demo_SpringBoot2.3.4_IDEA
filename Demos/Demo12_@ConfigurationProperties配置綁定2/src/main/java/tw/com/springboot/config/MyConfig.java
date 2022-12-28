package tw.com.springboot.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tw.com.springboot.bean.Car;

@EnableConfigurationProperties(Car.class)
//1、開啟Car配置綁定功能
//2、把這個Car這個組件自動注冊到容器中
@Configuration
public class MyConfig {

}
