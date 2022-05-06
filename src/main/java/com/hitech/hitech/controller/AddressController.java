package com.hitech.hitech.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hitech.hitech.pojo.Address;
import com.hitech.hitech.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressController {

    @Autowired
    private IAddressService iAddressService;

    @RequestMapping("/address")
    public String address() {
        return "address";
    }


    @RequestMapping("/add_address")
    public String addAddress(HttpSession session, Address address) {
        address.setUid((Long) session.getAttribute("uid"));
        iAddressService.save(address);
        return "redirect:/address";
    }

    @RequestMapping("/select_address")
    public String selectAddress(HttpSession session, Model model) {
        //获取当前用户uid
        Long uid = (Long) session.getAttribute("uid");

        //通过uid查询该用户下所有收货地址
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        List<Address> list = iAddressService.list(queryWrapper);

        model.addAttribute("list", list);


        return "select_address";
    }

    @RequestMapping("select_shop_address")
    public String selectShopAddress(HttpSession session,Model model, Long[] pid, Integer count){

        if (pid == null){
            return "cart";
        }

        //获取当前用户uid
        Long uid = (Long) session.getAttribute("uid");

        //通过uid查询该用户下所有收货地址
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        List<Address> list = iAddressService.list(queryWrapper);


        //将需要的数据放到请求中
        model.addAttribute("list", list);
        List<Long> longs = new ArrayList<>();
        for (Long l : pid) {
            longs.add(l);
        }
        model.addAttribute("pid",longs);

        model.addAttribute("count",count);

        return "select_shop_address";
    }
    @RequestMapping("delete_address")
    public String delete(Long aid) {
        iAddressService.removeById(aid);
        return "redirect:/select_address";
    }

    @RequestMapping("update_address")
    public String update(Long aid,Model model) {
        Address address = iAddressService.getById(aid);
        model.addAttribute("address", address);
        return "update_address";

    }

    @RequestMapping("/update_address_go")
    public String updateNow(Address address) {
        iAddressService.saveOrUpdate(address);
        return "redirect:/select_address";

    }

}
