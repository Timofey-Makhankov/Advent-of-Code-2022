import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Advent_of_Code_2022_Input_3.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> input = new ArrayList<>();
        ArrayList<String[]> badges = new ArrayList<>();

        //String[] testCase = new String[]{
        //        "vJrwpWtwJgWrhcsFMMfFFhFp",
        //        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        //        "PmmdzqPrVvPwwTWBwg",
        //        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
        //        "ttgJtRGJQctTZtZT",
        //        "CrZsJsPPZsGzwwsLwLmpwMDw"
        //};

        while (sc.hasNextLine()){
            input.add(sc.nextLine());
        }

        int total = 0;

        for (String string: input) {
            String[] split = returnSplittedString(string);
            char character = getCommonChar(split);
            total += charValue(character);
        }

        int index = 0;
        String[] arr = new String[3];
        for (String string: input) {
            if (index == 2){
                arr[index] = string;
                badges.add(arr);
                index = 0;
                arr = new String[3];
            } else {
                arr[index] = string;
                index++;
            }
        }

        int total_2 = 0;

        for (String[] stringArr: badges) {
            char character = getCommonCharList(stringArr);
            total_2 += charValue(character);
        }

        //String[] split = returnSplittedString(testCase[1]);
        //char character = getCommonChar(split);
        //System.out.println(character);
        //System.out.println(charValue(character));

        System.out.println(total);
        System.out.println(total_2);
    }

    public static Boolean isUpperCase(char character){
        return character >= 65 && character <= 90;
    }

    public static String[] returnSplittedString(String input){
        int mid = input.length() / 2;
        return new String[]{input.substring(0, mid),input.substring(mid)};
    }

    public static char getCommonChar(String[] arr){
        for (int i = 0; i < arr[0].length(); i++) {
            char selected = arr[0].charAt(i);
            if (arr[1].indexOf(selected) != -1){
                return arr[0].charAt(i);
            }
        }
        return 0;
    }

    public static char getCommonCharList(String[] arr){
        for (int i = 0; i < arr[0].length(); i++) {
            char selected = arr[0].charAt(i);
            if (arr[1].indexOf(selected) != -1 && arr[2].indexOf(selected) != -1){
                return arr[0].charAt(i);
            }
        }
        return 0;
    }
    public static int charValue(char input){
        if (isUpperCase(input)){
            return (int)input - 38;
        } else {
            return (int)input - 96;
        }
    }
}
