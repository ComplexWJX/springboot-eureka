package com.jaxon.sale.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Koala
 * @description
 * @date 2019/12/27 0027
 */
@Data
public class Goods {
    private Integer id;
    private String name;
    private BigDecimal price;
}
