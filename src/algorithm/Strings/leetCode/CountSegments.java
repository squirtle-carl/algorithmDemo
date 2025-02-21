package algorithm.Strings.leetCode;

import java.util.Objects;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 字符串中的单词数
 * @date 2025/02/21
 */
public class CountSegments {
    /**
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     *
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     * 示例:
     * 输入: "Hello, my name is John"
     * 输出: 5
     * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
     */
    public static int countSegments(String s){
        if(s.length()==0){
            return 0;
        }

        String[] split = s.split(" ");
        int count = split.length;
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
            if(Objects.equals(split[i], "")){
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }
}
