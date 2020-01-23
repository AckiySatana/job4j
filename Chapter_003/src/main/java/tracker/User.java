package tracker;

import java.util.List;


import java.util.Objects;


public class User implements Comparable<User> {
    private String name;
    private int age;

    User(String name, int age) {
        setName(name);
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return name.equals(o.getName()) ? name.compareTo(o.name) : Integer.compare(age, o.getAge());
    }
}