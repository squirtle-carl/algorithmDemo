package algorithm.sort.simple.insert;

import utils.SortUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：插入排序
 * @date ：2022/9/28 10:41
 * @month_name ：9月
 * @week ：
 */
public class InsertSort {
    public static void main(String[] args) {
        Integer[] numbers = SortUtil.generateArray(10, 30);
        List<Integer> integers = Arrays.asList(numbers);
        System.out.println("原数组："+integers);
        SortUtil.insertSort(numbers);
    }
}
