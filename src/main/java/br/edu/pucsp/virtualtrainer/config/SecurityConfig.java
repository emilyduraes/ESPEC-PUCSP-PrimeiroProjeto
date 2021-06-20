package br.edu.pucsp.virtualtrainer.config;

import br.edu.pucsp.virtualtrainer.service.AuthUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    private final AuthUserDetailsService authUserDetailsService;

    public SecurityConfig(AuthUserDetailsService authUserDetailsService) {
        this.authUserDetailsService = authUserDetailsService;
    }

    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
//                csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login")
//                .permitAll()
//                .usernameParameter("login")
//                .passwordParameter("password")
//                .successHandler(this::loginSuccessHandler)
//                .failureHandler(this::loginFailureHandler)

//                .and()
//                .logout()
//                .logoutUrl("auth/logout")
//                .logoutSuccessHandler(this::logoutSuccessHandler)
//                .invalidateHttpSession(true)

//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded: {}", passwordEncoder.encode("pucadm"));
        log.info("Password encoded: {}", passwordEncoder.encode("pucusr"));
        auth.inMemoryAuthentication()
                .withUser("memoryuser")
                .password(passwordEncoder.encode("pucusr"))
                .roles("USER")
                .and()
                .withUser("memoryadm")
                .password(passwordEncoder.encode("pucadm"))
                .roles("USER", "ADMIN");
        auth.userDetailsService(authUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

//    private void loginSuccessHandler(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Authentication authentication) throws IOException {
//
//        response.setStatus(HttpStatus.OK.value());
//        objectMapper.writeValue(response.getWriter(), "Yayy you logged in!");
//    }
//
//    private void loginFailureHandler(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            AuthenticationException e) throws IOException {
//
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        objectMapper.writeValue(response.getWriter(), "Nopity nop!");
//    }
//
//    private void logoutSuccessHandler(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Authentication authentication) throws IOException {
//
//        response.setStatus(HttpStatus.OK.value());
//        objectMapper.writeValue(response.getWriter(), "Bye!");
//    }
}