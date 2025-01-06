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

}
