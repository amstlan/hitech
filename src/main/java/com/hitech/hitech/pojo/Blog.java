package com.hitech.hitech.pojo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
import java.util.Objects;

public class Blog {
    @TableId("bid")
    private Long bid;
    private String title;
    private String author;
    private String test;
    private String imge;
    private Date date;

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", test='" + test + '\'' +
                ", imge='" + imge + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blog)) return false;
        Blog blog = (Blog) o;
        return Objects.equals(getBid(), blog.getBid()) &&
                Objects.equals(getTitle(), blog.getTitle()) &&
                Objects.equals(getAuthor(), blog.getAuthor()) &&
                Objects.equals(getTest(), blog.getTest()) &&
                Objects.equals(getImge(), blog.getImge()) &&
                Objects.equals(getDate(), blog.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBid(), getTitle(), getAuthor(), getTest(), getImge(), getDate());
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getImge() {
        return imge;
    }

    public void setImge(String imge) {
        this.imge = imge;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
