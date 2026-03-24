import java.util.Scanner;

public class LeapYearCounter {
    public static void main (String[] args) {
        int year;
        Scanner in = new Scanner (System.in);
        year = in.nextInt();
        in.close();
        System.out.println((year/4) + (year/400) -(year/100));

            }
        }


