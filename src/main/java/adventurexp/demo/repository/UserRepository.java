package adventurexp.demo.repository;

import adventurexp.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User validateUser(User user) {
        return user;
    }
}
