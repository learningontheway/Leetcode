package LeftGod.video.BasicClass.classes_04;

/**
 * 打印两个有序链表的值相同的公共部分
 */
public class CommanPart {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value=value;
        }
    }

    public static void printComman(Node head1,Node head2){
        while (head1!=null&&head2!=null){
            if(head1.value<head2.value) head1=head1.next;
            else if(head1.value>head2.value) head2=head2.next;
            else {
                System.out.print(head1.value+" ");
                head1=head1.next;
                head2=head2.next;
            }
        }
        System.out.println();

    }
    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);
        printComman(node1,node2);
    }
}
