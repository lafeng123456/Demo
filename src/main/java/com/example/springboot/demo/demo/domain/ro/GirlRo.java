package com.example.springboot.demo.demo.domain.ro;

import java.io.Serializable;

public class GirlRo implements Serializable{

    /** 主键id */
    private Long id;

    /** 年龄 */
    private Integer age;

    /** Size */
    private String cupSize;

    /** money */
    private Integer money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
