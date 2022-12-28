package tw.com.springboot;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tw.com.springboot.bean.User;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //返回IOC容器
        ConfigurableApplicationContext ioc = SpringApplication.run(MainApplication.class, args);

        boolean cat = ioc.containsBean("cat");
        System.out.println("容器中cat组件："+cat);

        boolean eason = ioc.containsBean("eason");
        System.out.println("容器中eason组件："+eason);
    }
}
