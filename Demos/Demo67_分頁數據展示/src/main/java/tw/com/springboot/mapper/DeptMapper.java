package tw.com.springboot.mapper;

import org.apache.ibatis.annotations.*;
import tw.com.springboot.bean.Dept;

//@Mapper
public interface DeptMapper {
    @Select("select * from springboot_dept where id = #{id}")
    Dept getById(Integer id);

    @Insert("insert into springboot_dept values(#{id}, #{deptName})")
    @Options(useGeneratedKeys = false, keyProperty = "id")
    @SelectKey(keyProperty = "id", resultType = String.class, before = true, statement = "select t_user_seq.nextval as id from dual")
    void insert(Dept dept);
}
