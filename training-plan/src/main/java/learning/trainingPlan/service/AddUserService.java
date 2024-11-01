package learning.trainingPlan.service;

import learning.trainingPlan.entity.TrainingPlanUser;
import learning.trainingPlan.repository.TrainingPlanUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddUserService {
    private final TrainingPlanUserRepository trainingPlanUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void addUser(String username, String password, String roles){
        TrainingPlanUser trainingPlanUser = new TrainingPlanUser();
        trainingPlanUser.setUsername(username);
        trainingPlanUser.setPassword(bCryptPasswordEncoder.encode(password));
        trainingPlanUser.setRoles(roles.toUpperCase());
        trainingPlanUserRepository.save(trainingPlanUser);
    }
}
