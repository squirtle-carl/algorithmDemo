package algorithm.dynamic.leetCode.back;

import java.util.Scanner;

/**
 * @author ：Carl_蔡先生
 * @version ：JDK1.8
 * @description：完全背包问题：与01背包问题最大的区别就是：物品的使用次数为无限次
 * @date ：2022/4/21 11:09
 * @month_name ：4月
 * @week ：
 */
public class AllBackpack {
    public static void main(String[] args) {
        //输入第一行整数，用空格隔开，表示物品数量和背包容量
        System.out.println("请输入物品数量N和背包容量V");
        Scanner sc = new Scanner(System.in);
        String nAndV = sc.nextLine();
        String[] s = nAndV.split(" ");
        boolean flag = false;
        for (int i = 0; i < s.length; i++) {
            //判断两个输入的数据是否为有效字符串
            if (!"".equals(s[i])) {
                //转换为char数组的目的是为了判断字符是否为数字
                char[] chars = s[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    //是数字返回true，否则返回false
                    if (Character.isDigit(chars[j])) {
                        flag = true;
                    } else {
                        System.out.println("数据非法");
                    }
                }
            }
        }
        //物品数量
        int N = Integer.parseInt(s[0]);
        //背包容量
        int V = Integer.parseInt(s[1]);
        //物品体积
        int[] v = new int[N];
        //物品价值
        int[] w = new int[N];
        if (flag) {
            System.out.println("请输入物品的体积v和价值w，v和w之间用空格隔开，物品之间用换行");
            for (int i = 0; i < N; i++) {
                String volumeAndPrice = sc.nextLine();
                String[] s1 = volumeAndPrice.split(" ");
                for (int j = 0; j < s1.length; j++) {
                    //判断两个输入的数据是否为有效字符串
                    if (!"".equals(s1[j])) {
                        //转换为char数组的目的是为了判断字符是否为数字
                        char[] chars = s1[j].toCharArray();
                        for (int k = 0; k < chars.length; k++) {
                            //是数字返回true，否则返回false
                            if (Character.isDigit(chars[k])) {
                                flag = true;
                            } else {
                                flag = false;
                                System.out.println("数据非法");
                            }
                        }
                    }
                }
                if (flag) {
                    //存储输入的值
                    v[i] = Integer.parseInt(s1[0]);//体积
                    w[i] = Integer.parseInt(s1[1]);//价值
                }
            }
            //解：如何使得装入的总价值最大，且不超过背包容量--核心代码
            int[] dp = new int[V + 1];//价值数组，使用体积作为下标--超过--越界
            for (int i = 0; i < N; i++) {//根据物品遍历
                for (int j = v[i]; j <= V; j++) {//与01背包问题唯一的区别就是：遍历的顺序
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                }
            }
            System.out.println(dp[V]);
        }
    }
}
