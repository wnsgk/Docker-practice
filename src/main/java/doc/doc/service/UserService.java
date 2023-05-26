package doc.doc.service;

import doc.doc.domain.User;
import doc.doc.repository.UserRepository;
import doc.doc.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RedisUtil redisUtil;

    public void createUser(String name){
        User user = User.builder()
                .name(name)
                .build();

        userRepository.save(user);
        redisUtil.setData("user", name);
    }

    public User getUser(String name){
        User user = userRepository.findByName(name);
        return user;
    }
}
