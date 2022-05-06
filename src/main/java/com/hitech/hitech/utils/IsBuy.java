package com.hitech.hitech.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hitech.hitech.pojo.Shop;
import com.hitech.hitech.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class IsBuy extends Thread {

    @Autowired
    private IShopService iShopService;

    private  Long sid;


    @Override
    public void run() {
        super.run();

        try {
            TimeUnit.SECONDS.sleep(10);
            UpdateWrapper<Shop> updateWrapper = new UpdateWrapper<>();
            updateWrapper.set("count",1);
            System.out.println("商家发货成功");
            iShopService.update(updateWrapper);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
