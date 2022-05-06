package com.hitech.hitech.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hitech.hitech.pojo.Product;
import com.hitech.hitech.service.IProductService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;


    @RequestMapping("/shop-left-sidebar")
    public String shop(Model model,Integer current,Integer min, Integer max, String[] color, String[] size, String[] brand){
        if(current == null){
            current = 1;
        }

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (min != null){
            queryWrapper.ge("price", min);
        }if (max != null){
            queryWrapper.le("price", max);
        }if (color != null){
            List<String> list = new ArrayList<>();
            for (String c : color){
                list.add(c);
            }
            queryWrapper.in("color", list);
        }if (size != null){
            List<String> list = new ArrayList<>();
            for (String c : size)
                list.add(c);
            queryWrapper.in("size", list);
        }if (brand != null){
            List<String> list = new ArrayList<>();
            for (String c : brand)
                list.add(c);

            queryWrapper.in("brand", list);
        }

        Page<Product> page = new Page<>(current, 8);

        IPage<Product> iPage = iProductService.page(page,queryWrapper);

        model.addAttribute("iPage",iPage);

        System.out.println(iPage);
        return "shop-left-sidebar";
    }

    @RequestMapping("single-product")
    public String single(Model model,Long pid){


        Product product = iProductService.getById(pid);

        model.addAttribute("product",product);

        return "single-product";
    }


    @RequestMapping("/wishlist")
    public String wishlist(String name,Model model){
        //模糊查询
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        List<Product> list = iProductService.list(queryWrapper);

        //返回查询结果
        model.addAttribute("list", list);

        return "wishlist";
    }

    //文件上传最大值
    public static final int  AVATAR_MAX_SIZE = 10 *1024 * 1024;

    //文件上传类型
    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    //静态代码块自动加载
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");

    }
    @RequestMapping("upload")
    public String uploadProduct(){


        return "upload";
    }
    public final static String UPLOAD_PATH_PREFIX = "assets/img/product/";

    @RequestMapping("/upfile")
    public String uploadProductFile(HttpSession session,  MultipartFile uploadFile, Product product, HttpServletRequest request) throws Exception {


        // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）

            if(uploadFile.isEmpty()){
                //返回选择文件提示
                return "请选择上传文件";
            }

            //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
            String realPath = new String("src/main/resources/static/" + UPLOAD_PATH_PREFIX);

            //存放上传文件的文件夹
            File file = new File(realPath);
             if(!file.isDirectory()){
                //递归生成文件夹
                file.mkdirs();
            }
            //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
            String oldName = uploadFile.getOriginalFilename();

            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());

            try {
                //构建真实的文件路径
                File newFile = new File(file.getAbsolutePath() + File.separator + newName);
                //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
                uploadFile.transferTo(newFile);
                String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()  + newName;

            } catch (Exception e) {
                e.printStackTrace();
            }


            String savePath = UPLOAD_PATH_PREFIX+newName;

            product.setImage(savePath);
            iProductService.save(product);
        return "redirect:/upload";
    }

}
