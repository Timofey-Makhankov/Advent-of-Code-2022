import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        File text = new File("src/Advent_of_Code_2022_Input_2.txt");
        Scanner sc = new Scanner(text);
        ArrayList<String> input = new ArrayList<>();

        while (sc.hasNextLine()){
            input.add(sc.nextLine());
        }

        Map<String, Integer> hashMap_1 = new HashMap<>(9);
        hashMap_1.put("B X", 1);
        hashMap_1.put("C Y", 2);
        hashMap_1.put("A Z", 3);

        hashMap_1.put("A X", 4);
        hashMap_1.put("B Y", 5);
        hashMap_1.put("C Z", 6);

        hashMap_1.put("C X", 7);
        hashMap_1.put("A Y", 8);
        hashMap_1.put("B Z", 9);

        Map<String, Integer> hashMap_2 = new HashMap<>(9);
        hashMap_2.put("B X", 1);
        hashMap_2.put("C Y", 6);
        hashMap_2.put("A Z", 8);

        hashMap_2.put("A X", 3);
        hashMap_2.put("B Y", 5);
        hashMap_2.put("C Z", 7);

        hashMap_2.put("C X", 2);
        hashMap_2.put("A Y", 4);
        hashMap_2.put("B Z", 9);

        System.out.println(result(hashMap_1, input));
        System.out.println(result(hashMap_2, input));
    }

    public static int result(Map<String, Integer> hashMap, ArrayList<String> arr){
        int result = 0;
        for (String turn : arr) {
            result = result + hashMap.get(turn);
        }
        return result;
    }

}
