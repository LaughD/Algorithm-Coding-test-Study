/*
    Code written on Feb 15, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 가사 검색(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/60060
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        HashMap<Integer, ArrayList<String>> wordsMap = new HashMap<>();
        HashMap<Integer, ArrayList<String>> reversedWordsMap = new HashMap<>();
        String[] reversedWords = new String[words.length];
        int[] answer = new int[queries.length];

        for (int i = 0; i < words.length; i++)
            reversedWords[i] = getReversedWord(words[i]);

        Arrays.sort(words);
        for (String word : words) {
            int wordLength = word.length();

            if (!wordsMap.containsKey(wordLength))
                wordsMap.put(wordLength, new ArrayList<>());
            wordsMap.get(wordLength).add(word);
        }

        Arrays.sort(reversedWords);
        for (String reversedWord : reversedWords) {
            int reversedWordLength = reversedWord.length();

            if (!reversedWordsMap.containsKey(reversedWordLength))
                reversedWordsMap.put(reversedWordLength, new ArrayList<>());
            reversedWordsMap.get(reversedWordLength).add(reversedWord);
        }

        for (int i = 0; i < queries.length; i++) {
            int queryLength = queries[i].length();
            int headIndex = 0;
            int tailIndex = 0;

            if (wordsMap.containsKey(queryLength)) {
                if (queries[i].charAt(0) != '?') {
                    String headQuery = queries[i].replace('?', 'a');
                    String tailQuery = queries[i].replace('?', 'z');
                    headIndex = Collections.binarySearch(wordsMap.get(queryLength), headQuery);
                    tailIndex = Collections.binarySearch(wordsMap.get(queryLength), tailQuery);
                } else {
                    String headQuery = getReversedWord(queries[i]).replace('?', 'a');
                    String tailQuery = getReversedWord(queries[i]).replace('?', 'z');
                    headIndex = Collections.binarySearch(reversedWordsMap.get(queryLength), headQuery);
                    tailIndex = Collections.binarySearch(reversedWordsMap.get(queryLength), tailQuery);
                }
            }
            answer[i] = headIndex - tailIndex;
        }

        return answer;
    }

    public String getReversedWord (String word){
        return (new StringBuffer(word)).reverse().toString();
    }
}
