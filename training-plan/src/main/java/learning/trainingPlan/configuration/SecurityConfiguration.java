package learning.trainingPlan.configuration;

import learning.trainingPlan.service.TrainingPlanUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private final TrainingPlanUserService trainingPlanUserService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public SecurityConfiguration(TrainingPlanUserService trainingPlanUserService){
        this.trainingPlanUserService = trainingPlanUserService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       return http.authorizeHttpRequests(
               authorize -> {
                   authorize.requestMatchers("/css/**", "/webjars/** ", "/js/**", "/images/**").permitAll();
                   authorize.requestMatchers("/login", "/error/**", "/logout").permitAll();
                   authorize.requestMatchers("/admin/**").hasRole("ADMIN");
                   authorize.requestMatchers(HttpMethod.GET, "/api/trainingPlans").hasRole("ADMIN");
                   authorize.requestMatchers("/user/**").hasRole("USER");
                   authorize.anyRequest().authenticated();
               }
       ).formLogin(formLogin -> formLogin
               .loginPage("/login")
                       .loginProcessingUrl("/authenticate")
               .defaultSuccessUrl("/swagger-ui/index.html#/training-plan-controller/getTrainingPlan", true)
               .permitAll())
               .logout(logout -> logout.logoutUrl("/logout")
                       .logoutSuccessUrl("/login?logout")
                       .permitAll()
               )
               .csrf(AbstractHttpConfigurer::disable)
               .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return trainingPlanUserService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(trainingPlanUserService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
