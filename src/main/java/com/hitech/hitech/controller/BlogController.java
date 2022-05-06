package com.hitech.hitech.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hitech.hitech.pojo.Blog;
import com.hitech.hitech.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;
    @RequestMapping("/blog")
    public String blog(Model model){
        List<Blog> list = iBlogService.list();
        model.addAttribute("list",list);
        return "blog";
    }

    @RequestMapping("/single-blog")
    public String singleBlog(Long bid, Model model){
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        Blog blob = iBlogService.getById(bid);
        model.addAttribute("item", blob);
        return "single-blog";
    }

}
