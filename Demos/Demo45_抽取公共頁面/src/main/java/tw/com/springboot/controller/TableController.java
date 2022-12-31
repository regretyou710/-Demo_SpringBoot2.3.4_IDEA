package tw.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table() {
        return "tables/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table() {
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
