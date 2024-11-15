package learning.trainingPlan.configuration;

import feign.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learning.trainingPlan.service.TrainingPlanUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

    private final TrainingPlanUserService trainingPlanUserService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    


    public SecurityConfiguration(TrainingPlanUserService trainingPlanUserService){
        this.trainingPlanUserService = trainingPlanUserService;
    }

    @Bean
    UrlBasedCorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       return http
               .cors(cors -> cors.configurationSource(corsConfigurationSource()))
               .authorizeHttpRequests(
               authorize -> {
                   authorize.requestMatchers("/authenticate", "/v3/api-docs/**", "/swagger-ui/**", "/login").permitAll();
//                   authorize.requestMatchers(HttpMethod.GET, "/api/trainingPlans").hasRole("ADMIN");
                   authorize.anyRequest().authenticated();
               }
       )
               .formLogin(form -> form
                       .permitAll()
                       .loginProcessingUrl("/authenticate")
                       .successHandler((request, response, authentication) -> {
                           response.setContentType("application/json");
                           response.getWriter().write("{\"sessionId\": \"" + request.getRequestedSessionId() + "\"}");
                       }))
               .exceptionHandling(ex -> ex
                       .authenticationEntryPoint((request, response, authException) -> {
                           response.setContentType("application/json");
                           response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                           response.getWriter().write("{\"error\": \"Unathorize\"}");
                       }))
               .csrf(AbstractHttpConfigurer::disable)
               .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return trainingPlanUserService;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity)throws Exception{
        AuthenticationManagerBuilder auth = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        auth.authenticationProvider(authenticationProvider());
        return auth.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
