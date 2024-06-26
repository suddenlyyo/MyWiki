package com.zx.date;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateTest {


    @Test
    public void getDateListByMonth() {
        String yearMonth = "202304";
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(4, 6));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> fullDayList = new ArrayList<>(32);
        // 获得当前日期对象
        Calendar cal = Calendar.getInstance();
        cal.clear();// 清除信息
        cal.set(Calendar.YEAR, year);
        // 1月从0开始
        cal.set(Calendar.MONTH, month - 1);
        // 当月1号
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 获取当前日期字符串
        Date currentDate = new Date();
        try {
            currentDate = dateFormat.parse(dateFormat.format(currentDate));
            for (int j = 1; j <= count; j++) {
                Date date = cal.getTime();
                String format = dateFormat.format(date);
                //如果两个日期相等，则返回值为0。
                //如果Date在date参数之后，则返回值大于0。
                //如果Date在date参数之前，则返回值小于0。
                if (currentDate.compareTo(date) > 0) {
                    System.out.println(format);
                    fullDayList.add(format);
                }
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (ParseException ignored) {

        }
        fullDayList.forEach(System.out::println);
    }

    @Test
    public void compareToTest() {
        String dateTimeStr1 = "2016-10-25";
        String dateTimeStr2 = "2016-10-26";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(dateTimeStr1, formatter);
        LocalDate localDate2 = LocalDate.parse(dateTimeStr2, formatter);
        System.out.println(localDate1.compareTo(localDate2));
    }

    @Test
    public void formatStrToDateTest() {
        String dateTimeStr = "2016-10-25";
        DateTimeFormatter formatter02 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateTimeStr, formatter02);
        System.out.println(localDate);
    }

    @Test
    public void isValid() {
        String dateStr = "2023-05";
        boolean isDate = isValid(dateStr, "yyyyMM");
        System.out.println(isDate);

    }

    @Test
    public void timestampToDateStr() {
        long timestamp = 1693497600000L;
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(date);
        System.out.println(dateString);
    }

    /**
     * 日期格式化
     *
     * @param dateTimeStr 需要格式化的年月日时分秒字符串
     * @param pattern     匹配的格式
     * @return java.util.Date
     * @author: zhou  xun
     * @since: 2023-04-25
     */
    private Date formatStrToDate(String dateTimeStr, String pattern) {
        ZoneId zoneId = ZoneId.systemDefault();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, formatter);
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 验证日期字符串是不是目标格式
     *
     * @param dateStr 日期字符串
     * @param pattern 模式
     * @return
     * @author: zhou  xun
     * @since: 2023-05-03
     */
    public boolean isValid(String dateStr, String pattern) {
        DateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
