package com.hitech.hitech.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hitech.hitech.pojo.User;
import com.hitech.hitech.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    /**
     * 转跳注册页面
     * @param model 存放返回的提示信息
     * @return
     */
    @RequestMapping("/registration")
    public String reghtml( Model model){
        model.addAttribute("msg","请输入注册信息");
        return "registration";
    }
    //转跳登录界面
    @RequestMapping("/login")
    public String loginhtml(){
        return "login";
    }

    /**
     * 登录
     * @param email 邮箱
     * @param password 密码
     * @param model 返回提示信息
     * @param session 存放用户的uid和firstname
     * @return
     */
    @RequestMapping("log")
    public String login(String email, String password, Model model, HttpSession session){
        System.out.println("email "+email +" password "+password );
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        User one = iUserService.getOne(queryWrapper);
        if (one == null){
            model.addAttribute("msg","用户不存在");
            return "login";
        }

        if (!one.getPassword().equals(password)){
            model.addAttribute("msg","密码不正确");
            return "login";
        }

        session.setAttribute("uid",one.getUid());
        session.setAttribute("firstName",one.getFirstName());
        session.setAttribute("power",one.getPower());

        return "redirect:/index";
    }

    /**
     * 注册
     * @param user 用户信息实体类
     * @param model 返回提示信息
     * @return
     */
    @RequestMapping("/reg")
    public String reg(User user, Model model){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("first_name", user.getFirstName());
        User one = iUserService.getOne(queryWrapper);
        if (one != null){
            model.addAttribute("msg","用户名存在");
            return "registration";
        }

        boolean save = iUserService.save(user);
        if (save == false){
            model.addAttribute("msg","添加用户失败");
            return "registration";
        }
        return "login";
    }

    /**
     * 转跳修改信息界面
     * @param session 获取当前用户uid
     * @param model 返回用户目前的信息
     * @return
     */
    @RequestMapping("/checkout")
    public String checkout(HttpSession session,Model model){
        //回去当前用户的uid
        Long uid = (Long) session.getAttribute("uid");

        //根据uid查询用户信息
        User user = iUserService.getById(uid);

        //将用户信息返回
        model.addAttribute("user",user);

        return "checkout";
    }

    @RequestMapping("/update_checkout")
    public String updateUserInfo(User user,HttpSession session){
        //回去当前用户的uid
        Long uid = (Long) session.getAttribute("uid");

        //将uid放到获取的user中
        user.setUid(uid);

        //修改信息
        boolean res = iUserService.updateById(user);

        if (res == false){
            System.out.println("修改失败");
        }
        return "redirect:/checkout";
    }

}
