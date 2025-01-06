package utils;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：数组工具类
 * @date ：2022/9/28 9:58
 * @month_name ：9月
 * @week ：
 */
public class SortUtil {
    /**
     * 随机生成数组
     * @param len 数组长度
     * @param max 生成数据的最大值
     * @return Integer[]
     */
    public static Integer[]  generateArray(Integer len,Integer max){
        Integer[] arr=new Integer[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }

    /**
     * 随机生成有序数组
     * @param length 数组长度
     * @param max 数据最大值
     * @param sortOrder 排序方式:1.升序;2.降序
     * @param sortMethod 排序方法:1.冒泡排序;2.插入排序;3.选择排序;4.希尔排序;5.快速排序;6.归并排序;7.堆排序;8.计数排序;9.基数排序;10.桶排序
     * @return Integer[]
     */
    public static Integer[] generateNearlyOrderedArray(int length, int max,int sortOrder,int sortMethod)  {
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i]=(int)(Math.random()*max);
        }
        if (sortOrder != 1 && sortMethod != 2) {
            return arr;
        }
        switch (sortMethod) {
            case 1 -> bestBubbleSort(arr);
            case 2 -> insertSort(arr);
            case 3 -> selectSort(arr);
            case 4 -> shellSort(arr);
            case 5 -> quickSort(arr);
            case 6 -> arr = mergeSort(arr);
            case 7 -> heapSort(arr);
            case 8 -> countingSort(arr);
            case 9 -> radixSort(arr);
            case 10 -> bucketSort(arr);
            default -> throw new IllegalArgumentException("Invalid sort method: " + sortMethod);
        }
        return arr;
    }
    /**
     * 优化冒泡排序
     *    如果已经排序，停止遍历
     * 十次测试耗时：79 56 59 52 63 85 103 55 124 81 89
     * 最好情况O(n)
     * 最坏情况O(n^2)
     * 平均情况O(n^2)
     * 空间复杂度O(1)
     * @param numbers 随机数组
     */
    public static void bestBubbleSort(Integer[] numbers){
        boolean flag = false;
        for(int i =0 ; i<numbers.length-1 ; i++) {
            for(int j=0 ; j<numbers.length-1-i ; j++) {
                if(numbers[j]>numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                    flag=true;
                }
                List<Integer> integers = Arrays.asList(numbers);
                System.out.println(integers);
            }
            if (!flag) {
                break;
            }
        }
    }
    /**
     * 简单选择排序
     * 最坏情况O(n^2)
     * 最好情况O(n^2)
     * 平均情况O(n^2)
     * 空间复杂度O(1)
     * @param numbers 随机数组
     */
    public static void selectSort(Integer[] numbers){
        for (int i = 0; i < numbers.length-1; i++) {
            int min=i;
            System.out.println("第"+i+"轮：");
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[j]<numbers[min]){
                    min=j;
                }
            }
            if (i != min) {
                SortUtil.swapArray(numbers,i,min);
                List<Integer> integers = Arrays.asList(numbers);
                System.out.println(integers);
            }
        }
    }

    /**
     * 插入排序
     * 最坏情况O(n^2)
     * 最好情况O(n)
     * 平均情况O(n^2)
     * 空间复杂度O(1)
     * @param numbers 随机数组
     */
    public static void insertSort(Integer[] numbers){
        for (int i = 1; i < numbers.length; i++) {//遍历a[]数组2
            int temp=numbers[i];
            if (numbers[i]<numbers[i-1]) {//如果当前数小于前一个数
                int j=i-1;
                for (; j >=0 &&numbers[j]>temp ; j--) {//遍历前面所有数--有序数列
                    numbers[j+1]=numbers[j];
                    List<Integer> integers = Arrays.asList(numbers);
                    System.out.println(integers);
                }
                numbers[j+1]=temp;//此时的j+1不等于i，因为进行了一次j--，j+1实际等于j
                System.out.println("----------------------");
            }
        }
    }

    /**
     * 希尔排序
     * @param numbers 随机数组
     */
    public static void shellSort(Integer[] numbers){
        //先获取步长
        int h=1;//步长初始化
        while(h<(numbers.length)>>1){//numbers.length=7 h<=3,分为三组{5,4},{9,6},{2，1}
            h=h*2+1;//1*2+1=3
        }
        while(h>0) {
            for (int i = h; i < numbers.length; i++) {//从索引为3开始遍历，比较时，-3即可
                int temp = numbers[i];//记录右边的值
                if (numbers[i] < numbers[i - h]) {//前面的值大于后面的值，交换
                    int j = i-h;//记录左边的索引
                    for (; j >=0&&numbers[j] - temp > 0 ; j-=h) {//numbers[j]
                        numbers[j+h] = numbers[j];
                        System.out.println("--------start---------"+temp);
                        System.out.println(Arrays.toString(numbers));
                    }
                    numbers[j+h] = temp;
                }
                System.out.println(Arrays.toString(numbers));
            }
            h=(h-1)/2;
        }
    }

    /**
     * 快速排序
     * @param numbers 随机数组
//     * @return Integer[]
     */
    public static void quickSort(Integer[] numbers){
        // 对 arr 进行拷贝，不改变参数内容
//        Integer[] arr = Arrays.copyOf(numbers, numbers.length);
        recursionSort(numbers, 0, numbers.length - 1);
    }

    /**
     * 递归分区
     * @param arr 随机数组
     * @param left 左分区
     * @param right 右分区
     */
    private static void recursionSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            recursionSort(arr, left, partitionIndex - 1);
            recursionSort(arr, partitionIndex + 1, right);
        }
    }

    /**
     * 根据基准值获取分区值
     * @param arr 随机数组
     * @param left 左分区范围
     * @param right 右分区范围
     * @return int
     */
    private static int partition(Integer[] arr, int left, int right) {
        // 设定基准值（pivot）
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                SortUtil.swapArray(arr, i, index);
                index++;
            }
        }
        SortUtil.swapArray(arr, left, index - 1);
        return index - 1;
    }

    /**
     * 归并排序
     * @param numbers 随机数组
     * @return Integer[]
     */
    public static Integer[] mergeSort(Integer[] numbers){
        // 对arr进行拷贝，不改变参数内容
        Integer[] arr = Arrays.copyOf(numbers, numbers.length);
        if (arr.length <= 1) {
            return arr;
        }
        //将一个数组分为两份
        int middle = (int) Math.floor(arr.length>>1);
        Integer[] left = Arrays.copyOfRange(arr, 0, middle);
        Integer[] right = Arrays.copyOfRange(arr, middle, arr.length);
        System.out.println("sort left"+Arrays.toString(left));
        System.out.println("sort right"+Arrays.toString(right));
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 分区
     * @param left 左分区
     * @param right 右分区
     * @return Integer[]
     */
    private static Integer[] merge(Integer[] left, Integer[] right) {
        //准备一个空闲数组空间
        Integer[] result = new Integer[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            System.out.println("left第"+i+"轮："+Arrays.asList(left));
            System.out.println("right第"+i+"轮："+Arrays.asList(right));
            //如果左边小于等于右边，就把左边放到空闲数组中
            //如果右边小于左边，就把右边放到空闲数组中
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                //剔除掉放入到空闲数组中的数据，left长度会变小，最终跳出循环
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                //剔除掉放入到空闲数组中的数据，right长度会变小，最终跳出循环
                right = Arrays.copyOfRange(right, 1, right.length);
            }
            System.out.println("result第"+i+"轮："+Arrays.asList(result));
        }
        //如果右边的数据由于小于左边的数据太多，就会导致right先进入result，left.length>0,此时只需要把
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
            System.out.println("result第"+i+"轮："+Arrays.asList(result));
        }
        //如果右边的数据由于小于左边的数据太多，就会导致right先进入result，left.length>0
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
            System.out.println("result第"+i+"轮："+Arrays.asList(result));
        }
        System.out.println("----------------------------------------------------------------");
        return result;
    }

    /**
     * 堆排序
     * @param numbers 随机数组
     */
    public static void heapSort(Integer[] numbers){
        // 对 arr 进行拷贝，不改变参数内容
//        Integer[] arr = Arrays.copyOf(numbers, numbers.length);

        int len = numbers.length;
        buildMaxHeap(numbers, len);
        for (int i = len - 1; i > 0; i--) {
            swapArray(numbers, 0, i);
            len--;
            heapTree(numbers, 0, len);
        }
    }

    /**
     * 建立堆
     * @param arr 随机数组
     * @param len 数组长度
     */
    private static void buildMaxHeap(Integer[] arr, int len) {
        for (int i = (int) Math.floor(len>>1); i >= 0; i--) {
            heapTree(arr, i, len);
        }
    }

    /**
     * 递归构建堆
     * @param arr 随机数组
     * @param i 堆节点
     * @param len 数组长度
     */
    private static void heapTree(Integer[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            SortUtil.swapArray(arr, i, largest);
            heapTree(arr, largest, len);
        }
    }

    /**
     * 计数排序
     * @param numbers 随机数组
     */
    public static void countingSort(Integer[] numbers){
        // 对 arr 进行拷贝，不改变参数内容
//        Integer[] arr = Arrays.copyOf(numbers, numbers.length);

        int maxValue = SortUtil.getMaxValue(numbers);

        counting(numbers, maxValue);
    }

    /**
     * 计数操作
     * @param arr 随机数组
     * @param maxValue 最大值
     */
    private static void counting(Integer[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
    }

    /**
     * 基数排序
     * @param numbers 随机数组
     */
    public static void radixSort(Integer[] numbers) {
        // 对 arr 进行拷贝，不改变参数内容
//        Integer[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        /*
         * 获取最高位数
         */
        int maxValue = SortUtil.getMaxValue(numbers);
        int maxDigit= getNumLength(maxValue);
        radix(numbers, maxDigit);
    }

    /**
     * 判断基数的最高位
     * @param num 基数长度
     * @return int
     */
    private static int getNumLength(long num) {
        if (num == 0) {
            return 1;
        }
        int length = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            length++;
        }
        return length;
    }

    /**
     * 基数比较
     * @param arr 随机数组
     * @param maxDigit 最高位
     */
    private static void radix(Integer[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            Integer[][] counter = new Integer[mod * 2][0];

            for (Integer integer : arr) {
                int bucket = ((integer % mod) / dev) + mod;
                counter[bucket] = SortUtil.arrayAppend(counter[bucket], integer);
            }

            int pos = 0;
            for (Integer[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }
    }

    /**
     * 桶排序
     * @param numbers 随机数组
     */
    public static void bucketSort(Integer[] numbers){
        // 对 arr 进行拷贝，不改变参数内容
//        Integer[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = numbers.length;
        int bucketSize=length/2;
        bucket(numbers, bucketSize);
    }

    /**
     * 分桶
     * @param arr 随机数组
     * @param bucketSize 桶大小
     */
    private static void bucket(Integer[] arr, int bucketSize){
        if (arr.length == 0) {
            return;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
        int size = (maxValue - minValue) / bucketSize;
        int bucketCount = (int)Math.floor(size) + 1;
        Integer[][] buckets = new Integer[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (Integer integer : arr) {
            int i = (integer - minValue) / bucketSize;
            int index = (int) Math.floor(i);
            buckets[index] = arrayAppend(buckets[index], integer);
        }

        int arrIndex = 0;
        for (Integer[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            insertSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
    }
    /**
     * 数组数据交换
     * @param arr 随机数组
     * @param i 第i个下标
     * @param j 第j个下标
     */
    public static void swapArray(Integer[] arr,int i,int j){
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    /**
     * 自动扩容，并保存数据
     * @param arr 随机数组
     * @param value 扩容长度
     */
    private static Integer[] arrayAppend(Integer[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     * 获取数组最大值
     * @param arr 随机数组
     * @return int
     */
    public static int getMaxValue(Integer[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
