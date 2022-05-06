package com.hitech.hitech.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Objects;


public class Shop {

    @TableId("sid")
    private Long sid;
    private Long uid;
    private Long pid;
    private Integer count;
    private Long aid;

    @Override
    public String toString() {
        return "Shop{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", count=" + count +
                ", aid=" + aid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;
        Shop shop = (Shop) o;
        return Objects.equals(getSid(), shop.getSid()) &&
                Objects.equals(getUid(), shop.getUid()) &&
                Objects.equals(getPid(), shop.getPid()) &&
                Objects.equals(getCount(), shop.getCount()) &&
                Objects.equals(getAid(), shop.getAid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSid(), getUid(), getPid(), getCount(), getAid());
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }
}
