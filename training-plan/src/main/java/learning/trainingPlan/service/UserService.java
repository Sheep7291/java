package learning.trainingPlan.service;

import learning.trainingPlan.entity.TrainingPlanUser;
import learning.trainingPlan.entity.UserPossibleRoles;
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
            ifUserAlreadyExist(username);
            TrainingPlanUser trainingPlanUser = new TrainingPlanUser();
            trainingPlanUser.setUsername(username);
            trainingPlanUser.setPassword(bCryptPasswordEncoder.encode(password));
            trainingPlanUser.setUserPossibleRoles(UserPossibleRoles.valueOf(roles.toUpperCase()));
            trainingPlanUserRepository.save(trainingPlanUser);;
        }catch (UserAlreadyExistException ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        }

    }

    public void ifUserAlreadyExist(String username)throws UserAlreadyExistException {
        Optional<TrainingPlanUser> user =trainingPlanUserRepository.findByUsername(username);
        if(user.isPresent()) {
            throw new UserAlreadyExistException("User already exist");
        }
    }

    public boolean userExist(String username){
        Optional<TrainingPlanUser> user =trainingPlanUserRepository.findByUsername(username);
        return user.isPresent();
    }

    public void addRolesToUser(String username, String roles) {
       Optional <TrainingPlanUser> user = trainingPlanUserRepository.findByUsername(username);
       if(user.isPresent()){
           String userStartRoles = String.valueOf(user.get().getUserPossibleRoles());
           String finalRoles = roles + "," + userStartRoles;
           user.get().setUserPossibleRoles(UserPossibleRoles.valueOf(finalRoles));
           trainingPlanUserRepository.save(user.get());
        }
                
    }
}