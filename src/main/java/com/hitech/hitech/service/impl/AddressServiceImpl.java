package com.hitech.hitech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hitech.hitech.mapper.AddressMapper;
import com.hitech.hitech.mapper.BlogMapper;
import com.hitech.hitech.pojo.Address;
import com.hitech.hitech.pojo.Blog;
import com.hitech.hitech.service.IAddressService;
import com.hitech.hitech.service.IBlogService;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {
}
