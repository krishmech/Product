package Spring.Project.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Spring.Project.Model.Users;
import Spring.Project.Service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user){
        userService.registerUser(user);
        return user;
    }
}
