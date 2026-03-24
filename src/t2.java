import java.io.*;
import java.util.*;

public class t2 {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();
        int m = n - 5;


        int[] costT = new int[m + 1];
        String tbank = "tbank";
        for (int i = 0; i <= m; i++) {
            int cnt = 0;
            for (int k = 0; k < 5; k++) {
                if (s.charAt(i + k) != tbank.charAt(k)) cnt++;
            }
            costT[i] = cnt;
        }


        int[] costS = new int[m + 1];
        String study = "study";
        for (int i = 0; i <= m; i++) {
            int cnt = 0;
            for (int k = 0; k < 5; k++) {
                if (s.charAt(i + k) != study.charAt(k)) cnt++;
            }
            costS[i] = cnt;
        }


        int[] prefMin = new int[m + 1];
        int[] suffMin = new int[m + 1];
        prefMin[0] = costS[0];
        for (int i = 1; i <= m; i++) {
            prefMin[i] = Math.min(prefMin[i - 1], costS[i]);
        }
        suffMin[m] = costS[m];
        for (int i = m - 1; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], costS[i]);
        }


        int ans = INF;
        for (int i = 0; i <= m; i++) {
            int leftBest = INF, rightBest = INF;
            if (i - 5 >= 0) {
                leftBest = prefMin[i - 5];
            }
            if (i + 5 <= m) {
                rightBest = suffMin[i + 5];
            }
            int best = Math.min(leftBest, rightBest);
            if (best != INF) {
                ans = Math.min(ans, costT[i] + best);
            }
        }


        for (int d = -4; d <= 4; d++) {
            if (d == 0) continue;
            int low = Math.max(0, -d);
            int high = Math.min(m, m - d);
            for (int i = low; i <= high; i++) {
                int cost = computeCost(s, i, d, tbank, study);
                if (cost < ans) {
                    ans = cost;
                }
            }
        }

        System.out.println(ans);
    }

    private static int computeCost(String s, int i, int d, String tbank, String study) {
        int cost = 0;

        for (int k = 0; k < 5; k++) {
            int pos = i + k;
            char chT = tbank.charAt(k);
            int l = k - d;
            if (l >= 0 && l < 5) {
                char chS = study.charAt(l);
                if (chT != chS) {
                    return INF;
                }
                if (s.charAt(pos) != chT) {
                    cost++;
                }
            } else {
                if (s.charAt(pos) != chT) {
                    cost++;
                }
            }
        }

        for (int l = 0; l < 5; l++) {
            int pos = i + d + l;
            int k = l + d;
            if (k >= 0 && k < 5) {
                continue;
            }
            char chS = study.charAt(l);
            if (s.charAt(pos) != chS) {
                cost++;
            }
        }
        return cost;
    }
}