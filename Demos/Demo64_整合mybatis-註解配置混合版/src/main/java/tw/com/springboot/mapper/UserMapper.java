package tw.com.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import tw.com.springboot.bean.User;

@Mapper
public interface UserMapper {
    User getUser(Integer id);
}
