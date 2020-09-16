package com.fyx.cat.strategy.payment;

import com.fyx.cat.command.BalanceNoticeCommand;
import com.fyx.cat.command.BaseCommand;
import com.fyx.cat.command.CompositeInvoker;
import com.fyx.cat.command.FundInCommand;
import com.fyx.cat.dto.PaymentDTO;
import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.MailContent;
import com.fyx.cat.entity.cat.BaseCat;
import lombok.extern.slf4j.Slf4j;

/**
 * 支付模板（模板模式）
 *
 * @author wushiyi
 * @date 2020/08/06
 */
@Slf4j
public abstract class BasePayment {

    /**
     * 检查猫是否被卖出
     *
     * @param cat
     * @return
     */
    protected boolean checkSold(BaseCat cat) {
        return cat.isSold();
    }

    /**
     * 检查账户是否有钱
     *
     * @param buyer
     * @param cat
     * @return
     */
    protected abstract boolean checkAccount(Buyer buyer, BaseCat cat);

    /**
     * 付款
     *
     * @param buyer
     * @param cat
     * @return
     */
    protected abstract boolean pay(Buyer buyer, BaseCat cat);

    /**
     * 设置被卖出
     *
     * @param cat
     * @return
     */
    protected void setSold(BaseCat cat) {
        cat.setSold(true);
    }

    /**
     * 获取支付渠道
     *
     * @return
     */
    protected abstract String getPaymentChannel();

    /**
     * 获取账户余额
     *
     * @param buyer
     * @return
     */
    protected abstract Integer getBalance(Buyer buyer);

    /**
     * 通知
     *
     * @param buyer
     * @param cat
     */
    protected void notice(Buyer buyer, BaseCat cat) {
        MailContent mailContent = new MailContent();
        mailContent.setSubject("购买成功");
        mailContent.setContent(String.format("您已通过%s购买：%s【%s】,本次消费：%d,账户余额：%d", getPaymentChannel(), cat.getType(), cat.getCode(), cat.getPrice(), getBalance(buyer)));
        mailContent.setReceiver(buyer.getMail());
        // 假装发了邮件
        log.info("sent mail:{}", mailContent.toString());
    }

    /**
     * 购买
     *
     * @param buyer
     * @param cat
     */
    public boolean purchase(Buyer buyer, BaseCat cat) {
        if (this.checkSold(cat)) {
            log.error("{}购买失败，{}{}已卖出", buyer.getName(), cat.getType(), cat.getCode());
            return false;
        }
        if (this.checkAccount(buyer, cat)) {
            synchronized (this) {
                if (this.checkSold(cat)) {
                    log.error("{}购买失败，{}{}已卖出", buyer.getName(), cat.getType(), cat.getCode());
                    return false;
                }
                if (this.pay(buyer, cat)) {
                    this.setSold(cat);
                    this.notice(buyer, cat);
                    return true;
                }
            }
        } else {
            log.error("{}{}购买失败，账户余额{}不足{}！", buyer.getName(), getPaymentChannel(), getBalance(buyer), cat.getPrice());
            BaseCommand command1 = new FundInCommand(this);
            BaseCommand command2 = new BalanceNoticeCommand(this);
            CompositeInvoker invoker = new CompositeInvoker(this);
            invoker.add(command1);
            invoker.add(command2);
            invoker.execute(new PaymentDTO(buyer, null, cat.getPrice() - getBalance(buyer)));
            return this.purchase(buyer, cat);
        }
        return false;
    }

    /**
     * 转入
     *
     * @param buyer
     * @param amount
     */
    public abstract boolean fundIn(Buyer buyer, Integer amount);

    /**
     * 余额通知
     *
     * @param buyer
     */
    public boolean balanceNotice(Buyer buyer) {
        MailContent mailContent = new MailContent();
        mailContent.setSubject("账户余额提醒");
        mailContent.setContent(String.format("您支付宝余额：%d, 微信账户余额：%d", buyer.getAliAccount(), buyer.getWxAccount()));
        mailContent.setReceiver(buyer.getMail());
        // 假装发了邮件
        log.info("sent mail:{}", mailContent.toString());
        return true;
    }
}
