package com.hitech.hitech.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hitech.hitech.mapper.CartMapper;
import com.hitech.hitech.pojo.Cart;
import com.hitech.hitech.pojo.Product;
import com.hitech.hitech.service.ICartService;
import com.hitech.hitech.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    public ICartService iCartService;
    @Autowired
    private IProductService iProductService;
    @Autowired
    public CartMapper cartMapper;

    @RequestMapping(value = {"/", "/index"})
    public String index(HttpSession session, Model model){
        Long uid = (Long) session.getAttribute("uid");
        if (uid == null){

            QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();
            productQueryWrapper.last("limit 8").orderByDesc("hot");
            List<Product> productList1list = iProductService.list(productQueryWrapper);
            System.out.println(productList1list);
            model.addAttribute("produces",productList1list);


            productQueryWrapper.last("limit 3").orderByDesc("hot");
            List<Product> productList3 = iProductService.list(productQueryWrapper);


            productQueryWrapper.last("limit 3").orderByAsc("hot");
            List<Product> productList32 = iProductService.list(productQueryWrapper);


            List<List<Product>> lists = new ArrayList<>();
            lists.add(productList3);
            lists.add(productList32);
            model.addAttribute("lists",lists);

            return "index";
        }

        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        List<Cart> list = cartMapper.selectList(queryWrapper);
        List<Integer> countList = new ArrayList<>();


        List<Product> productList = new ArrayList<>();
        List<Map<String,Object>> mapList = new ArrayList<>();

int i = 0;
        for (Cart c : list){
            Integer count = c.getCount();
            countList.add(count);

            Long pid = c.getPid();
            QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();
            productQueryWrapper.eq("pid", pid);
            Product one = iProductService.getOne(productQueryWrapper);
            productList.add(one);
            Map<String,Object> map = new HashMap<>();
            map.put("count",c.getCount());
            map.put("name",one.getName());
            map.put("price",one.getPrice());
            map.put("image",one.getImage());
            mapList.add(map);
            i += c.getCount()*one.getPrice();
        }

        model.addAttribute("money",i);
        model.addAttribute("mapList", mapList);


        return "index";
    }

@RequestMapping("teat")
    public String test(){
        return "teat";
}

@RequestMapping("/about-us")
    public String about(){
        return "about-us";
}

}
