package algorithm.sort.senior.quick;

import utils.SortUtil;

import java.util.Arrays;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：快速排序
 * @date ：2022/9/28 13:45
 * @month_name ：9月
 * @week ：
 */
public class QuickSort {
    private static final int LENGTH=10;
    private static final int MAX_VALUE=30;
    public static void main(String[] args) throws Exception {
        Integer[] numbers = SortUtil.generateArray(LENGTH, MAX_VALUE);
//        Integer[] numbers = {29,25,18,3,28,16,17,1,23,5};
        SortUtil.quickSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
