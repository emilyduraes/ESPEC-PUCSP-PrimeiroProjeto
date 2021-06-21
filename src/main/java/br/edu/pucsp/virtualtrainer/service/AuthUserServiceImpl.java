package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.entity.AuthUser;
import br.edu.pucsp.virtualtrainer.domain.request.LoginRequest;
import br.edu.pucsp.virtualtrainer.domain.response.AuthUserResponse;
import br.edu.pucsp.virtualtrainer.domain.response.LoginResponse;
import br.edu.pucsp.virtualtrainer.domain.response.MsgLoginResponse;
import br.edu.pucsp.virtualtrainer.repository.AuthUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Base64;

@Service
public class AuthUserServiceImpl implements AuthUserService{

    private static final Logger log = LoggerFactory.getLogger(AuthUserServiceImpl.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationTokenRequest = new
                UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword());
        try {
            Authentication authentication = this.authenticationManager.authenticate(authenticationTokenRequest);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
//            HttpSession session = httpServletRequest.getSession(true);
//            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

            AuthUser authUser = (AuthUser) authentication.getPrincipal();
            AuthUserResponse authUserResponse = new AuthUserResponse();
            authUserResponse.setAuthorities(authUser.getAuthorities());
            authUserResponse.setStudent(authUser.getStudent());
            authUserResponse.setTrainer(authUser.getTrainer());
            authUserResponse.setBasicAuthorization("Authorization: Basic " +
                    Base64Utils.encodeToString(
                            String.format("%s:%s", loginRequest.getUsername(),loginRequest.getPassword())
                                    .getBytes()));

            log.info("Logged in user: " + authUser.toString());
            log.info("AuthUserResponse: "+authUserResponse);
            return new LoginResponse(HttpStatus.OK, MsgLoginResponse.OK, authUserResponse);
        } catch (BadCredentialsException ex) {
            return new LoginResponse(HttpStatus.BAD_REQUEST, MsgLoginResponse.NO_USER_WITH_USERNAME);
        }
    }

    @Override
    public LoginResponse logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Logout: "+authentication);
        log.info("Logout String: "+authentication.toString());
        if (authentication != null) {
            log.info("authentication != null");
            HttpSession session = httpServletRequest.getSession();
            session.invalidate();
            new SecurityContextLogoutHandler().logout(
                    httpServletRequest,
                    httpServletResponse,
                    authentication);
        }
        return new LoginResponse(HttpStatus.OK, MsgLoginResponse.OK);
    }
}
