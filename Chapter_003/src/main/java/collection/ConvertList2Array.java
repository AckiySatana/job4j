package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            if (cell>=cells){
                cell = 0;
                row++;
            }
            array[row][cell] = num;
            cell++;
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list =  Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    }
}