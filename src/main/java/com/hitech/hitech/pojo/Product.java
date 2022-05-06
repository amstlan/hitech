package com.hitech.hitech.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Objects;

@TableName("product")
public class Product {

    @TableId("pid")
    private Long pid;
    private String name;
    private String color;
    private String brand;
    private String size;
    private String image;
    private Integer price;
    @TableField("old_price")
    private Integer oldPrice;
    private Integer sku;
    @TableField("product_describe")
    private String productDescribe;
    private Integer hot;

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", size='" + size + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", sku=" + sku +
                ", productDescribe='" + productDescribe + '\'' +
                ", hot=" + hot +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getPid(), product.getPid()) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getColor(), product.getColor()) &&
                Objects.equals(getBrand(), product.getBrand()) &&
                Objects.equals(getSize(), product.getSize()) &&
                Objects.equals(getImage(), product.getImage()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                Objects.equals(getOldPrice(), product.getOldPrice()) &&
                Objects.equals(getSku(), product.getSku()) &&
                Objects.equals(getProductDescribe(), product.getProductDescribe()) &&
                Objects.equals(getHot(), product.getHot());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPid(), getName(), getColor(), getBrand(), getSize(), getImage(), getPrice(), getOldPrice(), getSku(), getProductDescribe(), getHot());
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}