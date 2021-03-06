package com.example.demo5.Controller;


import com.example.demo5.Service.UserService;
import com.example.demo5.conStant.Constant;
import com.example.demo5.pojo.User;
import com.example.demo5.untils.JwtUtil;
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

    @GetMapping("/login")
    @ResponseBody
    public void equal(User user) throws Exception {
      User user1= userService.equal(user);
      if (user1==null){
          System.out.println("该用户不存在或者密码输入错误。。。。。。。。。。。");
      }else if (user.getUsername().equals(user1.getUsername())&user.getPassword().equals(user1.getPassword())){
          System.out.println("登陆成功。。。。。。");
          String jwt=JwtUtil.createJWT(Constant.JWT_ID,JwtUtil.generalSubject(user1),Constant.JWT_TTL);
          System.out.println(jwt);
      }
    }
}
