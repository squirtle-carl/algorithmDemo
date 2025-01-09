package algorithm.sort.senior.merge;

import stack.linearList.LinkList;
import utils.SortUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
//        System.out.println(Arrays.toString(SortUtil.mergeSort(numbers)));
        List<Integer> list = Arrays.asList(numbers);
        LinkedList<Integer> linkList = new LinkedList<>(list);
        System.out.println(mergeSort(linkList));
    }

    /**
     * 优化归并排序
     * @param list 链表
     * @return LinkedList
     */
    public static LinkedList<Integer> mergeSort(LinkedList<Integer> list) {
        // 如果链表为空或只有一个节点，直接返回
        if (list == null || list.size() <= 1) {
            return list;
        }

        // 使用快慢指针找到链表的中间节点
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        int midIndex = list.size() / 2;

        // 拆分链表为左右两部分
        for (int i = 0; i < list.size(); i++) {
            if (i < midIndex) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }

        // 递归地对左边和右边进行归并排序
        left = mergeSort(left);
        right = mergeSort(right);

        // 合并已排序的链表
        return merge(left, right);
    }

    // 合并两个已排序的链表
    private static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
        LinkedList<Integer> result = new LinkedList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.getFirst() <= right.getFirst()) {
                result.add(left.removeFirst());
            } else {
                result.add(right.removeFirst());
            }
        }

        // 添加剩余元素
        result.addAll(left);
        result.addAll(right);

        return result;
    }
}
