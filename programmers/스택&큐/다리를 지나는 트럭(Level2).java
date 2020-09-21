/*
    Code written on Aug 21, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    스택/큐: 다리를 지나는 트럭(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42583
*/
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> weightsOnBridge = new ArrayDeque<Integer>();
        ArrayDeque<Integer> goalLineTimes = new ArrayDeque<Integer>();
        int time = 0;

        for (int truckWeight: truck_weights) {
            while (truckWeight > weight) {
                weight += weightsOnBridge.pollFirst();
                if (time < goalLineTimes.getFirst())
                    time = goalLineTimes.pollFirst();
                else
                    goalLineTimes.pollFirst();
            }
            weight -= truckWeight;
            weightsOnBridge.addLast(truckWeight);
            goalLineTimes.addLast(time + bridge_length);
            time++;
        }

        return goalLineTimes.getLast() + 1;
    }
}
