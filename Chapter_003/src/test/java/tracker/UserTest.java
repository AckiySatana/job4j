package tracker;

import org.junit.Test;
import tracker.UserComp.UserAscByAge;
import tracker.UserComp.UserAscByName;
import tracker.UserComp.UserDescByAge;
import tracker.UserComp.UserDescByName;

import static org.junit.Assert.*;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next().getName(), is(new User("Ivan", 31).getName()));
        assertThat(it.next().getName(), is(new User("Petr", 32).getName()));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void SortByName() {
        List<User> users = new ArrayList<User>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Ivan", 11));
        users.add(new User("Anton", 31));
        users.add(new User("Anton", 12));
        users.add(new User("Barbarian", 31));

        Collections.sort(users,new UserDescByName());
        assertThat(users.get(0).getName(), is(new User("Anton", 31).getName()));
        assertThat(users.get(1).getName(), is(new User("Anton", 32).getName()));
        assertThat(users.get(2).getName(), is(new User("Barbarian", 32).getName()));
    }

    @Test
    public void SortByNameAsc() {
        List<User> users = new ArrayList<User>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Ivan", 11));
        users.add(new User("Anton", 31));
        users.add(new User("Anton", 12));
        users.add(new User("Barbarian", 31));
        Iterator<User> it = users.iterator();
        Collections.sort(users,new UserAscByName());
        assertThat(users.get(0).getName(), is(new User("Petr", 31).getName()));
        assertThat(users.get(1).getName(), is(new User("Ivan", 32).getName()));
        assertThat(users.get(2).getName(), is(new User("Ivan", 32).getName()));
    }

    @Test
    public void SortByAge() {
        List<User> users = new ArrayList<User>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Ivan", 11));
        users.add(new User("Anton", 12));
        users.add(new User("Anton", 31));
        users.add(new User("Barbarian", 31));
        Iterator<User> it = users.iterator();
        Collections.sort(users,new UserDescByAge());
        assertThat(users.get(0).getAge(), is(new User("Petr", 11).getAge()));
        assertThat(users.get(1).getAge(), is(new User("Ivan", 12).getAge()));
        assertThat(users.get(2).getAge(), is(new User("Ivan", 31).getAge()));
    }

    @Test
    public void SortByAscAge() {
        List<User> users = new ArrayList<User>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Ivan", 11));
        users.add(new User("Anton", 12));
        users.add(new User("Anton", 31));
        users.add(new User("Barbarian", 31));
        Iterator<User> it = users.iterator();
        Collections.sort(users,new UserAscByAge());
        assertThat(users.get(0).getAge(), is(new User("Petr", 32).getAge()));
        assertThat(users.get(1).getAge(), is(new User("Ivan", 31).getAge()));
        assertThat(users.get(2).getAge(), is(new User("Ivan", 31).getAge()));
    }


    @Test
    public void DoubleSort() {
        List<User> users = new ArrayList<User>();
        users.add(new User("Petr", 32));
        users.add(new User("Petr", 313));
        users.add(new User("Anton", 313));
        users.add(new User("Petr", 12));
        users.add(new User("Ivan", 31));
        users.add(new User("Ivan", 11));
        users.add(new User("Anton", 12));
        users.add(new User("Anton", 31));
        users.add(new User("Barbarian", 31));
        Iterator<User> it = users.iterator();
        Collections.sort(users,new UserAscByAge().thenComparing(new UserDescByName()));
        assertThat(users.get(0).getName(), is(new User("Anton", 32).getName()));
        assertThat(users.get(1).getName(), is(new User("Petr", 31).getName()));
        assertThat(users.get(0).getAge(), is(new User("Petr", 313).getAge()));
        assertThat(users.get(1).getAge(), is(new User("Petr", 313).getAge()));
    }
}