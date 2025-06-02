package learning.trainingPlan.controller;

import learning.trainingPlan.response.ResponseObject;
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
    public ResponseEntity<ResponseObject> addUser(@RequestParam String username, @RequestParam String password, @RequestParam String roles) {
        userService.addUser(username, password, roles);
        ResponseObject responseObject = new ResponseObject("User added");
        return ResponseEntity.ok(responseObject);

    }

    @PostMapping("/register")
    public ResponseEntity<ResponseObject> registerUser(@RequestParam String username, String password) {
        String roles = "USER";
        userService.addUser(username, password, roles);
        ResponseObject responseObject = new ResponseObject("User add");
        return ResponseEntity.ok(responseObject);
    }


    @PutMapping("add-role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseObject> addRoleToUser(@RequestParam String username, String roles) {
        userService.addRolesToUser(username, roles.toUpperCase());
        ResponseObject responseObject = new ResponseObject("Roles to user added succesful");
        return ResponseEntity.ok(responseObject);
    }

    @GetMapping("/get-self-username")
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    @GetMapping("/check-if-user-is-logged")
    public boolean checkUser(Authentication authentication) {
        return authentication.isAuthenticated();
    }

}
