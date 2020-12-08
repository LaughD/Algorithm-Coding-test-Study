/*
    Code written on Dec 8, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 방문 길이(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/49994
*/
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        HashSet<String> pastRoad = new HashSet<>();
        int[] coord = new int[2];
        int[] newCoord;

        for (char dir: dirs.toCharArray()) {
            newCoord = moveCoord(dir, coord);
            if ((newCoord[0] <= 5) && (newCoord[0] >= -5) &&
                    (newCoord[1] <= 5) && (newCoord[1] >= -5)) {
                pastRoad.add(String.format("%d%d%d%d", 
                        coord[0], coord[1], newCoord[0], newCoord[1]));
                pastRoad.add(String.format("%d%d%d%d", 
                        newCoord[0], newCoord[1], coord[0], coord[1]));
                coord = newCoord;
            }
        }
        return pastRoad.size() / 2;
    }

    public int[] moveCoord(char dir, int[] coord) {
        int[] newCoord = coord.clone();
        
        switch (dir) {
            case 'U':
                newCoord[1] = coord[1] + 1;
                break;
            case 'D':
                newCoord[1] = coord[1] - 1;
                break;
            case 'L':
                newCoord[0] = coord[0] - 1;
                break;
            case 'R':
                newCoord[0] = coord[0] + 1;
                break;
        }
        return newCoord;
    }
}
