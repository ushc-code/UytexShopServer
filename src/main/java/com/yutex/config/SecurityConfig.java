package com.yutex.config;

import com.yutex.model.services.AuthProvider;
import com.yutex.model.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    private UserService userService;

    /*@Autowired
    private AuthProvider authProvider;*/

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(10);
    }

    /*@Bean
    public AuthProvider provider(){return  new AuthProvider(); }
    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(provider());
    }*/


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable();

        http.authorizeRequests()
                .anyRequest().permitAll();

        http.logout()
                .permitAll()
                .logoutUrl("/logout").logoutSuccessUrl("/catalog")
                .invalidateHttpSession(true);
        /*http.authorizeRequests()
        .antMatchers("/","/login","/registration").permitAll();
        //.anyRequest().authenticated();
        *//*.and()
        .formLogin().loginPage("/pages/login").defaultSuccessUrl("/pages/catalog/")
        .and()
        .logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(encoder());
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:4200/").allowedMethods("*");
    }
}
