package algorithm.Strings.leetCode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 打乱数组
 * @date 2025/02/11
 */
public class ShuffleArray {
    /**
     * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
     * 实现 Solution class:
     * Solution(int[] nums) 使用整数数组 nums 初始化对象
     * int[] reset() 重设数组到它的初始状态并返回
     * int[] shuffle() 返回数组随机打乱后的结果
     * 示例 1：
     * 输入
     * ["Solution", "shuffle", "reset", "shuffle"]
     * [[[1, 2, 3]], [], [], []]
     * 输出
     * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
     * 解释
     * Solution solution = new Solution([1, 2, 3]);
     * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
     * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
     * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
     * 提示：
     * 1 <= nums.length <= 50
     * -106 <= nums[i] <= 106
     * nums 中的所有元素都是 唯一的
     * 最多可以调用 104 次 reset 和 shuffle
     */

    private int[] original;//初始数组

    private int[] array;//打乱后数组

    private Random random;//随机数生成器

    public ShuffleArray(int[] nums) {
        this.original = nums.clone();//克隆初始化数组
        this.array = nums.clone();//克隆打乱后的数组
        this.random = new Random();//初始化随机数生成器
    }

    public int[] reset(){
        array = original.clone();
        return array;
    }

    public int[] shuffle(){
        for (int i = array.length - 1 ; i > 0 ; i--){
            int j = random.nextInt(i+1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
    public static void main(String[] args) {
        ShuffleArray solution = new ShuffleArray(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(solution.shuffle())); // 打乱数组
        System.out.println(Arrays.toString(solution.reset()));   // 重设数组
        System.out.println(Arrays.toString(solution.shuffle())); // 再次打乱数组
    }

}
