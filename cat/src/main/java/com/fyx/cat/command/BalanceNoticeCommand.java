package com.fyx.cat.command;

import com.fyx.cat.dto.PaymentDTO;
import com.fyx.cat.strategy.payment.BasePayment;

/**
 * 余额提醒命令
 *
 * @author wushiyi
 * @date 2020/08/06
 */
public class BalanceNoticeCommand implements BaseCommand {
    private BasePayment basePayment;

    public BalanceNoticeCommand(BasePayment basePayment) {
        this.basePayment = basePayment;
    }

    @Override
    public boolean execute(PaymentDTO paymentDTO) {
        return basePayment.balanceNotice(paymentDTO.getBuyer());
    }
}
