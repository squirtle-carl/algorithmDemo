package algorithm.Strings.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 单词规律
 * @date 2025/02/14
 */
public class WordPattern {
    /**
     * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
     * 示例1:
     * 输入: pattern = "abba", s = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     * 输入:pattern = "abba", s = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     * 输入: pattern = "aaaa", s = "dog cat cat dog"
     * 输出: false
     * 提示:
     * 1 <= pattern.length <= 300
     * pattern 只包含小写英文字母
     * 1 <= s.length <= 3000
     * s 只包含小写英文字母和 ' '
     * s 不包含 任何前导或尾随对空格
     * s 中每个单词都被 单个空格 分隔
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if(pattern.length()==0 || split.length == 0 ||split.length != pattern.length()){
            return false;
        }
        Map<Character,String> hashMap = new HashMap<>();
        boolean flag = false;
        for (int i = 0; i < pattern.length(); i++) {
            if(hashMap.containsKey(pattern.charAt(i))){
                if(hashMap.get(pattern.charAt(i)).equals(split[i])){
                    flag = true;
                }else{
                    flag = false;
                    return flag;
                }
            }else{
                for (String str : hashMap.values()){
                    if(str.equals(split[i])){
                        return false;
                    }
                }
                flag = true;
                hashMap.put(pattern.charAt(i),split[i]);
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("a","a"));
    }
}
