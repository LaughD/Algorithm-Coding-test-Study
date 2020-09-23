/*
    Code written on Sep 23, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 체육복(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/42862
*/
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> lostSet = new HashSet<Integer>();
        HashSet<Integer> reserveSet = new HashSet<Integer>();
        Arrays.sort(lost);

        for (int num: lost)
            lostSet.add(num);

        for (int num: reserve) {
            if (lostSet.contains(num))
                lostSet.remove(num);
            else
                reserveSet.add(num);
        }

        for (int num: lost) {
            if (lostSet.contains(num)) {
                if (reserveSet.contains(num-1)) {
                    lostSet.remove(num);
                    reserveSet.remove(num-1);
                } else if (reserveSet.contains(num+1)) {
                    lostSet.remove(num);
                    reserveSet.remove(num+1);
                }
            }
        }

        return n - lostSet.size();
    }
}
