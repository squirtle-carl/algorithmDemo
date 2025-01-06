package stack.linearList;

/**
 * @author caihuaxin
 * @version 1.0.0
 * @doc 静态链表
 * @date 2023-06-21
 */
public class StaticList {
    private static class Node{
        /**
         * 数据域
         */
        private Object data;

        /**
         * 游标
         */
        private int cursor;
        public Node(int cursor,Object data) {
            this.cursor = cursor;
            this.data = data;
        }
        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public int getCursor() {
            return cursor;
        }

        public void setCursor(int cursor) {
            this.cursor = cursor;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", cursor=" + cursor +
                    '}';
        }
    }

    /**
     * 数组的大小
     */
    private int size;
    /**
     * 静态链表的长度
     */
    private int length;

    /**
     * 数组默认大小
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * 静态链表
     */
    private Node[] nodes;

    /**
     * 头结点
     */
    private Node head;

    /**
     * 尾结点
     */
    private Node tail;

    public StaticList(){
        this.size = DEFAULT_SIZE;
        this.nodes = new Node[size];
        for (int i = 0; i < this.size; i++) {
            nodes[i] = new Node(i+1,null);
        }
        nodes[size-1].setCursor(0);
        this.length = 0;
    }

    public StaticList(int capacity){
        this.size = capacity;
        this.nodes = new Node[size];
        for (int i = 0; i < this.size; i++) {
            nodes[i] = new Node(i+1,null);
        }
        nodes[size-1].cursor=0;
        this.length = 0;
    }

    /**
     * 添加(尾插)
     *
     * @param data 数据
     */
    public void add(Object data){
        //静态链表的长度等于数组的大小
        if(length==size){
            System.out.println("链表容量不足");
            return;
        }
        //获取链表中最后一个结点的游标
        int lastCursor = nodes[size - 1].getCursor();
        //获取链表中第一个结点的游标（即第一个结点指向的下个结点的索引）
        int firstCursor = nodes[0].getCursor();
        //将最后一个结点的游标设置为第一个结点的游标
        nodes[size-1].setCursor(firstCursor);
        //将第一个结点的游标设置为
        nodes[0].setCursor(nodes[firstCursor].getCursor());
        nodes[firstCursor].setCursor(lastCursor);
        nodes[firstCursor].setData(data);
        length++;
    }

    public void printNode() {
        for (int i = 0; i < this.length; i++) {
            System.out.println(nodes[i].data);
        }
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public boolean isFull(){
        return length==this.size;
    }

    public static void main(String[] args) {
        StaticList list = new StaticList();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        list.add("777");
        list.add("888");
        list.add("999");
        list.add("100");
        list.printNode();
    }
}
