package learning.trainingPlan.service;

import learning.trainingPlan.client.InjuryClient;
import learning.trainingPlan.jms.InjuryDto;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class InjuryService {
    private final JmsTemplate jmsTemplate;
    private final InjuryClient injuryClient;

    public String addInjury(InjuryDto injuryDto) {
        InjuryDto sendInjuryDto = InjuryDto.builder()
                .username(injuryDto.getUsername())
                .nameOfInjury(injuryDto.getNameOfInjury())
                .timeWhenInjuryHappen(injuryDto.getTimeWhenInjuryHappen())
                .source("training plan maker")
                .injuryDetails(injuryDto.getInjuryDetails())
                .build();
        jmsTemplate.convertAndSend("DLQ", sendInjuryDto);
        return "Injury send to service";
    }

    public List<InjuryDto> getInjuriesByUsername(String username){
        return injuryClient.getInjury(username);
    }
}
