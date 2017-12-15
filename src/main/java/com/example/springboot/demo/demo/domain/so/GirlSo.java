package com.example.springboot.demo.demo.domain.so;

import java.io.Serializable;

public class GirlSo implements Serializable{

    /** 主键id */
    private  Long id;

    /** 页码 */
    private Integer pageIndex;

    /** 每页数据量 */
    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
