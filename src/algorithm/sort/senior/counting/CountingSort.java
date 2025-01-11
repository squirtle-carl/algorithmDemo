package algorithm.sort.senior.counting;

import utils.SortUtil;

import java.util.Arrays;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：计数排序
 * @date ：2022/9/28 13:51
 * @month_name ：9月
 * @week ：
 */
public class CountingSort {
    private static final int LENGTH=10;
    private static final int MAX_VALUE=30;
    public static void main(String[] args) throws Exception {
        Integer[] numbers = SortUtil.generateArray(LENGTH, MAX_VALUE);
//        Integer[] integers = SortUtil.generateNearlyOrderedArray(LENGTH, MAX_VALUE,1,);
        SortUtil.countingSort(numbers);
        System.out.println(Arrays.toString(numbers));
//        System.out.println(Arrays.toString(integers));
    }

    /**
     * 计数排序
     * @param numbers 随机数组
     */
    public static void sort(Integer[] numbers){
        int maxValue = SortUtil.getMaxValue(numbers);
        counting(numbers, maxValue);
    }

    /**
     * 稳定的计数操作
     * @param arr 随机数组
     * @param maxValue 最大值
     */
    private static void counting(Integer[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int num : arr) {
            bucket[num]++;
        }

        for (int i = 0; i < bucketLen-1 ; i++) {
            bucket[i+1] += bucket[i];
        }

        int sortedIndex = arr.length;
        int[] res = new int[sortedIndex];
        for (int i = sortedIndex-1; i>=0 ; i--){
            int num = arr[i];
            res[bucket[num]-1]=num;
            bucket[num]--;
        }
        // 使用结果数组 res 覆盖原数组 nums
        for (int i = 0; i < sortedIndex; i++) {
            arr[i] = res[i];
        }
    }
}
