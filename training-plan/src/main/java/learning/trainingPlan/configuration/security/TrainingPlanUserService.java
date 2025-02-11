package learning.trainingPlan.configuration.security;

import learning.trainingPlan.entity.TrainingPlanUser;
import learning.trainingPlan.repository.TrainingPlanUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainingPlanUserService implements UserDetailsService {

    private final TrainingPlanUserRepository trainingPlanUserRepository;

    public TrainingPlanUserService(TrainingPlanUserRepository trainingPlanUserRepository){
        this.trainingPlanUserRepository = trainingPlanUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<TrainingPlanUser> trainingPlanUserOptional = trainingPlanUserRepository.findByUsername(username);
        if(trainingPlanUserOptional.isPresent()){
            TrainingPlanUser trainingPlanUser = trainingPlanUserOptional.get();
            return User.builder()
                    .username(trainingPlanUser.getUsername())
                    .password(trainingPlanUser.getPassword())
                    .roles(String.valueOf(trainingPlanUser.getUserPossibleRoles()).split(","))
                    .build();
        }else{
            throw new UsernameNotFoundException(username);
        }
    }
}
