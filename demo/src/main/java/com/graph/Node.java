package com.graph;

import java.util.Comparator;

public class Node {
    // Small epsilon getValue()() to comparing double getValue()s.
    private static final double EPS = 1e-6;

    private int id;
    private double value;

    public Node(int id, double value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node " + id + " value=" + value + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private static Comparator<Node> comparator = new Comparator<Node>() {
        @Override
        public int compare(Node node1, Node node2) {
            if (Math.abs(node1.getValue() - node2.getValue()) < EPS)
                return 0;
            return (node1.getValue() - node2.getValue()) > 0 ? +1 : -1;
        }
    };

    public static Comparator<Node> getComparator() {
        return comparator;
    }

}
