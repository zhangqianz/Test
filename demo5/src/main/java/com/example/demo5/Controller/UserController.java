package com.example.demo5.Controller;

import com.example.demo5.Service.UserService;
import com.example.demo5.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //查询单个
    @GetMapping("{id}")
    public User findById(@PathVariable("id") Integer id){
       return userService.findById(id);
    }

    //查询所有
    @GetMapping("/all")
    public List findAll(){
        List list=userService.findALL();
      return list;
    }

    //添加用户
    @PutMapping("/add/user")
    @ResponseBody
    public void insert(User user){
        userService.insert(user);
    }

    //删除用户
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Integer id){
        User user=findById(id);
        userService.delete(user);
    }

    //修改用户
    @PutMapping("update/{id}/user")
    @ResponseBody
    public void update(User user){
        userService.update(user);
    }

}
