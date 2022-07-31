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
        return httpSecurity.
                authorizeRequests()
                .antMatchers(HttpMethod.GET, "/assets/**","/login", "/registro").permitAll()
                .antMatchers(HttpMethod.POST, "/login", "/registro").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .userDetailsService(tbUsuarioService)
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .successForwardUrl("/login?sucesso=sucesso")
                .and()
                .logout()
                .and()
                .csrf()
                .disable()
                .build();
    }


}
