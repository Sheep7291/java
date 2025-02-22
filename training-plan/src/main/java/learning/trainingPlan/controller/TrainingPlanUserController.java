package learning.trainingPlan.controller;

import learning.trainingPlan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class TrainingPlanUserController {

    private final UserService userService;

    @PostMapping("/createSingleUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addUser(@RequestParam String username, @RequestParam String password, @RequestParam String roles){
        userService.addUser(username, password, roles);
        return ResponseEntity.ok("User added");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String username, String password){
        String roles = "USER";
        userService.addUser(username, password, roles);
        return ResponseEntity.ok("User added");
    }


    @PutMapping("add-role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addRoleToUser(@RequestParam String username, String roles){
        userService.addRolesToUser(username, roles.toUpperCase());
        return ResponseEntity.ok("Roles to user added successful");
    }

    @GetMapping("/get-self-username")
    public String currentUserName(Authentication authentication){
        return authentication.getName();
    }

    @GetMapping("/check-if-user-is-logged")
    public boolean checkUser(Authentication authentication){
        return  authentication.isAuthenticated();
    }

}
