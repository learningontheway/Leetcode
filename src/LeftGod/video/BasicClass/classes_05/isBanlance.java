package LeftGod.video.BasicClass.classes_05;

/**
 * 判断一棵树是否是平衡二叉树
 */
public class isBanlance {
    public static Boolean flag=true;
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Boolean isBanlance(Node head){
        isBanlance(head,1);
        return flag;
    }
    public static int isBanlance(Node head,int level){
        if(head==null) return level;
        int lh=isBanlance(head.left,level+1);
        if(!flag){
            return level;
        }
        int rh=isBanlance(head.right,level+1);
        if(!flag){
            return level;
        }
        if(Math.abs(lh-rh)>1) {
            flag=false;
        }
        return Math.abs(lh-rh);
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBanlance(head));

    }
}
