package algorithm.Strings.leetCode;

import java.util.Arrays;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 反转元音字母
 * @date 2025/01/16
 */
public class ReverseVowelsStr {
    /**
     * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
     * 示例 1：
     * 输入：s = "IceCreAm"
     * 输出："AceCreIm"
     * 解释：
     * s 中的元音是 ['I', 'e', 'e', 'A']。反转这些元音，s 变为 "AceCreIm".
     * 示例 2：
     * 输入：s = "leetcode"
     * 输出："leotcede"
     * 提示：
     * 1 <= s.length <= 3 * 105
     * s 由 可打印的 ASCII 字符组成
     */
    public static String reverseVowels(String s) {
        //有大小写，两种解决方案：
        // 1. 把所有大写转换成小写，或小写转换为大写，但是需要交换并保持原有大小写，显然不合理
        // 2. 保存对应的元音，如果相等，则记录这个索引的位置，然后交换
        char[] str = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'A'
                    || s.charAt(i) == 'e' || s.charAt(i) == 'E'
                    || s.charAt(i) == 'i' || s.charAt(i) == 'I'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'O'
                    || s.charAt(i) == 'u' || s.charAt(i) == 'U' ){
                str[i]=s.charAt(i);
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if(str[i] != '\u0000'){
                strBuilder.append(str[i]);
            }
        }
        String reverse = strBuilder.reverse().toString();
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if(str[i] != '\u0000'){
                str[i] = reverse.charAt(index);
                index++;
            }else{
                str[i] = s.charAt(i);
            }
        }
        return new String(str);
    }

    public static String reverseVowels2(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    public static void main(String[] args) {
        System.out.println(reverseVowels2("leetcode"));
    }
}
