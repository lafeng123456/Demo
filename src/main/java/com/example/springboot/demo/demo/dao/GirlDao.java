package com.example.springboot.demo.demo.dao;


import com.example.springboot.demo.demo.domain.bean.Girl;
import com.example.springboot.demo.demo.domain.ro.GirlRo;
import com.example.springboot.demo.demo.domain.so.GirlSo;

import java.util.List;

/**
 * Dao
 * * @author <a href="mailto:617095443@qq.com">zhuguofeng</a>
 */
public interface GirlDao {

    /**
     * 查询全部
     * @param girlSo
     * @return
     */
    public List<GirlRo> getAll(GirlSo girlSo);

    /**
     * 查询单个
     * @param girlSo
     * @return
     */
    public GirlRo getOne(GirlSo girlSo);

    /**
     * 创建
     * @param girl
     */
    public void create(Girl girl);

    /**
     * 修改
     * @param girl
     */
    public void update(Girl girl);

    /**
     * 删除
     * @param girl
     */
    public void delete(Girl girl);
}
