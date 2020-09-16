package com.fyx.cat.entity;

import lombok.Data;

/**
 * 邮件内容（原型模式）
 *
 * @author wushiyi
 * @date 2020/08/05
 */
@Data
public class MailContent implements Cloneable {

    /**
     * 收件人
     */
    private String receiver;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String content;

    @Override
    public MailContent clone() throws CloneNotSupportedException {
        MailContent mailContent = (MailContent) super.clone();
        return mailContent;
    }
}
