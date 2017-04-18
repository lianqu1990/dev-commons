package cn.github.lianqu1990.utils.code;


import cn.github.lianqu1990.utils.date.DateFormatUtils;

import java.util.Date;
import java.util.Random;

/**
 * @author hanchao
 * @date 2017/2/12 16:01
 */
public class SimpleOrderNoUtil {

    public static String createOrderNo(){
        int rand = new Random().nextInt(100);
        return DateFormatUtils.LONG_NUMBER_FORMAT.format(new Date())+String.format("%03d",rand);
    }

}
