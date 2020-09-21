/*
    Code written on Sep 22, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    힙(Heap): 이중우선순위큐(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42628
*/
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        int size = 0;

        for (String operation: operations) {
            final String[] commandAndInt = operation.split(" ");            

            if (commandAndInt[0].equals("I")) {
                minHeap.add(Integer.parseInt(commandAndInt[1]));
                maxHeap.add(-Integer.parseInt(commandAndInt[1]));
                size++;
            } else if (size != 0) {
                if (commandAndInt[1].startsWith("-"))
                    minHeap.poll();
                else
                    maxHeap.poll();
                size--;
            }

            if (size == 0) {
                minHeap.clear();
                maxHeap.clear();
            }
        }

        return size == 0 ? new int[]{0, 0} : new int[]{-maxHeap.peek(), minHeap.peek()};
    }
}
