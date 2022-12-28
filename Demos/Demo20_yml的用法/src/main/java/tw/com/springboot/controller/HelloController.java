package tw.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.springboot.bean.Person;

@RestController
public class HelloController {
    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person() {
        String userName = person.getUserName();
        System.out.println(userName);
        return person;
    }
}

