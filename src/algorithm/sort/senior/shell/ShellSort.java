package algorithm.sort.senior.shell;

import utils.SortUtil;

import java.util.Arrays;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：希尔排序
 * @date ：2022/9/28 11:28
 * @month_name ：9月
 * @week ：
 */
public class ShellSort {
    public static void main(String[] args) {
        Integer[] numbers = SortUtil.generateArray(10, 30);
        System.out.println(Arrays.toString(numbers));
        SortUtil.shellSort(numbers);
    }
}
