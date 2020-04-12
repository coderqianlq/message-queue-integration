package com.qianlq.producer.constant;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-04-07
 */

public class RegexConstantTest {

    private Pattern pattern = Pattern.compile(RegexConstant.MAIL_FORMAT);

    @Test
    public void testRealMailRegex() {
        // 一般的邮箱格式
        String str = "1242202279@qq.com";
        Matcher matcher = pattern.matcher(str);
        Assert.assertTrue(matcher.find());
    }

    @Test
    public void testErrorMailRegex() {
        // 错误的邮箱格式
        String str = "1242202279@qq#.com";
        Matcher matcher = pattern.matcher(str);
        Assert.assertFalse(matcher.find());
    }
}
