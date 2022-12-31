package tw.com.springboot.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private String userName;
    private String password;
}
