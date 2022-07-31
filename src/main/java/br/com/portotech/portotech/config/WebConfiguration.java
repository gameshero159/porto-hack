package br.com.portotech.portotech.config;

import br.com.portotech.portotech.modules.usuario.services.TbUsuarioService;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
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
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Bean
    public UserDetailsService userDetailsService(TbUsuarioService tbUsuarioService) {
        return tbUsuarioService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, TbUsuarioService tbUsuarioService) throws Exception {
        return httpSecurity
                .userDetailsService(tbUsuarioService)
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successForwardUrl("/login?sucesso=sucesso")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/assets/**", "/registro").permitAll()
                .antMatchers(HttpMethod.POST,  "/registro").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .and()
                .csrf()
                .disable()
                .build();
    }


}
