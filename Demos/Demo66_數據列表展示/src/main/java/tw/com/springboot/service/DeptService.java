package tw.com.springboot.service;

import tw.com.springboot.bean.Dept;

public interface DeptService {
    Dept getById(Integer id);

    void saveDept(Dept dept);
}
