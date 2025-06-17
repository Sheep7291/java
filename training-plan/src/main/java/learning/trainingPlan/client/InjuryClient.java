package learning.trainingPlan.client;

import learning.trainingPlan.jms.InjuryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@Slf4j
public class InjuryClient {

    private WebClient webClient;

 public InjuryClient(@Value("${clients.injury.baseUrl}")
                        String baseUrl){
        this.webClient = WebClient.builder().
                baseUrl(baseUrl)
                .build();
    }

    public List<InjuryDto> getInjury(String username){
     return webClient.get()
             .uri(uriBuilder -> uriBuilder
                     .path("/injuries")
                     .queryParam("username", username)
                     .build())
             .retrieve()
             .bodyToFlux(InjuryDto.class)
             .collectList()
             .block();
    }
}

