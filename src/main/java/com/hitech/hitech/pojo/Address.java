package com.hitech.hitech.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Objects;

public class Address {

    @TableId("aid")
    private Long aid;
    private Long uid;
    private String country;
    private String province;
    private String city;
    private String area;
    @TableField("post_code")
    private String postCode;
    @TableField("detailed_address")
    private String detailedAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getAid(), address.getAid()) &&
                Objects.equals(getUid(), address.getUid()) &&
                Objects.equals(getCountry(), address.getCountry()) &&
                Objects.equals(getProvince(), address.getProvince()) &&
                Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getArea(), address.getArea()) &&
                Objects.equals(getPostCode(), address.getPostCode()) &&
                Objects.equals(getDetailedAddress(), address.getDetailedAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAid(), getUid(), getCountry(), getProvince(), getCity(), getArea(), getPostCode(), getDetailedAddress());
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", postCode='" + postCode + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                '}';
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }
}
