package collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("coca_cola@yandex.ru", "Газировкин Лимонад Сиропчикович");
        map.put("barankin@yandex.ru", "Бубликов Пончик Кексович");
        for (String key: map.keySet()) {
            System.out.println(key + map.get(key));
         }
    }
}