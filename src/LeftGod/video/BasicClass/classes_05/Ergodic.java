package LeftGod.video.BasicClass.classes_05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 实现树的先序中序后序遍历，并使用递归和非递归两个版本
 */
public class Ergodic {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void travel(Node head,int flag){
        if(head==null)return;
        //先序中序后序遍历在递归版本中都是同样的写法，区别之处在于打印数据的时机
        //flag传入1，2，3分别表示先序中序后续遍历
        if(flag==1)
            System.out.print(head.value+" ");
        travel(head.left,flag);
        if(flag==2)
            System.out.print(head.value+" ");
        travel(head.right,flag);
        if(flag==3)
            System.out.print(head.value+" ");
    }
    public static void levelTravel(Node head){
        Queue<Node> queue=new LinkedList<>();
        queue.add(head);
        if (head==null) return;
        while (!queue.isEmpty()){
            Node q=(Node) queue.poll();
            System.out.print(q.value+" ");
            if(q.left!=null) queue.add(q.left);
            if(q.right!=null)queue.add(q.right);
        }
        System.out.println();

    }
    //非递归的先序遍历
    public static void preTravel(Node head){
        Stack<Node> stack=new Stack<>();
        if(head==null) return;
        stack.push(head);
        while (!stack.empty()){
            head=stack.pop();
            System.out.print(head.value+" ");
            //注意是先放右子树，再放左子树
            if(head.right!=null){
                stack.push(head.right);
            }
            if(head.left!=null)
                stack.push(head.left);
        }
    }
    //非递归的中序遍历
    public static void inTravel(Node head){
            Stack<Node> stack=new Stack<>();
            if(head==null)return;
            while (!stack.empty()||head!=null){
                if(head!=null){
                    stack.push(head);
                    head=head.left;
                }
                else {
                    head=stack.pop();
                    System.out.println(head.value+" ");
                    head=head.right;
                }
            }
        System.out.println();
    }
    //非递归的后续遍历
    //简单方法，先序遍历是中左右，把先序中左右修改成中右左，然后在reverse一下，就得到左右中即后序遍历
    public static void posTravel(Node head){
        Stack<Node> stack=new Stack<>();
        Stack<Integer> output=new Stack<>();
        if(head==null) return;
        stack.push(head);
        while (!stack.empty()){
            head=stack.pop();
            //修改这部分输出为栈保存数据
            output.add(head.value);
            //修改子树进栈的先后顺序
            if(head.left!=null){
                stack.push(head.left);
            }
            if(head.right!=null)
                stack.push(head.right);
        }
        while (!output.empty()) {
            System.out.print(output.pop()+" ");
        }

    }
    public static void main(String[] args) {

        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left= new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        travel(head,1);
        System.out.println();
        System.out.print("in-order: ");
        travel(head,2);
        System.out.println();
        System.out.print("pos-order: ");
        travel(head,3);
        System.out.println();
        System.out.print("level-travel: ");
        levelTravel(head);
        System.out.println();

        // unrecursive
        System.out.println("==============unrecursive==============");
        System.out.print("pre-order: ");
        preTravel(head);
        System.out.println();
        System.out.print("in-order: ");

        System.out.println();
        System.out.print("pos-order: ");
        posTravel(head);



    }
}
