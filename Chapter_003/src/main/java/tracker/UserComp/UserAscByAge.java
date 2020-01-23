package tracker.UserComp;

import tracker.User;

import java.util.Comparator;

public class UserAscByAge implements Comparator<User> {

    @Override
    public int compare(User user, User t1) {
        return Integer.compare(t1.getAge(),user.getAge());
    }
}
