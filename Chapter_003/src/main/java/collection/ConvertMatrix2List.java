package collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i :array) {
            for (int y:i) {
                list.add(y);
            }
        }
        return list;
    }
}


