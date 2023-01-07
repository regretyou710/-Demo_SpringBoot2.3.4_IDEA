package tw.com.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tw.com.springboot.bean.User;

public interface UserService extends IService<User> {
    User getUser(Integer id);
}
