package algorithm.recursion.leetCode;

/**
 * @author caihuaxin
 * @version 1.0.0
 * @doc 斐波那契序列
 * @date 2023-07-28
 */
public class FibonacciSequence {
    public int fbi(int i) {
        if(i<2){
            return i==0?0:1;
        }else{
            return fbi(i-1)+fbi(i-2);
        }
    }

    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        int fbi = fibonacciSequence.fbi(10);
        System.out.println(fbi);
    }
}
