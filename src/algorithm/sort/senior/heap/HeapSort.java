package algorithm.sort.senior.heap;

import utils.SortUtil;

import java.util.Arrays;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：堆排序
 * @date ：2022/9/28 13:49
 * @month_name ：9月
 * @week ：
 */
public class HeapSort {
    private static final int LENGTH=10;
    private static final int MAX_VALUE=30;
    public static void main(String[] args) throws Exception {
        Integer[] numbers = SortUtil.generateArray(LENGTH, MAX_VALUE);
        SortUtil.heapSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
