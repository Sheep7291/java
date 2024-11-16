package learning.trainingPlan.service;

import learning.trainingPlan.entity.TrainingPlanUser;
import learning.trainingPlan.exception.UserAlreadyExistException;
import learning.trainingPlan.repository.TrainingPlanUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final TrainingPlanUserRepository trainingPlanUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void addUser(String username, String password, String roles){
        try{
            IfUserAlreadyExist(username);
            TrainingPlanUser trainingPlanUser = new TrainingPlanUser();
            trainingPlanUser.setUsername(username);
            trainingPlanUser.setPassword(bCryptPasswordEncoder.encode(password));
            trainingPlanUser.setRoles(roles.toUpperCase());
            trainingPlanUserRepository.save(trainingPlanUser);;
        }catch (UserAlreadyExistException ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        }

    }

    public void IfUserAlreadyExist(String username)throws UserAlreadyExistException {
        Optional<TrainingPlanUser> user =trainingPlanUserRepository.findByUsername(username);
        if(user.isPresent()) {
            throw new UserAlreadyExistException("User already exist");
        }
    }
}