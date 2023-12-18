package com.zx.base;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;


public class NumTest {
    @Test
    public void intTest() {
        //等于 2.1*10
        double a = 2.1E5;
        //等于-2.8*10^-2
        double b = -2.8E-2;
        //使用下滑线分割，利于识别
        int c = 100_100;
        double d = 233_333.1;
        String format = String.format("%f,%f,%d,%f", a, b, c, d);
        System.out.println(format);
        //获取整数的二进制
        System.out.println("输出-10~10的二进制数:");
        IntStream.range(-10, 11)
                .mapToObj(i -> "10进制数" + i + "的二进制表示为:"
                        + Integer.toBinaryString(i))
                .forEachOrdered(System.out::println);
        //指数运算
        double result = Math.pow(2, 3);
        //& 按位与
        // | 按位或
        // ^ 按位异或
        // ~ 取反
        // << 左移
        // >> 右移
        System.out.println("计算2的3次方结果为:" + result);
        //只有对应的两个二进位均为1时，结果位才为1，否则为0。参与运算的数以补码方式出现
        System.out.println("计算5、7的二进制按位与运算:" + (5 & 7));
        //只要对应的二个二进位有一个为1时，结果位就为 1。参与运算的两个数均以补码出现
        System.out.println("计算5、7的二进制按位或运算:" + (5 | 7));
        //只要参与运算的两数的二进位相异时，结果为1。参与运算数仍以补码出现
        System.out.println("计算5、7的二进制按位异或运算:" + (5 ^ 7));
        //对参与运算的数的各二进位按位求反
        System.out.println("计算5的二进制取反结果:" + (~5));
        //把“<< ”左边的运算数的各二进位全部左移若干位，由“<<”右边的数指定移动的位数，高位丢弃，低位补0
        System.out.println("计算5的二进制左移4位结果:" + (5 << 4));
        // 把“>>”左边的运算数的各二进位全部右移若干位,
        // 对于有符号数，在右移时，符号位将随同移动。当为正数时，最高位补0，
        // 而为负数时，符号位为 1，最高位是补 0 或是补 1 取决于编译系统的规定。
        // Turbo C 和很多系统规定为补 1
        System.out.println("计算15的二进制右移2位结果:" + (15 >> 2));
    }


}





