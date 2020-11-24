/*
    Code written on Nov 24, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 단속카메라(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42884
*/
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] prev, int[] next) {
                return prev[1] - next[1];
            }
        });
        
        int boundary = routes[0][1];
        int cameraCount = 1;
        
        for (int[] route: routes) {
            if (boundary < route[0]) {
                cameraCount++;
                boundary = route[1];
            }
        }
        return cameraCount;
    }
}
