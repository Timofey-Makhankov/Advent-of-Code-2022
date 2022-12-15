import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Advent_of_Code_2022_Input_4.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> input = new ArrayList<>();
        String[] example = new String[]{"2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8"};

        while (sc.hasNextLine()) {
            input.add(sc.nextLine());
        }

        int total = 0;
        int total_2 = 0;

        for (String string : input) {
            if (isOverlapping(formatInput(string.split(",")))) {
                ++total;
            }
        }

        for (String string : input) {
            if (isOverlappingAtAll(formatInput(string.split(",")))) {
                ++total_2;
            }
        }

        System.out.println(total);
        System.out.println(total_2);
    }

    public static Boolean isOverlapping(int[] arr) {
        return arr[0] <= arr[2] && arr[1] >= arr[3] || arr[0] >= arr[2] && arr[1] <= arr[3];
    }

    public static Boolean isOverlappingAtAll(int[] arr) {
        return arr[0] <= arr[2] && arr[2] <= arr[1] || arr[2] <= arr[0] && arr[0] <= arr[3] ;
    }

    public static int[] formatInput(String[] string) {
        String[] split_1 = string[0].split("-");
        String[] split_2 = string[1].split("-");
        return new int[]{toInteger(split_1[0]), toInteger(split_1[1]), toInteger(split_2[0]), toInteger(split_2[1])};
    }

    public static int toInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            System.err.println("Number was not given");
        }
        return 0;
    }
}
