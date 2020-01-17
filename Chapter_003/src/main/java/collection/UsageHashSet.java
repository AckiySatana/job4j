package collection;


import java.util.HashSet;
/*
2. Добавьте в коллекцию autos марки машин: Lada, BMV, Volvo, Toyouta.
3. Добавьте цикл for-each и выведите элементы коллекции HashSet на консоль.
4. Залейте код в репозиторий, оставьте ссылку на коммит и переведите ответственного на Петра Арсентьева.*/
public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<String>();
        autos.add("Lada");
        autos.add("BMV");
        autos.add("Volvo");
        autos.add("Toyouta");
        for (String auto: autos) {
            System.out.println(auto);
        }
    }
}