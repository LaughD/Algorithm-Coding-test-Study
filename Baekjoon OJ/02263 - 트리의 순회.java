/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02263 - 트리의 순회, https://www.acmicpc.net/problem/2263
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder string = new StringBuilder();
    static int[] inorder;
    static int[] postorder;
    static int[] inorderIndex;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int numOfNodes = Integer.parseInt(reader.readLine());
        inorder = new int[numOfNodes];
        postorder = new int[numOfNodes];
        inorderIndex = new int[1 + numOfNodes];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numOfNodes; i++)
            inorderIndex[inorder[i] = Integer.parseInt(tokenizer.nextToken())] = i;
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numOfNodes; i++)
            postorder[i] = Integer.parseInt(tokenizer.nextToken());

        numOfNodes--;
        findPreorder(0, numOfNodes, 0, numOfNodes);
        System.out.print(string);
    }

    public static void findPreorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd)
            return;
        if (inStart == inEnd) {
            string.append(inorder[inStart]).append(' ');
            return;
        }
        int inorderRootIndex = inorderIndex[postorder[postEnd]];
        int postRightStart = inorderRootIndex - inStart + postStart;
        string.append(postorder[postEnd]).append(' ');
        findPreorder(inStart, inorderRootIndex - 1, postStart, postRightStart - 1);
        findPreorder(inorderRootIndex + 1, inEnd, postRightStart, postEnd - 1);
    }
}
