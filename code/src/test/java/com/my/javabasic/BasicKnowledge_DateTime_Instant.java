package com.my.javabasic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicKnowledge_DateTime_Instant {

    /**
     * 获取当前秒数
     */
    @Test
    public void get_current_time_seconds() {
        System.out.println("当前秒：" + Instant.now().getEpochSecond());
    }

    @Test
    public void get_default_time_seconds() {
        Instant instant = Instant.EPOCH;
        System.out.println("当前时间：" + instant);
        System.out.println("当前秒：" + instant.getEpochSecond());
    }

    /**
     * 获取当前毫秒数
     */
    @Test
    public void get_current_time_millis_seconds() {
        System.out.println("当前毫秒：" + Instant.now().toEpochMilli());
    }

    /**
     * 获取当前毫秒数
     */
    @Test
    public void get_current_time() {
        //通过这种方式获取的时间戳与北京时间相差8个时区
        //使用UTC时间，LocalDate、LocalDateTime使用系统默认时区
        System.out.println("当前UTC时间：" + Instant.now());
        System.out.println("当前北京时间：" + Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
        System.out.println("当前秒（10位）：" + Instant.now().getEpochSecond());
        System.out.println("当前毫秒（13位）：" + Instant.now().toEpochMilli());
        System.out.println("纳秒部分：" + Instant.now().getNano());
    }

    @Test
    public void calc_diff_between_instant_days() {
        //5天前
        Instant now = Instant.now();
        Instant before5Days1 = now.minus(5, ChronoUnit.DAYS);
        Instant before5Days2 = now.minus(Duration.ofDays(5)); // Option 2  方法2
        System.out.println("当前时间：" + now.toString());
        System.out.println("5天前时间：" + before5Days1.toString());
        System.out.println("5天前时间：" + before5Days2.toString());
    }


    @Test
    public void calc_diff_between_instant_minutes() {
        Instant instant1 = Instant.now();
        Instant instant2 = instant1.plus(5, ChronoUnit.MINUTES);
        //计算两个Instant之间的分钟数
        long diffAsMinutes1 = instant1.until(instant2, ChronoUnit.MINUTES); // 方法1
        long diffAsMinutes2 = ChronoUnit.MINUTES.between(instant1, instant2); // 方法2
        System.out.println("时间1：" + instant1.toString());
        System.out.println("时间2：" + instant2.toString());
        System.out.println("两时间分钟差：" + diffAsMinutes1);
        System.out.println("两时间分钟差：" + diffAsMinutes2);
    }

    @Test
    public void parse_to_instant_from_string() {
        Instant instant = Instant.parse("1995-10-23T10:12:35Z");
        System.out.println("时间为：" + instant.toString());

        Instant instant1 = Instant.parse("2017-12-03T10:15:30.00Z");
        Instant instant2 = Instant.parse("2017-12-03T10:18:30.00Z");
        System.out.println("相差秒数:" + instant1.until(instant2, ChronoUnit.SECONDS));
        System.out.println("相差秒数:" + instant1.until(instant1, ChronoUnit.SECONDS));
    }

    @Test
    public void compare_to_instant() {
        Instant instant1 = Instant.parse("2019-12-05T10:15:30.00Z");
        Instant instant2 = Instant.parse("2019-12-03T10:18:30.00Z");

        System.out.println("instant1=" + instant1.toString());
        System.out.println("instant2=" + instant2.toString());

        System.out.println("instant1 compareTo instant2 =" + instant1.compareTo(instant2));
        System.out.println("instant2 compareTo instant1 =" + instant2.compareTo(instant1));
        System.out.println("instant1 isAfter instant2 =" + instant1.isAfter(instant2));
        System.out.println("instant2 isAfter instant1 =" + instant2.isAfter(instant1));

        System.out.println("instant1 isBefore instant2 =" + instant1.isBefore(instant2));
        System.out.println("instant2 isBefore instant1 =" + instant2.isBefore(instant1));
    }
}
