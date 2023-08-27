package toy.com.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.com.entity.User;
import toy.com.repository.UserRepository;
import toy.com.service.UserService;
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User insertUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
