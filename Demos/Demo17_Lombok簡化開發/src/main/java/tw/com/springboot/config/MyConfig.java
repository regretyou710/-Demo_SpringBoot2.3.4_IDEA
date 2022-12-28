package tw.com.springboot.config;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import tw.com.springboot.bean.Pet;
import tw.com.springboot.bean.User;

/**
 * @ImportResource("classpath:beans.xml"):導入Spring的配置文件
 */
@ImportResource("classpath:beans.xml")
@Configuration
public class MyConfig {
    @Bean
    public User user01() {
        User user = new User("Tom", 18);
        //User組件依賴了Pet組件
        user.setPet(tomcatPet());
        return user;
    }

    @Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
