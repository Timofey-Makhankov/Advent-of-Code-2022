import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        File text = new File("src/Advent_of_Code_2022_Input_1.txt");
        BufferedReader br = new BufferedReader(new FileReader(text));
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Elf> elfs = new ArrayList<>();
        String tmp;

        while ((tmp = br.readLine()) != null) {
            if (tmp.equals("")){
                input.add(0);
            } else {
                input.add(Integer.parseInt(tmp));
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int num:input) {
            if(num == 0){
                Elf elf = new Elf(temp);
                elfs.add(elf);
                temp = new ArrayList<>();
            } else {
                temp.add(num);
            }
        }

        int highestCalories = 0;
        int secondHighest = 0;
        int thirdHighest = 0;

        for (Elf elf:elfs) {
            int total = elf.getTotalSize();
            if (total > highestCalories){
                thirdHighest = secondHighest;
                secondHighest = highestCalories;
                highestCalories = elf.getTotalSize();
            } else if(total < highestCalories && total > secondHighest){
                thirdHighest = secondHighest;
                secondHighest = total;
            } else if (total < highestCalories && total < secondHighest && total > thirdHighest) {
                thirdHighest = total;
            }
        }

        System.out.println(highestCalories + secondHighest + thirdHighest);
    }
}
