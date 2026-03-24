import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        int[] count = new int[10];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - '0']++;
        }

        char firstDigit = ' ';
        for (int d = 1; d <= 9; d++) {
            if (count[d] > 0) {
                firstDigit = (char) (d + '0');
                count[d]--;
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(firstDigit);
        for (int d = 0; d <= 9; d++) {
            for (int j = 0; j < count[d]; j++) {
                result.append((char) (d + '0'));
            }
        }

        System.out.println(result.toString());
    }
}