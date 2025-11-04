package com.learning.springSecEx.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration  // to know this is a configuration class
@EnableWebSecurity // to enable the web security , because we dont want to go with the default web security
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable()); // Disables CSRF protection. and Usually done in APIs where you don’t use browser forms.

     //   http.authorizeHttpRequests(request -> request.anyRequest().authenticated()); // Requires login for all requests and Any request must be from an authenticated user.

        http.authorizeHttpRequests(request -> request
                .requestMatchers("register", "login")
                .permitAll());

        http.formLogin(Customizer.withDefaults()); // Enables form-based login (default Spring login page). and Users can log in via a web form.

        http.httpBasic(Customizer.withDefaults());  // Enables basic authentication (username & password in request header). and Useful for APIs or testing with tools like Postman.

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));  // Sets session policy to stateless. Spring won’t store session info; each request must carry authentication info.

        return http.build();  // Builds the security filter chain with all the above rules. Spring uses this to handle security for requests.
    }

    // It is for testing purpose only.
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("varun")
//                .password("v@123")
//                .roles("user")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1);
//    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        // to decode the encrypted password with the same strength
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));


        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
