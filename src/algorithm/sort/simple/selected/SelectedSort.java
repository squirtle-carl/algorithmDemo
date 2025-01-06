package algorithm.sort.simple.selected;

import utils.SortUtil;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：简单选择排序
 * @date ：2022/9/28 10:21
 * @month_name ：9月
 * @week ：
 */
public class SelectedSort {
    public static void main(String[] args) {
        Integer[] numbers = SortUtil.generateArray(10, 30);
        long startTime1 = System.currentTimeMillis();
        SortUtil.selectSort(numbers);
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);
    }
}
