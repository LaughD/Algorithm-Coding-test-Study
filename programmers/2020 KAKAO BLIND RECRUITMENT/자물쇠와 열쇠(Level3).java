/*
    Code written on Oct 2, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 자물쇠와 열쇠(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/60059
*/
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int keySize = key.length;
        int lockSize = lock.length;
        int widenSize = key.length - 1;
        int[][] widenLock = new int[widenSize * 2 + lockSize][widenSize * 2 + lockSize];
        
        padding(lock, widenLock, lockSize, widenSize);
        
        for (int i = 0; i < 4; i++) {
            for (int row = 0; row < widenSize + lockSize; row++) {
                for (int col = 0; col < widenSize + lockSize; col++) {
                    insertKey(key, widenLock, keySize, row, col);
                    if (isUnlock(widenLock, lockSize, widenSize))
                       return true;
                    detatchKey(key, widenLock, keySize, row, col);
                }
            }
            key = revolveKey(key, keySize);
        }
        return false;
    }
    
    public void padding(int[][] lock, int[][] widenLock, int lockSize, int widenSize) {
        for (int i = widenSize; i < widenSize + lockSize; i++)
            for (int j = widenSize; j < widenSize + lockSize; j++)
                widenLock[i][j] = lock[i-widenSize][j-widenSize];
    }
        
    public void insertKey(int[][] key, int[][] widenLock, int keySize, int row, int col) {  
        for (int i = row; i < row + keySize; i++)
            for (int j = col; j < col + keySize; j++)
                widenLock[i][j] += key[i-row][j-col];
    }
    
    public void detatchKey(int[][] key, int[][] widenLock, int keySize, int row, int col) {
        for (int i = row; i < row + keySize; i++)
            for (int j = col; j < col + keySize; j++)
                widenLock[i][j] -= key[i-row][j-col];
    }
    
    public boolean isUnlock(int[][] widenLock, int lockSize, int widenSize) {
        for (int i = widenSize; i < widenSize + lockSize; i++)
            for (int j = widenSize; j < widenSize + lockSize; j++)
                if (widenLock[i][j] != 1)
                    return false;
        return true;
    }

    public int[][] revolveKey(int[][]key, int keySize) {
        int[][] revolvedKey = new int[keySize][keySize];

        for (int i = 0; i < keySize; i++)
            for (int j = 0; j < keySize; j++)
               revolvedKey[i][j] = key[j][keySize-1-i];
        return revolvedKey;
    }
}
