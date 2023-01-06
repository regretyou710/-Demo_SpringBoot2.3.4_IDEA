package tw.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.com.springboot.bean.Dept;
import tw.com.springboot.bean.User;
import tw.com.springboot.service.DeptService;
import tw.com.springboot.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;

    @Autowired
    DeptService deptService;

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

    @ResponseBody
    @RequestMapping("dept")
    public Dept getDeptById(@RequestParam("id") Integer id) {
        return deptService.getById(id);
    }

    @ResponseBody
    @PostMapping("dept")
    public Dept saveDept(Dept dept){
        deptService.saveDept(dept);
        return dept;
    }
}
