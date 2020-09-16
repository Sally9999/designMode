package com.fyx.cat.command;

import com.fyx.cat.dto.PaymentDTO;
import com.fyx.cat.strategy.payment.BasePayment;

/**
 * 入金命令
 *
 * @author wushiyi
 * @date 2020/08/06
 */
public class FundInCommand implements BaseCommand {
    private BasePayment basePayment;

    public FundInCommand(BasePayment basePayment) {
        this.basePayment = basePayment;
    }

    @Override
    public boolean execute(PaymentDTO paymentDTO) {
        return basePayment.fundIn(paymentDTO.getBuyer(), paymentDTO.getAmount());
    }
}
