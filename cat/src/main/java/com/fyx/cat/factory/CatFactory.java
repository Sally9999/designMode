package com.fyx.cat.factory;

import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.enums.CatTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 工厂类
 *
 * @author wushiyi
 * @date 2020/08/04
 */
@Component
@Slf4j
public class CatFactory {

    public BaseCat getCat(String key) {
        CatTypeEnum catTypeEnum = CatTypeEnum.getEnum(key);
        if (null == catTypeEnum) {
            log.error("cat's type unknown");
        } else {
            try {
                Class clazz = catTypeEnum.getClazz();
                return (BaseCat) clazz.newInstance();
            } catch (Exception e) {
                log.error("cat's type unknown");
            }
        }
        return null;
    }
}
