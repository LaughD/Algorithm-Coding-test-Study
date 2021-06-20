/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    15661 - 링크와 스타트, https://www.acmicpc.net/problem/15661
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] status;
    private static boolean[] isTeamBMember;
    private static int numOfPeople;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int teamAAbility = 0;
        numOfPeople = Integer.parseInt(reader.readLine());
        isTeamBMember = new boolean[numOfPeople];
        status = new int[numOfPeople][numOfPeople];
        for (int i = 0; i < numOfPeople; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < numOfPeople; j++) {
                teamAAbility += status[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        System.out.print(findMinGap(0, (numOfPeople + 1) / 2, teamAAbility, 0));
    }

    public static int findMinGap(int person, int numOfVacancies,
                                 int teamAAbility, int teamBAbility) {
        isTeamBMember[person] = true;
        for (int i = 0; i < numOfPeople; i++) {
            if (isTeamBMember[i])
                teamAAbility -= status[i][person] + status[person][i];
            else
                teamBAbility += status[i][person] + status[person][i];
        }

        if (teamAAbility <= teamBAbility) {
            isTeamBMember[person] = false;
            return teamBAbility - teamAAbility;
        }

        numOfVacancies--;
        if (numOfVacancies == 0) {
            isTeamBMember[person] = false;
            return teamAAbility - teamBAbility;
        }

        int gap = teamAAbility - teamBAbility;
        for (int i = person + 1; i < numOfPeople; i++) {
            gap = Math.min(findMinGap(i, numOfVacancies, teamAAbility, teamBAbility), gap);
            if (gap == 0)
                return 0;
        }
        isTeamBMember[person] = false;
        return gap;
    }
}
