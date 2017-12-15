package com.example.springboot.demo.demo.dao;


import com.example.springboot.demo.demo.domain.bean.Girl;
import com.example.springboot.demo.demo.domain.ro.GirlRo;
import com.example.springboot.demo.demo.domain.so.GirlSo;

import java.util.List;
public interface GirlDao {

    public List<GirlRo> getAll(GirlSo girlSo);

    public GirlRo getOne(GirlSo girlSo);

    public void create(Girl girl);

    public void update(Girl girl);

    public void delete(Girl girl);
}
