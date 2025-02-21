package algorithm.Strings.leetCode;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 添加字符串
 * @date 2025/02/21
 */
public class AddStrings {
    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
     * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
     * 示例 1：
     * 输入：num1 = "11", num2 = "123"
     * 输出："134"
     * 示例 2：
     * 输入：num1 = "456", num2 = "77"
     * 输出："533"
     * 示例 3：
     * 输入：num1 = "0", num2 = "0"
     * 输出："0"
     * 提示：
     * 1 <= num1.length, num2.length <= 104
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     */
    public static String addStrings(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i>=0) {
                carry += num1.charAt(i--)-'0';//利用ASCII码的差值计算
            }
            if(j>=0) {
                carry += num2.charAt(j--)-'0';
            }
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
