package com.asiainfo.aif.sale.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Koala
 * @description
 * @date 2019/12/27 0027
 */
@Data
public class Order {
    private Integer id;
    private String orderNo;
    private Integer userId;
    private Date createTime;
}
