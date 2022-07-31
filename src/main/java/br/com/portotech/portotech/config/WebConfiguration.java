package br.com.portotech.portotech.config;

import br.com.portotech.portotech.modules.usuario.services.TbUsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfiguration {

    @Bean
    public UserDetailsService userDetailsService(TbUsuarioService tbUsuarioService) {
        return tbUsuarioService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Order(100)
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.
                authorizeRequests()
                .antMatchers(HttpMethod.GET, "/login").anonymous()
                .antMatchers(HttpMethod.POST, "/login").anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .csrf()
                .disable()
                .build();
    }


}
