package stack.linearList;

import java.util.Objects;

public class LinkList<T> {
    private class ListNode{
        public T data;
        public ListNode next;
        public ListNode (T data,ListNode next){
            this.data = data;
            this.next = next;
        }
        public ListNode(T data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    /**
     * 头结点
     */
    private ListNode head;
    /**
     * 尾结点
     */
    private ListNode tail;
    /**
     * 结点个数
     */
    private int size;
    /**
     * 初始化链表
     */
    public LinkList(){
        this.head = new ListNode(null,null);
        size = 0;
    }

    /**
     * 查找特定位置的链表节点，返回当前节点
     */
    public ListNode getElem(int index){
        //如果index小于0，或者大于链表结点的最大值
        if (index<0|| index>=size){
            return null;
        }else{
            //定义一个临时的结点对象(头结点)
            ListNode temp=head;
            for (int i = 0; i < index; i++) {
                //从头结点开始遍历到索引位置
                temp=temp.next;
            }
            return temp;
        }
    }

    /**
     * 添加节点到末尾
     * @param data 节点
     */
    public void insertElem(T data){
        ListNode temp = new ListNode(data);
        //链表为空时
        if (this.size == 0){
            head = temp;
            tail = head;
        }else{
            ListNode last  =  tail;
            last.next = temp;
            this.tail = temp;
        }
        this.size ++;
    }
    /**
     * 插入节点到指定位置
     */
    public void insertElem(T data,int index){
        if (index<0|| index>=size){
            return;
        }else{
            ListNode newNode = new ListNode(data);
            //在头结点插入元素
            if (index ==0){
                if(this.size >0){
                    ListNode temp = head;
                    newNode.next = temp;
                }
                head = newNode;
            }
            //在尾结点插入元素
            else if(index == this.size){
                ListNode temp = tail;
                temp.next = newNode;
                this.tail  = newNode;

            }else{
                //在中间插入元素
                ListNode preNode = getElem(index-1);
                newNode.next = preNode.next;
                preNode.next = newNode;
            }
        }
        size ++;
        if(size == 1){
            tail = head;
        }
    }

    /**
     * 删除指定位置的数据
     */
    public void deleteElem(int index){
        if (index <0 ||index >=this.size){
            System.out.println("删除超出范围");
            return;
        }else{
            //删除头结点
            if (index == 0){
                head = head.next;

            }else if(index == this.size-1){    //删除尾结点
                ListNode preNode = getElem(index -1);
                this.tail = preNode;
                preNode.next = null;
            }else{
                //删除中间结点
                ListNode preNode = getElem(index -1);
                preNode.next = preNode.next.next;
            }

        }
        this.size --;
    }

    /**
     * 移除末尾元素,并返回对应数据
     */
    public T deleteElem(){
        if (this.size ==0){
            System.out.println("链表为空，无法移除");
            return null;
        }
        //只有一个元素，移除后为空
        if (this.size == 1){
            T data = this.head.data;
            this.head = null;
            this.tail = this.head;
            this.size --;
            return data;
        }else{
            ListNode preNode = getElem(this.size-2);
            T data  = this.tail.data;
            preNode.next = null;
            this.tail = preNode;
            this.size --;
            return data;
        }

    }


    /**
     * 删除指定元素
     */
    public boolean deleteElem(T data){
        boolean flag = false;
        if(this.size == 0){
            return flag;
        }else{
            ListNode curNode = this.head;
            //元素位于第一个结点
            if (curNode.data == data){
                ListNode nextNode = curNode.next;
                head = nextNode;
                flag = true;
                //当前列表只有一个结点
                if (this.size ==1){
                    tail = head;
                }
                this.size --;
            }else {
                while (curNode != null) {
                    ListNode nextNode = curNode.next;
                    if (nextNode != null && nextNode.data == data) {
                        //删除元素为尾结点
                        if (nextNode.next ==null){
                            this.tail = curNode;
                            curNode.next = null;
                        }else{
                            //删除结点为中间结点
                            ListNode temp = curNode.next.next;
                            curNode.next = temp;

                        }

                        flag = true;
                        this.size --;
                        break;
                    }
                    curNode = curNode.next;
                }
            }

        }
        return flag;
    }

    /**
     * 输出链表
     */
    public void printLinkList(){
        if(this.size ==0){
            System.out.println("链表为空");
        }
        else {
            ListNode temp = head;
            System.out.print("目前的列表，头结点：" + head.data + ",尾结点:" + tail.data + ",整体：");
            while (temp != null) {
                System.out.print(temp.data + ",");
                temp = temp.next;
            }
            System.out.println();
        }

    }
    /**
     * 判断数据是否存在
     */
    public boolean containsNode(T data){
        ListNode temp=head;
        for (int i = 0; i < size; i++) {
            if(Objects.equals(temp.data,data)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    /**
     * 清空链表
     */
    public void clearLinkedList(){
        this.head = new ListNode(null,null);
        size = 0;
    }

    public static void main(String[] args) {
        LinkList<String> linkList =new LinkList<>();
        linkList.insertElem("Java");
        linkList.insertElem("python");
        linkList.insertElem("scala");
        linkList.insertElem("C++");
        System.out.println(linkList.getElem(0));
        linkList.insertElem("李白",2);
        System.out.println(linkList.getElem(0));
        linkList.deleteElem("李白");
        linkList.deleteElem(0);
        System.out.println(linkList.getElem(0));
        String s = linkList.deleteElem();
        System.out.println(linkList.getElem(0));
        System.out.println(linkList.containsNode("李白"));
        linkList.clearLinkedList();
        linkList.printLinkList();
    }
}