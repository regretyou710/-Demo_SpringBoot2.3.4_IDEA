package tw.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tw.com.springboot.bean.User;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table() {
        return "tables/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        //表格內容的遍歷
        List<User> users = Arrays.asList(new User("Tom", "tom"),
                new User("Eason", "eason"),
                new User("admin", "0000"));
        model.addAttribute("users", users);

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
