package articleguide.restapi.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //csrf 설정
        httpSecurity
                .csrf(config -> config
                        .disable()
                );

        //경로 별 권한 설정
        httpSecurity
                .authorizeHttpRequests(config -> config
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/article/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
                );

        //로그인 설정
        httpSecurity
                .formLogin(loginConfig -> loginConfig
                .defaultSuccessUrl("/", true)
                .permitAll()
        );


        return httpSecurity.build();
    }

}
