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
        String tmp;

        while ((tmp = br.readLine()) != null) {
            if (tmp.equals("")){
                input.add(0);
            } else {
                input.add(Integer.parseInt(tmp));
            }
        }

        for (Integer num:input) {
            if (num == 0){
                System.out.print("\n");
            } else {
                System.out.println(num);
            }
        }

    }
}
