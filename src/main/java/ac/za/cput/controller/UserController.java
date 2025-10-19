package ac.za.cput.controller;

import ac.za.cput.domain.User;
import ac.za.cput.factory.UserFactory;
import ac.za.cput.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        User newUser = UserFactory.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getRoleId(), user.getAddress());
        return userService.create(newUser);
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable String id) {
        return userService.read(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return userService.delete(id);
    }

    @GetMapping("/getall")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/findbyemail/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
