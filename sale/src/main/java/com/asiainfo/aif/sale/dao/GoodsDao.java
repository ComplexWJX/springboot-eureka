package com.asiainfo.aif.sale.dao;

import com.asiainfo.aif.sale.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDao {

    void save(Goods goods);
}
