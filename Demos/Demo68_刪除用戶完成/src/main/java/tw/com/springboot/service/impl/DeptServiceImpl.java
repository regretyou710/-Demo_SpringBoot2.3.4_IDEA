package tw.com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.com.springboot.bean.Dept;
import tw.com.springboot.mapper.DeptMapper;
import tw.com.springboot.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void saveDept(Dept dept) {
        deptMapper.insert(dept);
    }
}
