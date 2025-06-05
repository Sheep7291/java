package learning.trainingPlan.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class InjuryClient {

    private WebClient webClient;

//    public InjuryClient(@Value("${clients.injury.baseUrl}")
//                        String baseUrl){
//        this.webClient = WebClient.builder().
//                baseUrl(baseUrl)
//                .build();
//    }

//    public String getCurrency(){
//        return webClient.get()
//                .uri("/currencyRates")
//                .retrieve()
//                .bodyToFlux()
//                .block();
//

    }

