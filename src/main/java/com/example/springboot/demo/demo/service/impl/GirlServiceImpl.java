package com.example.springboot.demo.demo.service.impl;

import com.example.springboot.demo.demo.dao.GirlDao;
import com.example.springboot.demo.demo.domain.bean.Girl;
import com.example.springboot.demo.demo.domain.ro.GirlRo;
import com.example.springboot.demo.demo.domain.so.GirlSo;
import com.example.springboot.demo.demo.service.GirlService;
import com.example.springboot.demo.demo.util.GirlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("girlService")
public class GirlServiceImpl implements GirlService{

    @Resource
    private GirlDao girlDao;

    /**
     * 创建
     * @param girl
     */
    public void createGirl(Girl girl){
        girlDao.create(girl);
    };

    /**
     * 查询
     * @param so
     * @return
     */
    public GirlRo queryOneGirl(GirlSo so){
        return girlDao.getOne(so);
    };

    /**
     * 修改
     * @param girl
     */
    public void updateGirl(Girl girl){
        girlDao.update(girl);
    };

    /**
     * 删除
     * @param girl
     */
    public void deleteGirl(Girl girl){
        girlDao.delete(girl);
    };

    /**
     *
     * 查询列表
     * @param so
     * @return
     */
    public List<GirlRo> queryAllGirl(GirlSo so){
        return girlDao.getAll(so);
    };

}
