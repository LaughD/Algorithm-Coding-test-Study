/*
    Code written on Sep 18, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    해시: 베스트앨범(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42579
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // genreTotal = {장르: 장르별 재생 수}
        // genreTotalReversal = {장르별 재생 수: 장르}
        // genreEach = {장르: {곡의 인덱스: 곡 재생 수}}
        HashMap<String, Integer> genreTotal = new HashMap<String, Integer>();
        TreeMap<Integer, String> genreTotalReversal = new TreeMap<Integer, String>();
        HashMap<String, HashMap<Integer, Integer>> genreEach = new HashMap<String, HashMap<Integer, Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] answer;

        for (int i = 0; i < genres.length; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
            if (!genreEach.containsKey(genres[i]))
                genreEach.put(genres[i], new HashMap<Integer, Integer>());
            genreEach.get(genres[i]).put(i, plays[i]);
        }

        for (String genre: genreTotal.keySet())
            genreTotalReversal.put(genreTotal.get(genre), genre);

        for (int i = 0; i < genreTotal.size(); i++) {
            int genrePlay = genreTotalReversal.lastKey();
            String genre = genreTotalReversal.get(genrePlay);
            genreTotalReversal.remove(genrePlay);
            for (int j = 0; j < 2; j++) {
                HashMap<Integer, Integer> songList = genreEach.get(genre);
                if (songList.isEmpty())
                    break;
                int songIndex = -1;
                int maxPlay = -1;
                for (HashMap.Entry<Integer, Integer> entry: songList.entrySet()) {
                    if (entry.getValue() > maxPlay) {
                        maxPlay = entry.getValue();
                        songIndex = entry.getKey();
                    }
                }
                result.add(songIndex);
                songList.remove(songIndex);
            }
        }

        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);

        return answer;
    }
}
