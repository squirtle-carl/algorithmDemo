package algorithm.Strings.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 赎金信
 * @date 2025/02/11
 */
public class RansomLetter {
    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * 如果可以，返回 true ；否则返回 false 。
     * magazine 中的每个字符只能在 ransomNote 中使用一次
     * 示例 1：
     * 输入：ransomNote = "a", magazine = "b"
     * 输出：false
     * 示例 2：
     * 输入：ransomNote = "aa", magazine = "ab"
     * 输出：false
     * 示例 3：
     * 输入：ransomNote = "aa", magazine = "aab"
     * 输出：true
     * 提示：
     * 1 <= ransomNote.length, magazine.length <= 105
     * ransomNote 和 magazine 由小写英文字母组成
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Integer,Character> result = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            for (int j = 0; j < magazine.length(); j++){
                if(ransomNote.charAt(i) == magazine.charAt(j) && !result.containsKey(j)){
                    //如果两个字符相等，则记录下这个字符的索引和字符
                    result.put(j, ransomNote.charAt(i));
                    break;
                }
            }
        }
        if(result.size() == ransomNote.length()){
            return true;
        }
        return false;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int i = magazine.indexOf(c, alphabet[c % 26]);
            if (i == -1) {
                return false;
            }
            alphabet[c % 26] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa","ab"));
    }
}
