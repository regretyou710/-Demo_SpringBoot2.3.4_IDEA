package tw.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tw.com.springboot.bean.User;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping(value = {"/", "login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("login")
    public String main(User user, HttpSession session, Model model) {

        if (StringUtils.hasLength(user.getUserName()) && "0000".equals(user.getPassword())) {
            session.setAttribute("loginUser", user);

            //重定向;防止表單重複提交
            return "redirect:main.html";
        } else {
            model.addAttribute("msg", "帳號密碼錯誤!");
            return "login";
        }
    }

    @GetMapping("main.html")
    public String mainPage(HttpSession session, Model model) {
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null) {
//            return "main";
//        } else {
//            model.addAttribute("msg", "用戶未登入,請重新登入!");
//            return "login";
//        }

        return "main";
    }
}
