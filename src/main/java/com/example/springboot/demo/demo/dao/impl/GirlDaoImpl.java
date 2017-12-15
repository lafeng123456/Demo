package com.example.springboot.demo.demo.dao.impl;

import com.example.springboot.demo.demo.dao.GirlDao;
import com.example.springboot.demo.demo.domain.bean.Girl;
import com.example.springboot.demo.demo.domain.ro.GirlRo;
import com.example.springboot.demo.demo.domain.so.GirlSo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

public class GirlDaoImpl{

    @Autowired
    private SqlSession sqlSession;

    public List<GirlRo> getAll(String sqlId, GirlSo girlSo){
        List<GirlRo> girlList= sqlSession.selectList(sqlId,girlSo);
        return girlList;
    };

    public GirlRo getOne(String sqlId, GirlSo girlSo){
        GirlRo girlRo= sqlSession.selectOne(sqlId,girlSo);
        return girlRo;
    };

    public void create(String sqlId, Girl girl){
        sqlSession.insert(sqlId, girl);
    };

    public void update(String sqlId, Girl girl){
        sqlSession.update(sqlId, girl);
    };

    public void delete(String sqlId, Girl girl){
        sqlSession.delete(sqlId, girl);
    };

}
