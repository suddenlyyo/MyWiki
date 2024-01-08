package com.zx.demo.utils;

import com.github.vertical_blank.sqlformatter.SqlFormatter;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * @program: MyWiki
 * @description: 自定义sql 打印
 * @author: zhou  xun
 * @create: 2023-12-21 11:26
 */
public class CustomSqlFormatter implements MessageFormattingStrategy {


    /**
     * 自定义sql日志打印
     *
     * @param connectionId 连接标识
     * @param now          执行时间
     * @param elapsed      执行秒数ms
     * @param category     statement
     * @param prepared     准备sql语句
     * @param sql          sql语句
     * @param url          数据库url连接
     * @return 格式化后的字符串
     */
    @Override
    public String formatMessage(int connectionId,
                                String now,
                                long elapsed,
                                String category,
                                String prepared,
                                String sql,
                                String url) {
        if (!sql.trim().isEmpty()) {
            String sqlBegin = "============== SQL LOGGER BEGIN ==============";
            String sqlExecuteTime = "SQL执行时间:" + now + "\n";
            String elapsedStr = "SQL执行耗时毫秒:" + elapsed + "ms" + "\n";
            String formattedSql = SqlFormatter.format(sql);
            String sqlPrint = "SQL执行语句:\n" + formattedSql;
            String sqlEnd = "==============  SQL LOGGER END  ==============";
            return sqlBegin + "\r\n" + sqlExecuteTime + elapsedStr + sqlPrint + "\r\n" + sqlEnd;
        }
        return "";
    }
}
