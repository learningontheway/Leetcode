package LeftGod.video.BasicClass.classes_04;

import java.util.Stack;

/**
 * 判断一个链表的节点存储的数是否能够构成回文数
 */
public class Palindromes {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value=value;
        }
    }
    //利用栈的结构把整个链表逆序后在进行比较，注意这里比较的是每个节点的值
    //笔试推荐这种方法，笔试的策略是在og的前提下越简单越好
    public static Boolean Palindromes(Node head){
        Stack<Node> stack=new Stack<>();
        Node p=head;
        while (p!=null){
           stack.push(p);
           p=p.next;
        }
        while (head!=null){
            if(stack.pop().value!=head.value){
                System.out.println("不是回文数");
                return false;
            }
            head=head.next;
        }
        System.out.println("是回文数");
        return true;
    }
    //利用快指针慢指针进行链表比较，当快指针指向链表尾部时，慢指针指向链表的中部(若为偶数则指向靠前的哪一个)
    //然后把链表的后半部分逆序，即1->2->2->1变成1->2<-2<-1的形式，判断完是否是回文数之后再把结构修改回来
    public static Boolean isPalindromes(Node head){
        Node f=head,s=head;
        Boolean flag=false;
        while (f.next!=null&&f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        if(f.next!=null) f=f.next;
        Node p=s.next;
        s.next=null;
        Node q=null;
        while (p!=null){
            q=p.next;
            p.next=s;
            s=p;
            p=q;
        }
        p=f;
        while (head!=null&&head!=p){
            if(head.value==p.value){
                head=head.next;
                p=p.next;
            }else break;
        }
        if(head==null||head==p) flag=true;
        p=f.next;
        f.next=null;
        q=null;
        while (p!=null){
            q=p.next;
            p.next=f;
            f=p;
            p=q;
        }
        if(flag==true)
            System.out.println("是回文数");
        else
            System.out.println("不是回文数");
        return flag;
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(2);
        head.next.next.next=new Node(1);
        head.next.next.next.next=new Node(1);

        Palindromes(head);
        System.out.println("================");
        isPalindromes(head);
    }
}
