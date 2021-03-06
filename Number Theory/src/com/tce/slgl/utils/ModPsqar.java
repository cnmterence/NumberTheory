package com.tce.slgl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TerenceG
 * @classname ModPsqar
 * @description 模P平方剩余
 * @lastmodifydate 2021/3/8
 */
public class ModPsqar {
    /**
     * @author TerenceG
     * @lastmodifydate 2021/3/8
     * @description: 求奇素数的二次剩余
     * @Param: * @param p
     * @Return: List<Long>
     */
    public static List<Long> getP2(long p) {
        List<Long> res = new ArrayList<Long>();
        for (long i = 0; i < (p - 1) / 2 + 1; i++) {
            res.add((long) (Math.pow(i, 2) % p));
        }
        return res;
    }

    /**
     * @author TerenceG
     * @lastmodifydate 2021/3/8
     * @description: 求模p的所有满足1≤a<p的二次剩余a的和 A
     * @Param: * @param p
     * @Return: long
     */
    public static long getA(long p) {
        long res = 0;
        List<Long> p2 = getP2(p);
        for (long i = 1; i < p; i++) {
            if (p2.contains(i)) {
                res += i;
            }
        }
        return res;
    }

    /**
     * @author TerenceG
     * @lastmodifydate 2021/3/8
     * @description: 求模p的所有满足1≤a<p的二次非剩余b的和 B
     * @Param: * @param p
     * @Return: long
     */
    public static long getB(long p) {
        long res = 0;
        List<Long> p2 = getP2(p);
        for (long i = 1; i < p; i++) {
            if (!p2.contains(i)) {
                res += i;
            }
        }
        return res;

        /*
         * another way:A+B=p(p-1)/2
         *
         * long A=getA(p); return p(p-1)/2-A;
         */
    }

    /**
     * @author TerenceG
     * @lastmodifydate 2021/3/8
     * @description: 求勒让德符号的简陋方法
     * @Param: * @param q * @param p todo
     * @Return: long
     */
    public static int getLen(long q, long p) {
        return getP2(p).contains(q) ? 1 : -1;
    }

    public static void main(String[] args) {

        List<Long> list = getP2(3011L);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 81) {
                System.out.println(i);
            }
        }
        System.out.println((int) (Math.pow(256, 2) + 14 * 256) % 337);

        long[] pNums = {5, 7, 11, 13, 17, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 91, 97};

        for (long pNum : pNums) {
            System.out.print("A(" + pNum + ") = " + getA(pNum));
            System.out.println("\tB(" + pNum + ") = " + getB(pNum));
            System.out.println(getB(pNum) % pNum == 0);
        }


        System.out.println(getLen(85, 101));
        System.out.println(getLen(29, 541));
        System.out.println(getLen(101, 1987));
        System.out.println(getLen(68, 101));
        //-1
        System.out.println(getLen(31706, 43789));
        System.out.println(getP2(43789));
        System.out.println();
    }
}
