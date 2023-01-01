package tw.com.springboot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tw.com.springboot.filter.MyFilter;
import tw.com.springboot.listener.MyListener;
import tw.com.springboot.servlet.MyServlet;

import java.util.Arrays;

@Configuration//(proxyBeanMethods = true)//保證依賴的組件始終是單實例
public class MyRegistConfig {
    @Bean
    public ServletRegistrationBean myServlet() {
        return new ServletRegistrationBean(new MyServlet(), "/servlet1");
    }

    @Bean
    public FilterRegistrationBean myfilter() {
        MyFilter myFilter = new MyFilter();

        //過濾servlet
        //return new FilterRegistrationBean(myFilter, myServlet());

        //過濾url patterns
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/servlet1"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        return new ServletListenerRegistrationBean(new MyListener());
    }
}
