package stack.linearList;

import java.util.Objects;

/**
 * @author ：caihuaxin
 * @version ：JDK1.8
 * @description：顺序线性表
 * @date ：2022/9/30 10:05
 * @month_name ：9月
 */
public class SeqList {
    private int maxSize;//顺序表的最大长度

    private Object[] list;//顺序表空间

    private int length;//顺序表的实际长度

    /**
     * 创建线性表
     */
    public void initList(int maxSize){
        length=0;
        this.maxSize=maxSize;
        list=new Object[maxSize];
    }

    /**
     * 判断线性表是否为空
     */
    public boolean listEmpty(){
        return length==0;
    }

    /**
     * 清空线性表
     */
    public void listClear(){
        for (int i = 0; i < length; i++) {
            list[i] = null;
        }
        length = 0;
    }

//    public void distroyList(){
//        initList(maxSize);
//    }
    /**
     * 获取指定位置元素
     * 线性表从1开始，n结束
     */
    public Object getElem(int index){
        if(index<=0 || index>length) {
            return null;
        }
        return list[index-1];
    }

    /**
     * 获取与给定值相等的元素，查找成功，返回index，查找失败返回0
     */
    public int locateElem(Object element){
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (Objects.equals(list[i],element)){
                index=i+1;
                break;
            }
        }
        return index;
    }
    /**
     * 插入元素到线性表末尾
     */
    public void insertList(Object element){
        if(isFull()){
            System.out.println("线性表已达最大长度！");
        }else{
            list[length]=element;
            length++;
        }
    }

    /**
     * 判断线性表是否已满
     */
    public boolean isFull(){
        return length==maxSize;
    }

    /**
     * 获取顺序表的长度
     * @return
     */
    public int getLength() {
        return length;
    }
    /**
     * 删除线性表中指定位置的元素，返回删除值
     */
    public Object deleteElem(int index){
        if(index<1 || index>length){
            System.out.println("超出当前线性表长度");
            return null;
        }
        if(listEmpty()){
            System.out.println("线性表为空，无法删除");
            System.out.println();
            return null;
        }
        Object element=list[index-1];
        for (int i = index-1; i < length; i++) {
            list[i]=list[i+1];
        }
        length--;
        return element;
    }
    /**
     * 遍历当前线性表
     */
    public void iterator(){
        for (int i = 0; i < length; i++){
            System.out.println(list[i]);
        }
    }
}
