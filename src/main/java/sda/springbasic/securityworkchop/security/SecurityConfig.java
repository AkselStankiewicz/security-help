package sda.springbasic.securityworkchop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    private static final String ADMIN_LINK = "/hello/forAdmin/**";
    private static final String USER_LINK = "/hello/forUser/**";
    private static final String ALL_LINK = "/hello/forAll/**";
    private static final String LOGIN_LINK = "/api/login/**";

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(autz -> {
//                    autz
//                            .requestMatchers(ADMIN_LINK).hasRole("ADMIN")
//                            .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//                            .requestMatchers(USER_LINK).hasAnyRole("USER")
//                            .requestMatchers(ALL_LINK).permitAll()
//                            .requestMatchers(LOGIN_LINK).permitAll()
//                            .requestMatchers("/dummyV2/get").hasRole("ADMIN")
//                            .requestMatchers("/dummyV2/post").hasRole("ADMIN")
//                            .requestMatchers("/dummyV2/put").hasRole("ADMIN")
//                            .requestMatchers("/dummyV2/delete").hasRole("ADMIN");
//                })
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }

    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {

        UserDetails user1 = User.builder()
                .username("Bulbulator")
                .password(encoder().encode("pass"))
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("Seba")
                .password(encoder().encode("pass"))
                .roles("ADMIN")
                .build();

        UserDetails user3 = User.builder()
                .username("Ebu")
                .password(encoder().encode("pass"))
                .roles("GUEST")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
