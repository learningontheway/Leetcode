package LeftGod.video.BasicClass.classes_05;


import java.math.BigDecimal;
import java.util.PriorityQueue;

public class test {
    public static class Node{
        public int profit;
        public int cost;
        public BigDecimal profitRate;
        public Node(int profit,int cost){
            this.profit=profit;
            this.cost=cost;
            this.profitRate=BigDecimal.valueOf((double)profit/cost);
        }
    }
    public static class Comparator implements java.util.Comparator<Node>{
        //从大到小排序
        @Override
        public int compare(Node o1, Node o2) {
            return o2.profitRate.compareTo(o1.profitRate);
        }


    }
    public static void main(String[] args) {
        PriorityQueue<Node> priorityQueue=new PriorityQueue<Node>(new Comparator());
        priorityQueue.add(new Node(5,20));
        priorityQueue.add(new Node(5,30));
        priorityQueue.add(new Node(6,40));
        priorityQueue.add(new Node(8,20));
        priorityQueue.add(new Node(7,90));
        priorityQueue.add(new Node(8,70));

        Integer num=priorityQueue.poll().cost;
        System.out.println(num);
    }
}
