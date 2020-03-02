package adventurexp.demo.service;

import adventurexp.demo.model.User;
import adventurexp.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User validateUser(User user) {
        return userRepository.validateUser(user);
    }
}
