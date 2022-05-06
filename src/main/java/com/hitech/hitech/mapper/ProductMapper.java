package com.hitech.hitech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hitech.hitech.pojo.Product;
import com.hitech.hitech.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
