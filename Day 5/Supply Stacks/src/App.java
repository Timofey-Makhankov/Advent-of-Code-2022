import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Stack<Character>> location = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            location.add(new Stack<>());
        }

        File file = new File("src/Advent_of_Code_2022_Input_5.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> input = new ArrayList<>();
        ArrayList<int[]> commands = new ArrayList<>();

        initStack(location);

        while (sc.hasNextLine()){
            input.add(sc.nextLine());
        }

        for (String string: input) {
            commands.add(getCommands(string));
        }

        for (int[] command: commands) {
            for (int i = 0; i < command[0]; i++) {
                char item = location.get(command[1] - 1).pop();
                location.get(command[2] - 1).push(item);
            }
        }
        printResult(location);

        initStack(location);

        for (int[] command: commands) {
            ArrayList<Character> holder = new ArrayList<>();
            for (int i = 0; i < command[0]; i++) {
                holder.add(location.get(command[1] - 1).pop());
            }
            for (int i = holder.size(); i > 0; i--) {
                location.get(command[2] - 1).push(holder.get(i - 1));
            }
        }
        System.out.println();
        printResult(location);
    }

    public static int[] getCommands(String string){
        int[] result= new int[3];
        String[] split = string.split(" ");
        result[0] = Integer.parseInt(split[1]);
        result[1] = Integer.parseInt(split[3]);
        result[2] = Integer.parseInt(split[5]);
        return result;
    }

    public static void printResult(ArrayList<Stack<Character>> arr){
        for (Stack<Character> place: arr) {
            System.out.print(place.peek());
        }
    }

    public static void initStack(ArrayList<Stack<Character>> arr){
        // 1
        arr.get(0).empty();
        arr.get(0).push('Z');
        arr.get(0).push('T');
        arr.get(0).push('F');
        arr.get(0).push('R');
        arr.get(0).push('W');
        arr.get(0).push('J');
        arr.get(0).push('G');

        // 2
        arr.get(1).empty();
        arr.get(1).push('G');
        arr.get(1).push('W');
        arr.get(1).push('M');

        // 3
        arr.get(2).empty();
        arr.get(2).push('J');
        arr.get(2).push('N');
        arr.get(2).push('H');
        arr.get(2).push('G');

        // 4
        arr.get(3).empty();
        arr.get(3).push('J');
        arr.get(3).push('R');
        arr.get(3).push('C');
        arr.get(3).push('N');
        arr.get(3).push('W');

        // 5
        arr.get(4).empty();
        arr.get(4).push('W');
        arr.get(4).push('F');
        arr.get(4).push('S');
        arr.get(4).push('B');
        arr.get(4).push('G');
        arr.get(4).push('Q');
        arr.get(4).push('V');
        arr.get(4).push('M');

        // 6
        arr.get(5).empty();
        arr.get(5).push('S');
        arr.get(5).push('R');
        arr.get(5).push('T');
        arr.get(5).push('D');
        arr.get(5).push('V');
        arr.get(5).push('W');
        arr.get(5).push('C');

        // 7
        arr.get(6).empty();
        arr.get(6).push('H');
        arr.get(6).push('B');
        arr.get(6).push('N');
        arr.get(6).push('C');
        arr.get(6).push('D');
        arr.get(6).push('Z');
        arr.get(6).push('G');
        arr.get(6).push('V');

        // 8
        arr.get(7).empty();
        arr.get(7).push('S');
        arr.get(7).push('J');
        arr.get(7).push('N');
        arr.get(7).push('M');
        arr.get(7).push('G');
        arr.get(7).push('C');

        // 9
        arr.get(8).empty();
        arr.get(8).push('G');
        arr.get(8).push('P');
        arr.get(8).push('N');
        arr.get(8).push('W');
        arr.get(8).push('C');
        arr.get(8).push('J');
        arr.get(8).push('D');
        arr.get(8).push('L');
    }
}
