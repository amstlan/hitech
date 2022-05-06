package com.hitech.hitech.pojo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Objects;

public class Cart {
    @TableId("cid")
    private Long cid;
    private Long uid;
    private Long pid;
    private Integer count;

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(getCid(), cart.getCid()) &&
                Objects.equals(getUid(), cart.getUid()) &&
                Objects.equals(getPid(), cart.getPid()) &&
                Objects.equals(getCount(), cart.getCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCid(), getUid(), getPid(), getCount());
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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
}
