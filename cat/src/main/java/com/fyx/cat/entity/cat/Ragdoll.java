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
public class Ragdoll extends BaseCat {

    public Ragdoll() {
        this.setType(CatTypeEnum.RAGDOLL.getName());
        this.setCode(NumberUtil.getInstance().generateCatCode(CatTypeEnum.RAGDOLL.getCode()));
        this.setMonth(new Random().nextInt(6) + 1);
        this.setDescription("布偶猫是猫中较大、较重的一种。它的头呈V形，眼大而圆，被毛丰厚，四肢粗大，尾长，身体柔软，多为三色或双色猫。" +
                "布偶猫抱起来像软绵绵的布偶，而且对人非常友善。它性格大胆，不知道什么叫恐惧，而且对疼痛的忍耐性相当强，常被误认为缺乏疼痛感，因此很能容忍孩子的玩弄，是非常理想的家庭宠物。");
        this.setPrice(5000);
        log.info("create a cat:{}", this.toString());
    }
}
