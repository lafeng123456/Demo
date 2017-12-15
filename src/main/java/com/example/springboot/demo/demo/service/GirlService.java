package com.example.springboot.demo.demo.service;

import com.example.springboot.demo.demo.domain.bean.Girl;
import com.example.springboot.demo.demo.domain.ro.GirlRo;
import com.example.springboot.demo.demo.domain.so.GirlSo;

import java.util.List;

public interface GirlService {

    /**
     * 创建
     * @param girl
     */
    public void createGirl(Girl girl);

    /**
     * 查询
     * @param so
     * @return
     */
    public GirlRo queryOneGirl(GirlSo so);

    /**
     * 修改
     * @param girl
     */
    public void updateGirl(Girl girl);

    /**
     * 删除
     * @param girl
     */
    public void deleteGirl(Girl girl);

    /**
     *
     * 查询列表
     * @param so
     * @return
     */
    public List<GirlRo> queryAllGirl(GirlSo so);
}
