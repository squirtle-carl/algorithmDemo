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
        numbers[4] = -14;
        SortUtil.radixSort(numbers);
//        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(Integer[] numbers) {
        int m =  Integer.MIN_VALUE;
        for (int num : numbers){
            if (num > m){
                m = num;
            }
        }
        for (int exp = 1; exp <= m; exp *= 10){
            countingSortDigit(numbers, exp);
        }
    }

    /**
     * @param numbers 数字
     * @param exp     exp
     * @return
     * @doc 计数排序数字
     */
    private static void countingSortDigit(Integer[] numbers, int exp) {
        int[] count = new int[10];
        int n = numbers.length;
        for (int i = 0; i < n; i++){
            int d = digit(numbers[i], exp);
            count[d]++;
        }
        for (int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--){
            int d = digit(numbers[i], exp);
            res[count[d] - 1] = numbers[i];
            count[d]--;
        }
        for (int i = 0; i < n; i++){
            numbers[i] = res[i];
        }
    }

    /**
     * @param num 数字
     * @param exp exp
     * @return @return int
     * @doc 数字
     */
    private static int digit(Integer num, int exp) {
        return (num / exp) % 10;
    }
}
