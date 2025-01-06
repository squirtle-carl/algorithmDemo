package stack.linearList;

import java.util.Arrays;

/**
 * @author caihuaxin
 * @version 1.0.0
 * @doc 顺序链表
 * @date 2023-06-16
 */
public class SequenceList {
    /**
     * 顺序表的实际长度
     */
    private Integer length;

    /**
     * 顺序表
     */
    private Object[] list;

    /**
     * 顺序表的大小
     */
    private Integer size;

    /**
     * 构造函数初始化指定列表容量
     * @param size 大小
     * @return
     */
    public SequenceList(int size){
        length = 0;
        this.size = size;
        list = new Object[this.size];
    }

    /**
     * 顺序列表构造器默认初始化容量
     *
     * @return
     */
    public SequenceList(){
        length = 0;
        this.size = 16;
        list = new Object[this.size];
    }

    /**
     * 销毁线性表
     */
    public void destroy(){
        for (int i = 0; i < length; i++) {
            list[i] = null;
        }
        length = 0;
    }

    /**
     * 获取顺序表长度
     *
     * @return {@link Integer }
     */
    public Integer getLength(){
        return length;
    }

    /**
     * 按索引查找位置元素
     *
     * @param index 索引
     * @return {@link Object }
     */
    public Object local(int index){
        //如果索引超出数据的长度，则返回null
        if(index < 0 || index >= length){
            return null;
        }
        return list[index];
    }

    /**
     * 插入
     *
     * @param ele 元素
     */
    public void insert(Object ele){
        if(isFull()){
            //扩容
            addCapacity(length);
        }
        list[length] = ele;
        length++;
    }

    /**
     * 插入
     *
     * @param ele   元素
     * @param index 索引
     */
    public void insert(Object ele,int index){
        if(isFull()){
            //扩容
            addCapacity(length);
        }
        //从最后一个元素开始遍历，到index(包括index的数据)
        for (int i = length-1; i >= index; i--){
            list[i+1]=list[i];
        }
        list[index] = ele;
        length++;
    }
    /**
     * 增加容量
     *
     * @param length 长度
     */
    private void addCapacity(Integer length) {
        list = Arrays.copyOf(list, length+1);
        size++;
    }

    /**
     * 删除
     *
     * @param index 索引
     */
    public void delete(int index){
        if(index<0||index>=length){
            return;
        }
        if(!isEmpty()){
            for (int i = 0; i < length-1; i++) {
                list[i]=list[i+1];
            }
            length--;
        }
    }

    /**
     * 判空
     *
     * @return boolean
     */
    public boolean isEmpty(){
        return length == 0;
    }

    /**
     * 判溢
     *
     * @return boolean
     */
    public boolean isFull(){
        return length.equals(size);
    }

    public void printEle(){
        for (int i = 0; i < getLength(); i++) {
            System.out.println(local(i));
        }
    }

    public static void main(String[] args) {
        SeqList seqList=new SeqList();
        seqList.initList(20);
        seqList.insertList("Java");
        seqList.insertList("python");
        seqList.insertList("2");
        seqList.iterator();
        System.out.println(seqList.deleteElem(3));
        System.out.println("遍历当前线性表");
        seqList.iterator();
//        seqList.listClear();
        System.out.println("获取当前位置的元素："+seqList.getElem(1));
        System.out.println("获取当前元素的位置"+seqList.locateElem("Java"));
        System.out.println("顺序表的长度为："+seqList.getLength());
    }
}
