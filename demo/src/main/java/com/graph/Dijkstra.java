package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    private int n;
    private Integer[] prev;
    private List<List<Edge>> graph;

    public Dijkstra() {
    }

    public Dijkstra(int n) {
        this.n = n;
        createEmptyGraph();
    }

    public List<Integer> reconstructPath(int start, int end) {
        if (end < 0 || end >= n || start < 0 || start >= n)
            throw new IllegalArgumentException("Nó invalido");
        double distF = dijkstra(start, end);
        List<Integer> path = new ArrayList<>();
        if (distF == Double.POSITIVE_INFINITY)
            return path;
        for (Integer at = end; at != null; at = prev[at])
            path.add(at);
        Collections.reverse(path);
        return path;
    }

    public double dijkstra(int start, int end) {
        boolean[] visited = new boolean[n];
        double[] dist = new double[n];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[start] = 0;
        prev = new Integer[n];

        PriorityQueue<Node> pq = new PriorityQueue<>(2 * n, Node.getComparator());
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.getId()] = true;

            if (dist[node.getId()] < node.getValue())
                continue;

            List<Edge> edges = graph.get(node.getId());
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);

                if (visited[edge.getTo()])
                    continue;

                double newDist = dist[edge.getFrom()] + edge.getCost();
                if (newDist < dist[edge.getTo()]) {
                    prev[edge.getTo()] = edge.getFrom();
                    dist[edge.getTo()] = newDist;
                    pq.offer(new Node(edge.getTo(), dist[edge.getTo()]));
                }
            }
            if (node.getId() == end)
                return dist[end];
        }
        return Double.POSITIVE_INFINITY;
    }

    private void createEmptyGraph() {
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<Edge>());
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
        createEmptyGraph();
    }
    
    public void addEdge(int from, int to, int cost) {
        graph.get(from).add(new Edge(from, to, cost));
    }

    public List<List<Edge>> getGraph() {
        return graph;
    }
}