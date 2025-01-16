package algorithm.Strings.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 同构字符串
 * @date 2025/01/16
 */
public class IsomorphicStr {
    /**
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     * 示例 1:
     * 输入：s = "egg", t = "add"
     * 输出：true
     * 示例 2：
     * 输入：s = "foo", t = "bar"
     * 输出：false
     * 示例 3：
     * 输入：s = "paper", t = "title"
     * 输出：true
     * 提示：
     * 1 <= s.length <= 5 * 104
     * t.length == s.length
     * s 和 t 由任意有效的 ASCII 字符组成
     */
    public static boolean isIsomorphic(String s,String t){
        //条件：s和t
        //判断要求：每个出现的字符都映射对应的字符，不能改变字符顺序，不能映射到同一个字符上，可以映射到自己本身
        //即 e->a g->d g->d true   f->b o->a o->r false o映射到了两个不同的字符
        int min = Math.min(s.length(), t.length());
        Map<Character,Character> map= new HashMap<>();
        int count = 0;
        for (int i = 0 ;  i<min ; i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),t.charAt(i));
            }else if(!map.get(s.charAt(i)).equals(t.charAt(i))){
                //如果value和t.chartAt(i)相等，则true
                count ++;
            }
        }
        if(count>0){
            return false;
        }else{
            //反转map的key和value
            Map<Character,Character> map2 = new HashMap<>();
            for (Map.Entry<Character,Character> entry : map.entrySet()){
                map2.put(entry.getValue(),entry.getKey());
            }
            if(map.size() != map2.size()){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper","title"));
    }
}
