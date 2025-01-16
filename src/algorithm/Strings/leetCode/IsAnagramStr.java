package algorithm.Strings.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 是否有效的字母异位词
 * @date 2025/01/16
 */
public class IsAnagramStr {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char [] str =s.toCharArray();
        Arrays.sort(str);
        char [] str1 =t.toCharArray();
        Arrays.sort(str1);
        return Arrays.toString(str).equals(Arrays.toString(str1));
    }

    /**
     * @param s s
     * @param t t
     * @return boolean
     * @Description: 是否有效字母异位词 解法2 使用桶计数
     * @see String
     * @see String
     * @see boolean
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if(s.equals(t)){
            return true;
        }
        int[] counts = new int[26];
        int[] countt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'a';
            counts[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i)-'a';
            countt[index]++;
        }
        for (int i = 0; i < counts.length; i++) {
            if(counts[i]!=countt[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat","car"));
    }
}
