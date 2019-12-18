package LeftGod.video.BasicClass.classes_04;

import java.util.HashSet;

/**
 * 判断一个链表有环还是无环,并返回入环的第一个节点
 * 1.用hashMap存储所有节点，当存储的一个节点已经被存储过时，该节点即为入环的第一个节点
 * 2.双指针：快指针一次走两步，慢指针一次走一步，如果快指针的next为null，说明无环，
 *      如果快指针和慢指针相遇，让快指针指向头节点，然后快指针和慢指针每次都走一步，相遇的节点即为入环节点
 */
public class RingList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value=value;
        }
    }
    public static Node RingListByHash(Node head){
        HashSet<Node> hashSet=new HashSet<>();
        Node p=head;
        while (p!=null){
            if(hashSet.contains(p)) return p;
            else {
                hashSet.add(p);
                p=p.next;
            }
        }
        return null;
    }
}
