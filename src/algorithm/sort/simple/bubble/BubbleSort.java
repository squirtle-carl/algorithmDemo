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
    public static void main(String[] args) {
        Integer[] numbers = SortUtil.generateArray(100, 500);
//        Integer[] numbers = new Integer[] {13, 22, 23, 34, 15, 26, 47, 18, 29, 19, 11};
        long startTime = System.currentTimeMillis();
        sort(numbers);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
//        Integer[] newNumbers = new Integer[] {11, 13, 15, 18, 19, 22, 23, 26, 29, 34, 47};
        long startTime1 = System.currentTimeMillis();
        SortUtil.bestBubbleSort(numbers);
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);
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
        for(int i =0 ; i<numbers.length-1 ; i++) {
            for(int j=0 ; j<numbers.length-1-i ; j++) {
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
