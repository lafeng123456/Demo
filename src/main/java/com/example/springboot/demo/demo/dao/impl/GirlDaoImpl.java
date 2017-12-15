package com.example.springboot.demo.demo.dao.impl;

import com.example.springboot.demo.demo.dao.GirlDao;
import com.example.springboot.demo.demo.domain.bean.Girl;
import com.example.springboot.demo.demo.domain.ro.GirlRo;
import com.example.springboot.demo.demo.domain.so.GirlSo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dao实现类(暂不用，所以没有具体实现接口)
 * @author <a href="mailto:617095443@qq.com">zhuguofeng</a>
 */
public class GirlDaoImpl{

    @Autowired
    //Sql会话工厂
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
