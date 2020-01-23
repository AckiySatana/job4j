package tracker.UserComp;

import java.util.Comparator;
import tracker.User;

public class UserDescByAge implements Comparator<User> {
    @Override
    public int compare(User user, User t1) {
        return Integer.compare(user.getAge(), t1.getAge());
    }
}
