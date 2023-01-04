package tw.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.com.springboot.bean.User;
import tw.com.springboot.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/query")
    public Map<String, Object> query() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from help");
        return list.get(0);
    }

    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser(@RequestParam("id") Integer id) {
        return userService.getUser(id);
    }
}
