package com.my.javabasic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.time.temporal.ChronoUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicKnowledge_DateTime_LocalDateTime {

    @Test
    public void show_current_datetime_with_LocalDate_LocalTime() {
        LocalDate localDate = LocalDate.now();
        //精确到毫秒
        LocalTime localTime = LocalTime.now();
        System.out.println("当前日期：" + localDate.toString());
        System.out.println("当前时间：" + localTime.toString());

        LocalDate localDate1 = localDate.plus(5, ChronoUnit.HOURS);
        localDate.isBefore(localDate1);
    }

    @Test
    public void show_current_datetime_with_LocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间：" + localDateTime.toString());
        System.out.println("最小时间：" + LocalDateTime.MIN);
        System.out.println("最大时间：" + LocalDateTime.MAX);
    }

    @Test
    public void calculate_between_two_localDateTime() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        //加25小时3分钟
        LocalDateTime localDateTime2 = localDateTime1.plusHours(25).plusMinutes(3);
        System.out.println("localDateTime1=" + localDateTime1);
        System.out.println("localDateTime2=" + localDateTime2);

        //Duration:用于计算两个“时间”间隔
        //Period:用于计算两个“日期”间隔
    }

    @Test
    public void show_all_time_zone() {
        // 获取所有时区信息
        ZoneId.getAvailableZoneIds()
                .forEach(System.out::println);

    }

    @Test
    public void show_current_datetime_with_ZonedDateTime() {
        // 从默认时区的系统时钟获取当前的日期时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        // 获得时区
        ZoneId zone = zonedDateTime.getZone();
        System.out.println("\n" + zone);

        // 获得指定时区时间
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("\n" + zonedDateTime2);

        // 获取指定时区的本地时间
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Colombo"));
        System.out.println("\n" + localDateTime);

    }
}
