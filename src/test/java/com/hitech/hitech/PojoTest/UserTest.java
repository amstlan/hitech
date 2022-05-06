package com.hitech.hitech.PojoTest;

import com.baomidou.mybatisplus.annotation.TableId;
import com.hitech.hitech.pojo.User;
import com.hitech.hitech.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
public class UserTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private IUserService iUserService;

    @Test
    public void inserUser(){
        User user = new User();
        user.setFirstName("zhangsan");
        iUserService.save(user);
    }


}
