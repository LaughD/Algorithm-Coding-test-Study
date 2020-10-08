/*
    Code written on Oct 8, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    깊이/너비 우선 탐색(DFS/BFS): 네트워크(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43162
*/
/*
    2nd solution: Recursion 이용
*/
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networks = 0;
        
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                networks++;
                dfs(node, computers, visited);
            }
        }
        return networks;
    }
    
    public void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;
        for (int neighbor = 0; neighbor < computers[node].length; neighbor++) {
            if (computers[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, computers, visited);
            }
        }
    }
}


/*
    1st solution: Stack 이용
*/
/*
import java.util.ArrayDeque;

class Solution {
    public int solution(int n, int[][] computers) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[n];
        int networks = 0;
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                networks++;
                stack.addLast(i);
                while (!stack.isEmpty()) {
                    int node = stack.pollLast();
                    if (!visited[node]) {
                        visited[node] = true;
                        for (int neighbor = 0; neighbor < computers[node].length; neighbor++)
                            if (computers[node][neighbor] == 1 && !visited[neighbor]) {
                                stack.addLast(neighbor);
                            }
                    }
                }
            }
        }
        
        return networks;
    }
}
*/
