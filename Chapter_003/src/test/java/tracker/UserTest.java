package tracker;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
        for (User user: users
             ) {
            System.out.println(user.getName());
        }
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
}