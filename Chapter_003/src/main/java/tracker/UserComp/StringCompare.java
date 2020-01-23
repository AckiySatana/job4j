package tracker.UserComp;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override

    /**
     * Если длина строк одинакова и строки равня то возвращаем 0
     * Если длина строк разная, но одна одна строка расширяет вторую - 1 для меньшей 1 для большей
     * Иначе простое посимвольное сравнение символа типа Char
     */
    public int compare(String left, String right) {
        int result=99, mlength = Math.min(left.length(),right.length());
       if (left.equals(right)) {
            result = 0;
         } else {
            if (right.substring(0,mlength).equals(left.substring(0,mlength) )){
                result = left.length()==mlength ? -1: 1;
            } else {
                for (int i=0; i<mlength;i++){
                   if (left.charAt(i)==right.charAt(i)){
                       continue;
                   } else {
                      result = left.charAt(i)< right.charAt(i)? -1: 1;
                      break;
                   }
                }
            }
        }
        return result;
    }
}
