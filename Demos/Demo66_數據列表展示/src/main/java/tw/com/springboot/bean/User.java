package tw.com.springboot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@TableName("mybatisplus_user")
public class User implements Serializable {
    /**
     * 使用mybits plus時會要求類中的屬性與資料表欄位都要一致
     * 如果表中沒有欄位但類中有宣告屬性則可以使用@TableField(exist = false)
     */
    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String password;

    //以下是操作mybatis plus使用
    private Long id;
    private String name;
    private Integer age;
    private String email;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
