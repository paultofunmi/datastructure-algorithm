package com.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        Map<Integer, Node> dict = new HashMap<>();

        return doDfs(node, dict);
    }

    private Node doDfs(Node node, Map<Integer, Node> map) {

        Node temp = new Node(node.val);

        if(!map.containsKey(node.val)) {
            map.put(node.val, temp);
        }else {
            return map.get(node.val);
        }

        for(Node neighbor: node.neighbors) {

            List<Node> list = new ArrayList<>();
            if(temp.neighbors != null) {

                list = temp.neighbors;
            }

            list.add(doDfs(neighbor, map));
            temp.neighbors = list;
        }
        return temp;
    }
}
