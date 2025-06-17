package learning.trainingPlan.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.jms.ConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJms
public class JmsConfiguration {

//    @Bean
//    public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory,
//                                                     DefaultJmsListenerContainerFactoryConfigurer configurer){
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setMessageConverter(jacksonJmsMessageConverter());
//        configurer.configure(factory, connectionFactory);
//        return  factory;
//    }
@Bean
public ObjectMapper customObjectMapper() {
    return JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .build();
}


    @Bean
    public MessageConverter jacksonJmsMessageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(customObjectMapper());
        converter.setTargetType(MessageType.TEXT);
        Map<String, Class<?>> typeidMappings = new HashMap<>();
        typeidMappings.put("InjuryDto", InjuryDto.class);
        converter.setTypeIdMappings(typeidMappings);
        converter.setTypeIdPropertyName("_asb_");
        return converter;
    }
}
