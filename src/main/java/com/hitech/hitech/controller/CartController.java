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


    /**
     * 转跳购物车界面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("cart")
    public String cart(HttpSession session, Model model){
        //通过session获取用户uid
        Long uid = (Long) session.getAttribute("uid");

        //根据用户uid查询在数据库中所有的订单
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        List<Cart> list = cartMapper.selectList(queryWrapper);
        //放每个商品的价格
        List<Integer> countList = new ArrayList<>();

        //返回前端的所有数据都放到list集合
        List<Map<String,Object>> mapList = new ArrayList<>();

        //计算购物车总价
        int i = 0;
        //将刚刚查出来的订单list集合中，本别根据里面的数据获取各个商品的信息
        for (Cart c : list){
            //单个商品的价格
            Integer count = c.getCount();
            countList.add(count);

            //从购物车表中读取商品的pid
            Long pid = c.getPid();
            //根据pid查询商品信息
            QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();
            productQueryWrapper.eq("pid", pid);
            Product one = iProductService.getOne(productQueryWrapper);

            //创建存放一栏数据的map
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

            //加上当前商品价格
            i += c.getCount()*one.getPrice();
            //添加到返回前端的list中
            mapList.add(map);
        }


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
