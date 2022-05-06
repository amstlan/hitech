package com.hitech.hitech.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hitech.hitech.pojo.Address;
import com.hitech.hitech.pojo.Cart;
import com.hitech.hitech.pojo.Product;
import com.hitech.hitech.pojo.Shop;
import com.hitech.hitech.service.ICartService;
import com.hitech.hitech.service.IProductService;
import com.hitech.hitech.service.IShopService;
import com.hitech.hitech.utils.IsBuy;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class ShopController {

    @Autowired
    private IShopService iShopService;

    @Autowired
    private ICartService iCartService;

    @Autowired
    private IProductService iProductService;

    @RequestMapping("/addShop")
    public String addShop(HttpSession session, Long aid, Long[] pid, Integer count){
        if (aid == null){
            return "select_shop_address";
        }

        //获取用户的id
        Long uid = (Long) session.getAttribute("uid");

        for (Long l : pid){
            Shop shop = new Shop();
            shop.setAid(aid);
            shop.setPid(l);
            shop.setUid(uid);
            shop.setCount(0);
            System.out.println("---------"+shop);
            iShopService.save(shop);

            //创建一个线程假装商家在发货
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    try {
                        TimeUnit.SECONDS.sleep(10);

                        shop.setCount(1);
                        System.out.println("商家发货成功");
                        iShopService.updateById(shop);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
        }

        return "redirect:/order";
    }



    @RequestMapping("/order")
    public String order(HttpSession session, Model model){
        Long uid = (Long) session.getAttribute("uid");

        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("uid",uid);

        List<Shop> list = iShopService.list(queryWrapper);

        model.addAttribute("list", list);

        List<Product> productList  = new ArrayList<>();
        List<Map<String,Object>> mapList = new ArrayList<>();
        Integer money = 0;
        for (Shop shop : list){
            Long pid = shop.getPid();
            Product one = iProductService.getById(pid);

            QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
            cartQueryWrapper.eq("pid",pid).eq("uid",uid);
            Cart cart = iCartService.getOne(cartQueryWrapper);

            Map<String,Object> map = new HashMap<>();

            map.put("sid", shop.getSid());
            map.put("isbuy",shop.getCount());
            map.put("count",cart.getCount());
            map.put("pid",one.getPid());
            map.put("name",one.getName());
            map.put("oldprice",one.getOldPrice());
            map.put("price",one.getPrice());
            map.put("size",one.getSize());
            map.put("color",one.getColor());
            map.put("image",one.getImage());
            money += one.getPrice();
            mapList.add(map);
        }

        model.addAttribute("mapList",mapList);
        model.addAttribute("money",money);

        return "order";
    }


    @RequestMapping("/delete_order")
    public String delete(Long sid){
        iShopService.removeById(sid);
        return "redirect:/order";
    }

    @RequestMapping("/bacth_delelt")
    public String bacth(Long[] sid){
        for (Long s : sid){
            iShopService.removeById(s);
        }
        return "redirect:/order";
    }
}
