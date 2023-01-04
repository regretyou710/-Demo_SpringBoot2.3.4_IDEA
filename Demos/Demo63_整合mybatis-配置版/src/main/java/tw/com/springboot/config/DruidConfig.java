package tw.com.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Deprecated
//@Configuration
public class DruidConfig {

    @ConfigurationProperties("spring.datasource")//告訴SpringBoot將本類(DruidDataSource)中的所有屬性和配置文件中相關的配置進行綁定
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
//        druidDataSource.setUrl();
//        druidDataSource.setDriverClassLoader();

        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    /**
     * 配置監控頁面
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//        servletRegistrationBean.addInitParameter("deny", "192.168.50.103");//表示拒絕訪問
//        servletRegistrationBean.addInitParameter("allow", "localhost");//表示只有localhost能訪問
//        servletRegistrationBean.addInitParameter("allow", "");//默認就是允許所有訪問

        return servletRegistrationBean;
    }

    /**
     * 配置採集web-jdbc關聯監控的數據
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("initParams", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        DruidStatInterceptor dsInterceptor = new DruidStatInterceptor();
        return dsInterceptor;
    }

    @Bean
    @Scope("prototype")
    public JdkRegexpMethodPointcut druidStatPointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern("tw.com.springboot.*");
//        pointcut.setPattern("tw.com.springboot.service.*");
//        pointcut.setPattern("tw.com.springboot.dao.*");
        return pointcut;
    }

    @Bean
    public DefaultPointcutAdvisor druidStatAdvisor(DruidStatInterceptor druidStatInterceptor, JdkRegexpMethodPointcut druidStatPointcut) {
        DefaultPointcutAdvisor defaultPointAdvisor = new DefaultPointcutAdvisor();
        defaultPointAdvisor.setPointcut(druidStatPointcut);
        defaultPointAdvisor.setAdvice(druidStatInterceptor);
        return defaultPointAdvisor;
    }
}
