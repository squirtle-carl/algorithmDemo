package algorithm.Strings.leetCode;

/**
 * @author caihuaxin
 * @version 1.0.0
 * @describe 回文数
 * @date 2024/01/05
 */
public class Palindrome {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     * 示例 1：
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     * 提示：
     * -231 <= x <= 231 - 1
     * 进阶：你能不将整数转为字符串来解决这个问题吗？
     */
    public boolean isPalindrome(int x) {
        int temp = x;
        if(x<0){
            return false;
        }
        if(x<10){
            return true;
        }
        int num = 0;
        while(x != 0){
            int i = x%10;
            x=x/10;
            num = num * 10 + i;
        }
        return num == temp;
    }

    //进阶写法
    public boolean isPalindromeAdvance(int x) {
        if(x<0){
            return false;
        }
        String s = String.valueOf(x);
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray).equals(s);
    }
}
