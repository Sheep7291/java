package learning.trainingPlan.controller;

import learning.trainingPlan.service.AddUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class TrainingPlanUserController {

    private final AddUserService addUserService;

    @PostMapping("/createSignelUser")
    public void addUser(@RequestParam String username, @RequestParam String password, @RequestParam String roles){
        addUserService.addUser(username, password, roles);
    }

    @GetMapping("/getSelfUsername")
    public String currentUserName(Authentication authentication){
        return authentication.getName();
    }

}
