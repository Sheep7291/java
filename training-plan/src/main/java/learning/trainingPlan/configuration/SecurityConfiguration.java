package learning.trainingPlan.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       http
               .csrf(csrf-> csrf.disable())
               .authorizeHttpRequests(authorize -> {
                   authorize.requestMatchers("api/trainingPlans/**").permitAll();
                   authorize.anyRequest().authenticated();
               }).httpBasic(Customizer.withDefaults());
       return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user1 = User.builder()
                .username("test1")
                .password(passwordEncoder().encode("test"))
                .roles("USER")
                .build();
        UserDetails user2 = User.builder()
                .username("test2")
                .password(passwordEncoder().encode("test"))
                .roles("USER")
                .build();
        UserDetails user3 = User.builder()
                .username("test3")
                .password(passwordEncoder().encode("test"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, user3);

    }
}
