package com.hitech.hitech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hitech.hitech.pojo.Cart;
import com.hitech.hitech.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {

}
