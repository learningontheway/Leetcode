package LeftGod.video.AdvancedClass.class_04;



public class Morris {
    public static class Node{
        public int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }
    }
    public static void process(Node head,int flag){
        if(head==null) return;
        //flag 0,1,2分别代表先序中序后序
        if(flag==0) System.out.print(head.value+" ");
        process(head.left,flag);
        if(flag==1) System.out.print(head.value+" ");
        process(head.right,flag);
        if(flag==2) System.out.print(head.value+" ");
    }
    public static void MorrisIn(Node head){
        if(head==null) return;
        Node cur=head;
        Node mostRight=null;
        while (cur!=null){
            mostRight=cur.left;
            //先判断有无左子树
            if(mostRight!=null) {
                //找左子树的最右孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //如果MostRight的right指针指向空，让其指向cur，cur向左移动（cur=cur.left ）
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    //这里是第一次离开cur这个节点，如果有右子树，还可能回到该节点
                    cur = cur.left;
                    continue;
                } else {
                   // 如果MostRight的right指针指向cur，让其指回空，cur向右移动（cur=cur.right ）
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value+" ");
            //这里是最后一次离开这个节点，以后不可能再回到该节点了
            cur=cur.right;
        }

    }
    public static void MorrisPre(Node head){
        if(head==null) return;
        Node cur=head;
        Node mostRight=null;
        while (cur!=null){
            mostRight=cur.left;
            if(mostRight!=null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.print(cur.value+" ");
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            else {
                System.out.print(cur.value+" ");
            }
            cur=cur.right;
        }

    }
    public static void MorrisPos(Node head){
        if (head == null) {
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    printEdge(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        printEdge(head);
    }
    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        System.out.print("先序遍历为：");
        process(head, 0);
        System.out.print("\n中序遍历为：");
        process(head, 1);
        System.out.print("\n后序遍历为：");
        process(head, 2);
        System.out.print("\nMorris中序遍历为：");
        MorrisIn(head);
        System.out.print("\nMorris先序遍历为：");
        MorrisPre(head);
        System.out.print("\nMorris后序遍历为：");
        MorrisPos(head);
    }
}
