package com.fyx.cat.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 编码类工具（单例模式）
 *
 * @author wushiyi
 * @date 2020/08/05
 */
public class NumberUtil {
    private static volatile NumberUtil instance = null;

    private NumberUtil() {

    }

    public static NumberUtil getInstance() {
        if (instance == null) {
            synchronized (NumberUtil.class) {
                if (instance == null) {
                    instance = new NumberUtil();
                }
            }
        }
        return instance;
    }

    public String generateCatCode(String prefix) {
        LocalDateTime now = LocalDateTime.now();
        String randomNumeric = RandomStringUtils.randomNumeric(6);
        return String.format("%s%s%s", prefix, now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")), randomNumeric);
    }
}
