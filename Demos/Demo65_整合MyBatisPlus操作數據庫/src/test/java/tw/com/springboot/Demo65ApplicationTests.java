package tw.com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.com.springboot.bean.User;
import tw.com.springboot.mapper.UserMapper;

@Slf4j
@SpringBootTest
class Demo65ApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testUserMapper() {
        User user = userMapper.selectById(1);
        log.info("用戶訊息:{}", user);
    }
}
