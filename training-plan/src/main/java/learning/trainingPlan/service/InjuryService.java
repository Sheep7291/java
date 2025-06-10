package learning.trainingPlan.service;

import learning.trainingPlan.dto.InjuryDto;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InjuryService {
    private final JmsTemplate jmsTemplate;

    public String addInjury(InjuryDto injuryDto) {
        jmsTemplate.convertAndSend("DLQ", injuryDto);
        return "Injury send to service";
    }
}
