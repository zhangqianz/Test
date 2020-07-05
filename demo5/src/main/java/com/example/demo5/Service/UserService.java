package com.example.demo5.Service;

import com.example.demo5.Mapper.UserMapper;
import com.example.demo5.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public List findALL(){
        List user= userMapper.selectAll();
        return user;
    }

    @Transactional
    public User findById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void insert(User user){
        userMapper.insert(user);
    }

    @Transactional
    public void delete(User user){
        userMapper.delete(user);
    }

    @Transactional
    public void update(User user){
        userMapper.updateByPrimaryKey(user);
    }

    @Transactional
    public User equal(User user){
      return userMapper.selectOne(user);
    }

}
