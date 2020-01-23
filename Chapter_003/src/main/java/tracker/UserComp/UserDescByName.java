package tracker.UserComp;

import tracker.User;

import java.util.Comparator;

public class UserDescByName implements Comparator<User> {
    @Override
    public int compare(User user, User t1) {
        return user.getName().compareTo(t1.getName());
    }
}
