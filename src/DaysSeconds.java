import java.util.Scanner;

public class DaysSeconds {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        final int Seconds = 86400;
        System.out.println(n * Seconds);

    }
}


