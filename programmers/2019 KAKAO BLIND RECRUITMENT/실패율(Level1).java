/*
    Code written on Dec 29, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 실패율(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/42889
*/
import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        Integer[] indexes = new Integer[N];
        float[] failureRates = new float[N+2];
        int numUsers = stages.length;

        for (int stage: stages) {
            failureRates[stage]++;
        }

        for (int i = 1; i <= N; i++) {
            if (numUsers != 0) {
                float failedUsers = failureRates[i];
                failureRates[i] /= numUsers;
                numUsers -= failedUsers;
            }
            indexes[i-1] = i;
        }

        Arrays.sort(indexes, (idx1, idx2) -> {
            if (failureRates[idx2] != failureRates[idx1]) {
                return failureRates[idx2] > failureRates[idx1] ? 1 : -1;
            } else {
                return idx1 - idx2;
            }
        });

        return Arrays.stream(indexes).mapToInt(i -> i).toArray();
    }
}
