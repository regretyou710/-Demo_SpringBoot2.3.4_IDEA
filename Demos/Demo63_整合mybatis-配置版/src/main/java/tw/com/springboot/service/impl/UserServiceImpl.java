package tw.com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.com.springboot.bean.User;
import tw.com.springboot.mapper.UserMapper;
import tw.com.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }
}
