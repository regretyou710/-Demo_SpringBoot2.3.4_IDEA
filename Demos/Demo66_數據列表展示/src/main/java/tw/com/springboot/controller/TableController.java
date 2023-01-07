package tw.com.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tw.com.springboot.bean.User;
import tw.com.springboot.service.UserService;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
        return "tables/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model, @RequestParam(value = "a", defaultValue = "1") Integer pageNum) {
        //表格內容的遍歷
//        List<User> users = Arrays.asList(new User("Tom", "tom"),
//                new User("Eason", "eason"),
//                new User("admin", "0000"));
//        model.addAttribute("users", users);

//        List<User> users = userService.list();
//        model.addAttribute("users", users);

//        分頁查詢數據
        Page<User> userPage = new Page<>(pageNum, 2);
//        分頁查詢結果
        userService.page(userPage, null);
        model.addAttribute("page", userPage);

        return "tables/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "tables/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table() {
        return "tables/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "tables/responsive_table";
    }
}
