package tw.com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序類;主配置類
 *
 * @SpringBootApplication：這是一個SpringBoot應用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //返回IOC容器
        ConfigurableApplicationContext ioc = SpringApplication.run(MainApplication.class, args);

        //查看容器中的組件
        for (String beanDefinitionName : ioc.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }
}
