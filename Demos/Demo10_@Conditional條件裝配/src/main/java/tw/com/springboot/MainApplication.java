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

        boolean tom = ioc.containsBean("tom");
        System.out.println("容器中Tom组件："+tom);

        boolean user01 = ioc.containsBean("user01");
        System.out.println("容器中user01组件："+user01);//配置類中Bean的加載順序會影響結果

        //標示在類:容器中沒有tom22組件，所以不成立
        boolean tom22 = ioc.containsBean("tom22");
        System.out.println("容器中tom22组件："+tom22);
    }
}
