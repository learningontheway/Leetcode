package LeftGod.video.AdvancedClass.class_04;

import java.util.*;

public class BuildingOutline {
    public static class Node {
        public boolean isUp;
        public int pos;
        public int height;

        public Node(boolean isUp, int position, int height) {
            this.isUp = isUp;
            this.pos = position;
            this.height = height;
        }
    }

    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.pos != o2.pos) {
                return o1.pos - o2.pos;
            }
            if (o1.isUp != o2.isUp) {
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }

    public static List<List<Integer>> buildingOutline(int[][] buildings) {
        Node[] nodes = new Node[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
            nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }
        Arrays.sort(nodes, new NodeComparator());
        TreeMap<Integer, Integer> htMap = new TreeMap<>();
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isUp) {
                if (!htMap.containsKey(nodes[i].height)) {
                    htMap.put(nodes[i].height, 1);
                } else {
                    htMap.put(nodes[i].height, htMap.get(nodes[i].height) + 1);
                }
            } else {
                if (htMap.containsKey(nodes[i].height)) {
                    if (htMap.get(nodes[i].height) == 1) {
                        htMap.remove(nodes[i].height);
                    } else {
                        htMap.put(nodes[i].height, htMap.get(nodes[i].height) - 1);
                    }
                }
            }
            if (htMap.isEmpty()) {
                pmMap.put(nodes[i].pos, 0);
            } else {
                pmMap.put(nodes[i].pos, htMap.lastKey());
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
            int curPosition = entry.getKey();
            int curMaxHeight = entry.getValue();
            if (height != curMaxHeight) {
                if (height != 0) {
                    List<Integer> newRecord = new ArrayList<Integer>();
                    newRecord.add(start);
                    newRecord.add(curPosition);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                start = curPosition;
                height = curMaxHeight;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //{1,2,1}表示一栋大楼左右边界为1，2，高度为3
        int[][] buildings={{1,2,1},{2,5,3},{4,6,5},{7,8,1}};
        System.out.println(buildingOutline(buildings));
    }
}
