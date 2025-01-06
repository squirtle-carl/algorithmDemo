package algorithm.sort.senior.merge;

import utils.SortUtil;

import java.util.Arrays;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：归并排序
 * @date ：2022/9/28 13:53
 * @month_name ：9月
 * @week ：
 */
public class MergeSort {
    private static final int LENGTH=10;
    private static final int MAX_VALUE=30;
    public static void main(String[] args) throws Exception {
        Integer[] numbers = SortUtil.generateArray(LENGTH, MAX_VALUE);
        System.out.println(Arrays.toString(SortUtil.mergeSort(numbers)));
    }

}
