package com.fyx.cat.command;

import com.fyx.cat.dto.PaymentDTO;
import com.fyx.cat.strategy.payment.BasePayment;

/**
 * 购买命令
 *
 * @author wushiyi
 * @date 2020/08/06
 */
public class PurchaseCommand implements BaseCommand {
    private BasePayment basePayment;

    public PurchaseCommand(BasePayment basePayment) {
        this.basePayment = basePayment;
    }

    @Override
    public boolean execute(PaymentDTO paymentDTO) {
        return basePayment.purchase(paymentDTO.getBuyer(), paymentDTO.getCat());
    }
}
