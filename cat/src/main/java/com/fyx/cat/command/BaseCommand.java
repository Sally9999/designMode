package com.fyx.cat.command;

import com.fyx.cat.dto.PaymentDTO;

/**
 * 基础命令（命令模式）
 *
 * @author wushiyi
 * @date 2020/08/06
 */
public interface BaseCommand {
    /**
     * 执行命令
     *
     * @param paymentDTO
     */
    boolean execute(PaymentDTO paymentDTO);
}
