package com.jaxon.sale.dao;

import com.jaxon.sale.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDao {

    void save(Goods goods);
}
