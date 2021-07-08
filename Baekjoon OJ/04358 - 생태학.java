/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    04358 - 생태학, https://www.acmicpc.net/problem/4358
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> counter = new HashMap<>();
    static double numOfTrees = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tree;

        while ((tree = reader.readLine()) != null) {
            numOfTrees++;
            counter.put(tree, counter.getOrDefault(tree, 0) + 1);
        }
        printRatio();
    }

    public static void printRatio() {
        StringBuilder string = new StringBuilder();
        Object[] species = counter.keySet().toArray();
        Arrays.sort(species);

        for (Object tree: species) {
            string.append(tree)
                    .append(' ')
                    .append(String.format("%.4f", counter.get(tree) * 100 / numOfTrees))
                    .append("\n");
        }

        System.out.print(string);
    }
}
