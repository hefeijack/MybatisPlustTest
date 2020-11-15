package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Mpdemo1010ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void findAll(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setAge(2);
        user.setName("岳不群");
        user.setEmail("111@qq.com");
        int insert = userMapper.insert(user);
    }

    @Test
    public void updateUser(){

        User user = new User();
        user.setId(1327937588341862405L);
        user.setName("jack222");
        user.setAge(333);

        int i = userMapper.updateById(user);
    }

    @Test
    public void testOptimisticLocker(){

        User user = userMapper.selectById(1327937588341862406L);
        user.setAge(555);
        userMapper.updateById(user);
    }

    @Test
    public void testSelectDemo1(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);
    }

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1, 3);
        IPage<User> userIPage = userMapper.selectPage(page, null);

        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
        System.out.println(page.getSize());
    }

    @Test
    public void testDelete(){
        int i = userMapper.deleteById(1327937588341862407L);
    }

}
