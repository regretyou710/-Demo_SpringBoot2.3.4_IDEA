package tw.com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Demo61ApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        log.info("數據原類型:{}", dataSource.getClass());

        Integer rs = jdbcTemplate.queryForObject("select count(*) from help", Integer.class);
        log.info("查詢結果筆數:{}", rs);
    }

}
