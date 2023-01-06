package tw.com.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tw.com.springboot.bean.User;

//@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getUser(Integer id);
}
