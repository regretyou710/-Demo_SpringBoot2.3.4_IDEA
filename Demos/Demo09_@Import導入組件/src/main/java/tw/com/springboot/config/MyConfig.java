package tw.com.springboot.config;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tw.com.springboot.bean.Pet;
import tw.com.springboot.bean.User;

/**
 * @Import({User.class, DBHelper.class}):給容器中自動創建出這兩個類型的組件、默認組件的名字就是全類名
 * 可標示在配置類或容器中的組件
 */
@Import({User.class, DBHelper.class})
@Configuration
public class MyConfig {

    @Bean
    public User user01() {
        User user = new User("Tom", 18);
        //User組件依賴了Pet組件
        user.setPet(tomcatPet());
        return user;
    }

    @Bean
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
