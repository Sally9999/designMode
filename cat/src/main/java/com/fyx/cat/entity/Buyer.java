package com.fyx.cat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 买家信息
 *
 * @author wushiyi
 * @date 2020/08/05
 */
@Data
@AllArgsConstructor
public class Buyer {
    /**
     * 姓名
     */
    private String name;
    /**
     * 所在城市
     */
    private String city;
    /**
     * 支付宝账户余额
     */
    private Integer aliAccount;
    /**
     * 微信账户余额
     */
    private Integer wxAccount;
    /**
     * 邮箱
     */
    private String mail;
}
