package algorithm.Strings.leetCode;

import java.util.*;

/**
 * @author caihuaxin
 * @version 1.0.0
 * @describe 罗马转数字
 * @date 2024/01/05
 */
public class RomeCoverNum {
    /**
     * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             1
     *  L             50
     *  C             100
     *  D             500
     *  M             1000
     *  例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的
     *     数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *     I 可以放在 V(5) 和 X(10) 的左边，来表示 4 和 9。
     *     X 可以放在 L(50) 和 C(100) 的左边，来表示 40 和 90。
     *     C 可以放在 D(500) 和 M(1000) 的左边，来表示 400 和 900。
     *     给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *     示例 1:
     *         输入: "III"
     *         输出: 3
     *     示例 2:
     *         输入: "IV"
     *         输出: 4
     *     示例 3:
     *         输入: "IX"
     *         输出: 9
     *     示例 4:
     *         输入: "LVIII"
     *         输出: 58
     *         解释: L = 50, V= 5, III = 3.
     *     示例 5:
     *         输入: "MCMXCIV"
     *         输出: 1994
     *         解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *     注意 M 不能放在 CM 的左边，因为 M 与 CM 包含相同的数字。
     *     同样地，对于 IV 和 IX，我们可以这样写：
     *         IV = 4, IX = 9.
     *         但是，对于其他的数字，例如，我们不能写成 IX。因为 IX 没有 X 出现在左边。
     *         题目保证输入的罗马数字总是有效的，且只包含以下的字符：（I， V， X， L，C，D 和 M）。
     *         题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
     *         题目所给测试用例与答案符合的题目类型同样属于有效的答案。
     *         I 、Ⅱ 、Ⅲ 、Ⅳ 、Ⅴ 、Ⅵ 、Ⅶ 、Ⅷ 、Ⅸ 、Ⅹ 、Ⅺ 、Ⅻ 、XⅢ、Ⅼ 、Ⅽ 、Ⅾ 、Ⅿ 都是有效的罗马数字，且表示整数
     */

    //初始化罗马字符与数字的对应关系
    private static Map<Character,Integer> map = new HashMap<>(){
        {
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }
    };

    /**
     * @param s s
     * @return @return int
     * @doc 罗马转整型  第一种方式
     */
    public int romanToInt(String s) {//MCMXCIV
        List<Character> list = new ArrayList<>(Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M'));
        int[] num = {1, 5, 10, 50, 100, 500, 1000};
        int sum = 0;
        int preNum = num[list.indexOf(s.charAt(0))];
        for (int i = 1; i < s.length(); i++) {
            int index = num[list.indexOf(s.charAt(i))];
            if(preNum < index){
                sum -= preNum;
            }else{
                sum += preNum;
            }
            preNum = index;
        }
        sum += preNum;
        return sum;
    }

    /**
     * @param s s
     * @return @return int
     * @doc 罗马转整型  第二种方式
     */
    public int romanToInt2(String s) {
        //创建一个数组，存储对应的特殊罗马字符
        char[] str = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        //创建一个数组，存储罗马字符对应的数值
        int[] num = {1, 5, 10, 50, 100, 500, 1000};
        int sum = 0;
        //倒序遍历字符串
        for (int i = (s.length()-1); i >= 0; i--) {
            //正序遍历数组
            for (int j = 0; j < str.length; j++) {
                //如果字符串中的字符与数组中的字符相等，则做如下处理
                if (s.charAt(i) == str[j]) {
                    //如果当前字符是字符串的最后一个字符，则直接加上该数值
                    if(i==(s.length()-1)){
                        sum += num[j];
                    }else{//如果不是字符串的最后一个字符，则需要比对下一个字符
                        if(s.charAt(i+1) == 'V' && s.charAt(i) == 'I'){
                            sum = sum - num[j];//如果Ⅴ在右边，Ⅰ在左边，则减去该字符对应的数值
                        }else if(s.charAt(i+1) == 'X' && s.charAt(i) == 'I'){
                            sum = sum - num[j];//如果Ⅹ在右边，Ⅰ在左边，则减去该字符对应的数值
                        }else if(s.charAt(i+1) == 'L' && s.charAt(i) == 'X'){
                            sum = sum - num[j];//同理
                        }else if(s.charAt(i+1) == 'C' && s.charAt(i) == 'X'){
                            sum = sum - num[j];//同理
                        }else if(s.charAt(i+1) == 'D' && s.charAt(i) == 'C'){
                            sum = sum - num[j];//同理
                        }else if(s.charAt(i+1) == 'M' && s.charAt(i) == 'C'){
                            sum = sum - num[j];//同理
                        }else {
                            sum += num[j];//除了上述情况外，其他情况都应该加上该字符对应的数值
                        }
                    }
                }
            }
        }
        return sum;
    }


    /**
     * @param s s
     * @return @return int
     * @doc 罗马转整型  第三种方式
     */
    public static int romanToInt3(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            //如果不是最后一个罗马字符，并且该字符对应的数值小于下一个罗马字符对应的数值，则减去该字符对应的数值
            if(i < s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                sum -= map.get(s.charAt(i));
            }else{//否则就加上
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RomeCoverNum romeCoverNum = new RomeCoverNum();
        System.out.println(romanToInt3("MCMXCIV"));
    }
}
