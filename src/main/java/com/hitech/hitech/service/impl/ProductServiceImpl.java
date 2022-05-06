package com.hitech.hitech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hitech.hitech.mapper.ProductMapper;
import com.hitech.hitech.mapper.UserMapper;
import com.hitech.hitech.pojo.Product;
import com.hitech.hitech.pojo.User;
import com.hitech.hitech.service.IProductService;
import com.hitech.hitech.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
}
