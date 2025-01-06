package algorithm.sort.senior.radix;

import utils.SortUtil;

import java.util.Arrays;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：基数排序
 * @date ：2022/9/28 14:02
 * @month_name ：9月
 */
public class radixSort {
    private static final int LENGTH=10;
    private static final int MAX_VALUE=30;
    public static void main(String[] args) throws Exception {
        Integer[] numbers = SortUtil.generateArray(LENGTH, MAX_VALUE);
        SortUtil.radixSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}
