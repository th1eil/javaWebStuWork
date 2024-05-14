package cdu.ljh.util;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
//解析工具类
public class ParseUtil {
    //以下被注释的方法为原来格式化输出日期、时间、货币的方法
    // 此版本中，格式化输出功能已被自定义的EL函数替代，本类只需专注于字符串解析和类型转换
// public static String formatMoney(BigDecimal money) {
// return DecimalFormat.getCurrencyInstance(Locale.CHINA).format(money);
// }
//
// public static String formatDateShort(Date date) {
//
// return new SimpleDateFormat("yyyy年M月", Locale.CHINA).format(date);
// }
//
// public static String formatDateLong(Date date) {
//
// return new SimpleDateFormat("yyyy年M月d日", Locale.CHINA).format(date);
// }
//
// public static String formatDateTime(long date) {
// return new SimpleDateFormat("yyyy-M-d HH:mm:ss", Locale.CHINA).format(date);
// }
    public static BigDecimal parseMoney(String money) {
        try {
            return (BigDecimal) DecimalFormat.getCurrencyInstance(Locale.CHINA).parse(money);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public static Date parseDateLong(String sDate) {
        try {
            return new Date(new SimpleDateFormat("yyyy-M-d", Locale.CHINA).parse(sDate).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}