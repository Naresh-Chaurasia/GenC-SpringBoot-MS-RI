package in.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("/todos")
    public List<Map<String, Object>> getTodos() {
        List<Map<String, Object>> todos = new java.util.ArrayList<>();

        Map<String, Object> todo1 = new java.util.HashMap<>();
        todo1.put("rowNumber", 1);
        todo1.put("rowDescription", "Feed puppy 123");
        todo1.put("rowAssigned", "User One");

        Map<String, Object> todo2 = new java.util.HashMap<>();
        todo2.put("rowNumber", 2);
        todo2.put("rowDescription", "Water plants Again");
        todo2.put("rowAssigned", "User Two");

        todos.add(todo1);
        todos.add(todo2);

        return todos;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}