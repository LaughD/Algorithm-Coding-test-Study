/*
    Code written on Sep 24, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    이분탐색: 입국심사(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43238
*/
import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long min = Arrays.stream(times).min().getAsInt();
        long max = Arrays.stream(times).max().getAsInt() * ((long) n / (long) times.length + 1);
        long answer = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            long completed = 0;
            for (long time: times) {
                completed += (mid / time);
                if (completed >= n) {
                    max = mid - 1;
                    answer = mid;
                    break;
                }
            }
            if (completed < n)
                min = mid + 1;
        }

        return answer;
    }
}
