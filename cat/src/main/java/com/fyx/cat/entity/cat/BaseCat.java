package com.fyx.cat.entity.cat;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 基础类
 *
 * @author wushiyi
 * @date 2020/08/04
 */
@Data
@Slf4j
public abstract class BaseCat {

    /**
     * 品种
     */
    private String type;
    /**
     * 编码
     */
    private String code;
    /**
     * 几个月大
     */
    private Integer month;
    /**
     * 价格
     */
    private Integer price;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否卖出
     */
    private boolean sold;
}
