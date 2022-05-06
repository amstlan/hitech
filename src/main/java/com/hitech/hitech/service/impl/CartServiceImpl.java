package com.hitech.hitech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hitech.hitech.mapper.CartMapper;
import com.hitech.hitech.mapper.UserMapper;
import com.hitech.hitech.pojo.Cart;
import com.hitech.hitech.pojo.User;
import com.hitech.hitech.service.ICartService;
import com.hitech.hitech.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {
}
