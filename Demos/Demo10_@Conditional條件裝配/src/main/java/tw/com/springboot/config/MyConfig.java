package tw.com.springboot.config;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tw.com.springboot.bean.Pet;
import tw.com.springboot.bean.User;

/**
 * 當條件標示在方法上:成立時，方法返回的組件才會加載到容器中，否則就不註冊到容器
 * 當條件標示在類上:成立時，類中的配置才會生效，否則不生效
 */
@ConditionalOnBean(name = "tom22")
@Configuration
public class MyConfig {

    //@ConditionalOnBean(name="tom")
    @Bean
    public User user01() {
        User user = new User("Tom", 18);
        //User組件依賴了Pet組件
        user.setPet(tomcatPet());
        return user;
    }

//    @Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }

    @Bean("tom22")
    public Pet tom22() {
        return new Pet("tomcat");
    }
}
