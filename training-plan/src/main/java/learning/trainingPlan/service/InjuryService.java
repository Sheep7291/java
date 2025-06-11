package learning.trainingPlan.service;

import learning.trainingPlan.jms.InjuryDto;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class InjuryService {
    private final JmsTemplate jmsTemplate;

    public String addInjury(InjuryDto injuryDto) {
        InjuryDto sendInjuryDto = InjuryDto.builder()
                .username(injuryDto.getUsername())
                .nameOfInjury(injuryDto.getNameOfInjury())
                .TimeWhenInjuryHappen(injuryDto.getTimeWhenInjuryHappen())
                .source("training plan maker")
                .build();
        jmsTemplate.convertAndSend("DLQ", sendInjuryDto);
        return "Injury send to service";
    }
}
