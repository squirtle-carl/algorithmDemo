package algorithm.Strings.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe excel列标题
 * @date 2025/01/16
 */
public class ExcelColumnTitle {
    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     * 例如：
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * 示例 1：
     * 输入：columnNumber = 1
     * 输出："A"
     * 示例 2：
     * 输入：columnNumber = 28
     * 输出："AB"
     * 示例 3：
     * 输入：columnNumber = 701
     * 输出："ZY"
     * 示例 4：
     * 输入：columnNumber = 2147483647
     * 输出："FXSHRXW"
     * 提示：
     * 1 <= columnNumber <= 231 - 1
     */
    private static final Map<Integer,String> excel = new HashMap<>(){
        {
            put(1,"A");
            put(2,"B");
            put(3,"C");
            put(4,"D");
            put(5,"E");
            put(6,"F");
            put(7,"G");
            put(8,"H");
            put(9,"I");
            put(10,"J");
            put(11,"K");
            put(12,"L");
            put(13,"M");
            put(14,"N");
            put(15,"O");
            put(16,"P");
            put(17,"Q");
            put(18,"R");
            put(19,"S");
            put(20,"T");
            put(21,"U");
            put(22,"V");
            put(23,"W");
            put(24,"X");
            put(25,"Y");
            put(26,"Z");
        }
    };
    public static String convertToTitle(int columnNumber){
        if(columnNumber==0){
            return "Z";
        }
        if(excel.containsKey(columnNumber)){
            return excel.get(columnNumber);
        }
        if(columnNumber/26>1 && columnNumber%26 == 0) {
            return convertToTitle((columnNumber / 26)-1) + convertToTitle(columnNumber % 26);
        }else{
            return convertToTitle(columnNumber / 26) + convertToTitle(columnNumber % 26);
        }
    }


    /**
     * @param columnNumber 列号
     * @return {@link String }
     * @Description: 解法2
     * @see int
     * @see String
     */
    public static String convertToTitle2(int columnNumber){
        StringBuilder result = new StringBuilder();
        while (columnNumber>0){
            columnNumber--;
            result.insert(0,(char)(columnNumber%26+'A'));//巧妙运用了ASCII码
            columnNumber/=26;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(convertToTitle2(52));
    }
}
