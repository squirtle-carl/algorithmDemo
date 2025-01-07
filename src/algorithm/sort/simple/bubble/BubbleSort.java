package algorithm.sort.simple.bubble;

import utils.SortUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：冒泡排序
 * @date ：2022/9/28 9:06
 * @month_name ：9月
 * @week ：
 * @link ：https://www.wolai.com/xhMH321FUWEgQGUmXGxLdb
 */
public class BubbleSort {
    private static final int LENGTH=10;
    private static final int MAX_VALUE=30;
    public static void main(String[] args) throws InterruptedException {
        Integer[] numbers1 = SortUtil.generateArray(LENGTH, MAX_VALUE);
        long startTime = System.currentTimeMillis();
        sort(numbers1);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
//        Thread.sleep(1000);
//        Integer[] numbers2 = SortUtil.generateArray(LENGTH, MAX_VALUE);
//        long startTime1 = System.currentTimeMillis();
//        SortUtil.bestBubbleSort(numbers2);
//        long endTime1 = System.currentTimeMillis();
//        System.out.println(endTime1 - startTime1);
        //数据量越大，优化效果越明显，但是并不能实质上优化，冒泡排序算法，只是阻断无效排序
    }

    /**
     * 普通冒泡排序
     * 十次测试耗时：82 178 57 162 73 123 56 54 55 94
     * 最好情况O(n)
     * 最坏情况O(n^2)
     * 平均情况O(n^2)
     * 空间复杂度O(1)
     * @param numbers 随机数组
     */
    public static void sort(Integer[] numbers) {
        for(int i =0 ; i<numbers.length-1 ; i++) {//外层循环的目的：是为了控制遍历从某处结束
            for(int j=0 ; j<numbers.length-1-i ; j++) {//内层循环的目的：1. 控制从0开始，到length-1-i处结束；2.控制比较的逻辑
                if(numbers[j]>numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
                List<Integer> integers = Arrays.asList(numbers);
                System.out.println(integers);
            }
        }
    }
}
