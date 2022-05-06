package com.hitech.hitech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hitech.hitech.mapper.BlogMapper;
import com.hitech.hitech.mapper.ShopMapper;
import com.hitech.hitech.pojo.Blog;
import com.hitech.hitech.pojo.Shop;
import com.hitech.hitech.service.IBlogService;
import com.hitech.hitech.service.IShopService;
import org.springframework.stereotype.Service;


@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {
}
