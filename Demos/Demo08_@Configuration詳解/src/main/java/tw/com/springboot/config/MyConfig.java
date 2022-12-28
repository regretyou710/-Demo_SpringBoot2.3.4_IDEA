package tw.com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tw.com.springboot.bean.Pet;
import tw.com.springboot.bean.User;

/**
 * 1、配置類里面使用@Bean標注在方法上給容器注冊組件，默認也是單實例的
 * 2、配置類本身也是組件
 * 3、proxyBeanMethods：代理bean的方法
 * Full(proxyBeanMethods = true)、【保證每個@Bean方法被調用多少次返回的組件都是單實例的】
 * Lite(proxyBeanMethods = false)【每個@Bean方法被調用多少次返回的組件都是新創建的】
 * 組件依賴必須使用Full模式默認。其他默認是否Lite模式
 * <p>
 * 4、@Import({User.class, DBHelper.class}):給容器中自動創建出這兩個類型的組件、默認組件的名字就是全類名
 * 5、@ImportResource("classpath:beans.xml"):導入Spring的配置文件
 */
@Configuration(proxyBeanMethods = false)//告诉SpringBoot这是一个配置类 == 配置文件
public class MyConfig {

    @Bean//給容器中添加組件。以方法名作為組件的id。返回類型就是組件類型。返回的值，就是組件在容器中的實例
    public User user01() {
        User user = new User("Tom", 18);
        //User組件依賴了Pet組件
        user.setPet(tomcatPet());
        return user;
    }

    @Bean("tom")//自訂組件id
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
