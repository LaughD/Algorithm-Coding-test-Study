/*
    Code written on Apr 17, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18353번: 병사 배치하기
    link: https://www.acmicpc.net/problem/18353
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfForces = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] forces = new int[numOfForces];
        for (int index = numOfForces - 1; index >= 0; index--)
            forces[index] = Integer.parseInt(st.nextToken());

        int lastIndex = 0;
        int[] remainingForces = new int[numOfForces];
        Arrays.fill(remainingForces, 10_000_001);
        remainingForces[0] = forces[0];
        for (int index = 1; index < numOfForces; index++) {
            if (remainingForces[lastIndex] < forces[index]) {
                lastIndex++;
                remainingForces[lastIndex] = forces[index];
            } else if (remainingForces[lastIndex] > forces[index]) {
                int indexToInsert = Arrays.binarySearch(remainingForces, forces[index]);
                if (indexToInsert < 0) {
                    remainingForces[-indexToInsert - 1] = forces[index];
                }
            }
        }
        System.out.print(numOfForces - lastIndex - 1);
    }
}
