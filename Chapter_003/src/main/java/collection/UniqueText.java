package collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        // for-each origin -> new HashSet.
        for (String s : origin) {
            if (!check.contains(s)){
                check.add(s);
            }
        }
        for (String s : text) {
            if (!check.contains(s)){
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}