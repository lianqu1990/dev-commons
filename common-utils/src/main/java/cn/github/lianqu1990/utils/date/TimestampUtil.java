package cn.github.lianqu1990.utils.date;

/**
 * @author hanchao
 * @date 2017/4/9 22:35
 */
public class TimestampUtil {
    /**
     * unix时间戳
     * @return
     */
    public static long currentUnixTimeStamp(){
        return currentTimeStamp()/1000;
    }

    /**
     * 毫秒时间戳
     * @return
     */
    public static long currentTimeStamp(){
        return System.currentTimeMillis();
    }
}
