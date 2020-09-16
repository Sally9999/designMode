package com.fyx.cat.facede;

import com.fyx.cat.entity.cat.BaseCat;
import lombok.extern.slf4j.Slf4j;

/**
 * 库存子系统
 *
 * @author wushiyi
 * @date 2020/08/07
 */
@Slf4j
public class InventorySubSystem {

    public void handle(BaseCat cat) {
        log.info("正在处理库存 {}...", cat.getCode());
        log.info("正在打包 {}...", cat.getCode());
    }
}
