package doc.doc.controller;

import doc.doc.domain.User;
import doc.doc.service.UserService;
import doc.doc.service.dto.request.CreateUser;
import doc.doc.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RedisUtil redisUtil;
    @PostMapping
    public String createUser(@RequestBody CreateUser createUser) {
        userService.createUser(createUser.getName());

        return "ok";
    }

    @GetMapping("/redis")
    public String getRedis() {
        return redisUtil.getData("user");
    }

    @GetMapping
    public String createUser(@RequestParam String name) {
        User user = userService.getUser(name);
        if(user != null){
            return user.getName();
        } else {
            return "No User";
        }
    }

}