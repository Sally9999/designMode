package com.fyx.cat.dto;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 支付类DTO
 *
 * @author wushiyi
 * @date 2020/08/06
 */
@Data
@AllArgsConstructor
public class PaymentDTO {
    private Buyer buyer;
    private BaseCat cat;
    private Integer amount;
}
