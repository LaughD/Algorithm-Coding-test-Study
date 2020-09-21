/*
    Code written on Sep 22, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    힙(Heap): 디스크 컨트롤러(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42627
*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] job1, int[] job2) {
                return job1[0] - job2[0];
            }
        });
        PriorityQueue<int[]> jobsQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] job1, int[] job2) {
                return job1[1] - job2[1];
            }
        });
        int currentTime = 0;
        int timeRequired = 0;
        int requestIndex = 0;
        
        for (int[] job: jobs) {
            if (currentTime < job[0])
                currentTime = job[0];
            while (requestIndex < jobs.length && currentTime >= jobs[requestIndex][0]) {
                jobsQueue.add(jobs[requestIndex]);
                requestIndex++;
            }
            int[] topPriority = jobsQueue.poll();
            currentTime += topPriority[1];
            timeRequired += (currentTime - topPriority[0]);
        }
        
        return timeRequired / jobs.length;
    }
}
