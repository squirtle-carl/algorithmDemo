package algorithm.Strings.leetCode;

/**
 * @author 爱编程的杰尼龟
 * @version 1.0.0
 * @doc 最后一个单词长度
 * @date 2025/01/11
 */
public class LengthOfLastWord {
    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
     */
    public static int lengthOfLastWord(String s) {
        //找到最后一个空格位置的索引
        int lastSpaceIndex = s.lastIndexOf(" ");
        //如果没有找到，则返回字符串长度
        if(lastSpaceIndex == -1){
            return s.length();
        }
        //倒序遍历字符串
        int index = 0;
        for (int i = s.length()-1; i >=0; i--) {
            //如果最后一个字符串不是空格，则返回lastSpaceIndex~s.length()的长度
            if (s.charAt(i) != ' ') {
                index++;
            }else if(index == 0 && s.charAt(i) ==' '){
                lastSpaceIndex--;
            } else{
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
