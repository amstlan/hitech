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
public class CartController {

    @Autowired
    public ICartService iCartService;
    @Autowired
    private IProductService iProductService;
    @Autowired
    public CartMapper cartMapper;


    @RequestMapping("cart")
    public String cart(HttpSession session, Model model){
        Long uid = (Long) session.getAttribute("uid");
        if (uid == null){
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
            i++;
            Map<String,Object> map = new HashMap<>();
            map.put("cid", c.getCid());
            map.put("count",c.getCount());
            map.put("pid",one.getPid());
            map.put("name",one.getName());
            map.put("oldprice",one.getOldPrice());
            map.put("price",one.getPrice());
            map.put("size",one.getSize());
            map.put("color",one.getColor());
            map.put("image",one.getImage());

            i += c.getCount()*one.getPrice();
            mapList.add(map);
        }
        System.out.println("一共查询到"+i);

        model.addAttribute("money",i);
        model.addAttribute("mapList", mapList);

        return "cart";
    }

    @RequestMapping("/delete_cart")
    public String delete(Long cid){
        boolean b = iCartService.removeById(cid);
        if (b == false){
            System.out.println("删除失败");
        }
        return "redirect:/cart";
    }

    @RequestMapping("/add_cart")
    public String addCart(HttpSession session, Long pid,Integer count){

        if (count == null){
            count = 1;
        }

        Long uid = (Long) session.getAttribute("uid");
        Cart cart = new Cart();
        cart.setCount(count);
        cart.setPid(pid);
        cart.setUid(uid);

        boolean save = iCartService.save(cart);

        if (save == true){
            System.out.println("添加成功");
        }
        return "redirect:/cart";
    }
}
