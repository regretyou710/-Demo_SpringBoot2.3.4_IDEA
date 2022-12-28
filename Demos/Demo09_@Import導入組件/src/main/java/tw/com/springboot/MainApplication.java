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

        //查看容器中的組件
        for (String beanDefinitionName : ioc.getBeanNamesForType(User.class)) {
            System.out.println(beanDefinitionName);
        }

        DBHelper dbHelper = ioc.getBean(DBHelper.class);
        System.out.println(dbHelper);
    }
}
