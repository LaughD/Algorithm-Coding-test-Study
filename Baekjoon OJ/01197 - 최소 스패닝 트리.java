/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01197 - 최소 스패닝 트리, https://www.acmicpc.net/problem/1197
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
    static int[] parentVertex;
    static int numOfVertices;
    static int numOfEdges;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        numOfVertices = Integer.parseInt(tokenizer.nextToken());
        numOfEdges = Integer.parseInt(tokenizer.nextToken());
        parentVertex = new int[1 + numOfVertices];

        for (int vertex = 1; vertex <= numOfVertices; vertex++)
            parentVertex[vertex] = vertex;

        for (int i = 0; i < numOfEdges; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            priorityQueue.add(new Edge(
                    Integer.parseInt(tokenizer.nextToken()),
                    Integer.parseInt(tokenizer.nextToken()),
                    Integer.parseInt(tokenizer.nextToken()))
            );
        }

        printMSTWeight();
    }

    public static void printMSTWeight() {
        int weight = 0;
        int connectedVertices = 1;

        while (connectedVertices != numOfVertices) {
            Edge edge = priorityQueue.poll();
            if (findParentVertex(edge.vertexA) == findParentVertex(edge.vertexB))
                continue;
            unionVertices(edge.vertexA, edge.vertexB);
            connectedVertices++;
            weight += edge.weight;
        }
        System.out.print(weight);
    }

    public static int findParentVertex(int vertex) {
        if (parentVertex[vertex] == vertex)
            return vertex;
        return parentVertex[vertex] = findParentVertex(parentVertex[vertex]);
    }

    public static void unionVertices(int vertexA, int vertexB) {
        vertexA = parentVertex[vertexA];
        vertexB = parentVertex[vertexB];

        if (vertexA <= vertexB)
            parentVertex[vertexB] = vertexA;
        else
            parentVertex[vertexA] = vertexB;
    }
}

class Edge implements Comparable<Edge> {
    final int vertexA;
    final int vertexB;
    final int weight;

    public Edge(int vertexA, int vertexB, int weight) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
