package com.fyx.cat.entity.cat;

import com.fyx.cat.enums.CatTypeEnum;
import com.wusy.cat.NumberUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author wushiyi
 * @date 2020/08/05
 */
@Slf4j
public class ScottishFold extends BaseCat {

    public ScottishFold() {
        this.setType(CatTypeEnum.SCOTTISH_FOLD.getName());
        this.setCode(NumberUtil.getInstance().generateCatCode(CatTypeEnum.SCOTTISH_FOLD.getCode()));
        this.setMonth(new Random().nextInt(8) + 1);
        this.setDescription("折耳，顾名思义耳朵向前、向下呈折叠状，折耳猫的这种特征是基因突变的结果。" +
                "最早的一只折耳猫是1961年在苏格兰的一处农场附近被发现，但是耳朵仅出现一处折叠，人们针对这一特征不断进行选择性繁殖，" +
                "让它们的耳部折痕由最初的一处变为如今的二至三处，并且最终如愿以偿地培育出当下极具个性外形的折耳猫。");
        this.setPrice(7000);
        log.info("create a cat:{}", this.toString());
    }
}
