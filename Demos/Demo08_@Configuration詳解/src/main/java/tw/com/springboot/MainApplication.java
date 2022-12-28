package tw.com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tw.com.springboot.bean.Pet;
import tw.com.springboot.bean.User;
import tw.com.springboot.config.MyConfig;

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

        //從容器中獲取組件
        Pet tom1 = ioc.getBean("tom", Pet.class);
        Pet tom2 = ioc.getBean("tom", Pet.class);
        System.out.println("組件:" + (tom1 == tom2));//true

        //配置類本身也是組件
        MyConfig myConfig = ioc.getBean(MyConfig.class);
        System.out.println(myConfig);

        //驗證@Configuration(proxyBeanMethods = true):外部無論對配置類中的這個組件注冊方法調用多少次獲取的都是之前注冊容器中的單實例對象
        //如果@Configuration(proxyBeanMethods = true)代理對象調用方法。SpringBoot總會檢查這個組件是否在容器中有。
        //保持組件單實例
        User user1 = myConfig.user01();
        User user2 = myConfig.user01();
        System.out.println(user1 == user2);//true

        //如果@Configuration(proxyBeanMethods = false)
        User user3 = ioc.getBean("user01", User.class);
        Pet tom3 = ioc.getBean("tom", Pet.class);
        System.out.println("寵物:" + (user3.getPet() == tom3));//false
    }
}
