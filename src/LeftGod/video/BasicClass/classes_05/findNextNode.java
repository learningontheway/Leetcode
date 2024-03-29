package LeftGod.video.BasicClass.classes_05;

/**
 * 找到在中序遍历中一个节点的下一个节点
 * 数据结构中带父节点
 */
public class findNextNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node findNextNode(Node head){
        if(head==null)return null;
        if(head.right!=null){
            return findLeft(head.right);
        }else {
            Node parent=head.parent;
            while (parent!=null&&parent.left!=head){
                head=parent;
                parent=parent.parent;
            }
            return parent;
        }
    }
    public static Node findLeft(Node head){
        if(head==null)return head;
        while (head.left!=null){
            head=head.left;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + findNextNode(test));
    }
}
