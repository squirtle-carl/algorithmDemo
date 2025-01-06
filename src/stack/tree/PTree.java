package stack.tree;

/**
 * @author caihuaxin
 * @version 1.0.0
 * @doc ptree
 * @date 2023-07-28
 */
public class PTree {
    private static final int MAX_TREE_SIZE = 100;
    /**
     * 根的位置
     */
    private int r;
    /**
     * 结点数
     */
    private int n;
    /**
     * 结点数组
     */
    private PTNode[] nodes;

    /**
     * @author caihuaxin
     * @version 1.0.0
     * @doc ptnode
     * @date 2023-07-28
     */
    private static class PTNode {
        /**
         * 数据域
         */
        private int data;
        /**
         * 双亲结点索引
         */
        private int parent;
    }

    /**
     * @author caihuaxin
     * @version 1.0.0
     * @doc 元素类型
     * @date 2023-07-28
     */
    private static class TElemType {
        // 树结点的数据类型，可以是整型也可以是其他数据类型
        // 在这里定义合适的数据类型
    }

    public PTree() {
        nodes = new PTNode[MAX_TREE_SIZE];
        r = 0;
        n = 0;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public static void main(String[] args) {
        PTree pTree = new PTree();
        pTree.setR(5);
        System.out.println(pTree);
    }
}
