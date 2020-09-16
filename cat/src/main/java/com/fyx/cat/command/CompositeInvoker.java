package com.fyx.cat.command;

import com.fyx.cat.dto.PaymentDTO;
import com.fyx.cat.strategy.payment.BasePayment;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量执行命令
 *
 * @author wushiyi
 * @date 2020/08/06
 */
@Slf4j
public class CompositeInvoker implements BaseCommand {
    private List<BaseCommand> commands = new ArrayList<>();
    private BasePayment basePayment;

    public CompositeInvoker(BasePayment basePayment) {
        this.basePayment = basePayment;
    }

    public void add(BaseCommand command) {
        commands.add(command);
    }

    public void remove(BaseCommand command) {
        commands.remove(command);
    }

    @Override
    public boolean execute(PaymentDTO paymentDTO) {
        if (!commands.isEmpty()) {
            for (BaseCommand command : commands) {
                if (!command.execute(paymentDTO)) {
                    log.error("command {} failed, paymentDTO:{}", command.getClass().getName(), paymentDTO.toString());
                }
            }
        }
        return true;
    }
}
