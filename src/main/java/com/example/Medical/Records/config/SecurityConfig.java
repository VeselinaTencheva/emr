package com.example.Medical.Records.config;

import com.example.Medical.Records.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserService userService;
//

    private PasswordEncoder passwordEncoder;
    private UserService userService;
    private final Config config;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(config.passwordEncoder());
    }

//    @Autowired
//    public void ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
//                                          UserService userService) {
//        this.passwordEncoder = passwordEncoder;
//        this.userService = userService;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/schools").hasAnyAuthority("ADMIN", "TEACHER")
//                .antMatchers("/teachers").hasAuthority("TEACHER")
                .antMatchers("/js/**", "/css/**", "/images/**").permitAll()
                .antMatchers("/register", "/login").anonymous().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/unauthorized")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login")
                .permitAll();


//        http.cors().disable()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/js/**", "/css/**").permitAll()
//                .antMatchers("/", "/customers/register", "/users/login").anonymous().anyRequest().authenticated().and()
//                .formLogin().loginPage("/users/login").usernameParameter("username").passwordParameter("password")
//                .defaultSuccessUrl("/home").and().logout().logoutSuccessUrl("/");
    }
}
