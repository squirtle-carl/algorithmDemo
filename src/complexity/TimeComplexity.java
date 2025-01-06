package complexity;

/**
 * @author caihuaxin
 * @version 1.0.0
 * @doc 时间复杂度
 * @date 2023-06-15
 */
public class TimeComplexity {
    /**
     * 连续数相加
     *
     * @param start 首项
     * @param end   尾项
     * @return int
     */
    public int continuousAdd(int start,int end){
        int sum = 0;
        //sum从start开始相加，每次start增加1，直到start等于end
        for (int i = start; i < end+1; i++) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * 高斯算法
     *
     * @param start 首项
     * @param end   尾项
     * @return int
     */
    public int gsAdd(int start,int end){
        //高斯连续数相加算法公式：(首项+尾项)*项数/2
        return (start+end)*(end-start+1)/2;
    }

    public static void main(String[] args) {
        TimeComplexity timeComplexity = new TimeComplexity();
        System.out.println(timeComplexity.continuousAdd(7, 100)+"\n"+ timeComplexity.gsAdd(7,100));
    }
}
