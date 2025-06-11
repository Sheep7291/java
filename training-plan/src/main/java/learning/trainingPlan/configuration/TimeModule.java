package learning.trainingPlan.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeModule {
//    @Bean
//    public ObjectMapper mapper() {
//        return JsonMapper.builder()
//                .addModule(new JavaTimeModule())
//                .build();
//    }
}
