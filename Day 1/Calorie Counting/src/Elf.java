import java.util.ArrayList;

public class Elf {
    private ArrayList<Integer> backpack;

    public Elf(ArrayList<Integer> arr){
        this.backpack = arr;
    }

    public int getTotalSize(){
        int total = 0;
        for (Integer item :this.backpack) {
            total += item;
        }
        return total;
    }

    public ArrayList<Integer> getBackpack() {
        return backpack;
    }

    public void setBackpack(ArrayList<Integer> backpack) {
        this.backpack = backpack;
    }
}
