package tracker.UserComp;

import tracker.User;

import java.util.Comparator;

public class UserAscByName implements Comparator<User> {
    @Override
    public int compare(User user, User t1) {
        return t1.getName().compareTo(user.getName());
}
}
