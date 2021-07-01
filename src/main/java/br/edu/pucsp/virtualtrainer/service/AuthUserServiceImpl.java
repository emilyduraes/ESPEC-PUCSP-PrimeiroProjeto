package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.entity.AuthUser;
import br.edu.pucsp.virtualtrainer.domain.request.AuthUserRequest;
import br.edu.pucsp.virtualtrainer.domain.request.LoginRequest;
import br.edu.pucsp.virtualtrainer.domain.response.AuthUserResponse;
import br.edu.pucsp.virtualtrainer.domain.response.LoginResponse;
import br.edu.pucsp.virtualtrainer.domain.response.MsgLoginResponse;
import br.edu.pucsp.virtualtrainer.mapper.AuthUserMapper;
import br.edu.pucsp.virtualtrainer.repository.AuthUserRepository;
import org.mapstruct.factory.Mappers;
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
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class AuthUserServiceImpl implements AuthUserService{

    private static final Logger log = LoggerFactory.getLogger(AuthUserServiceImpl.class);

    private static final AuthUserMapper MAPPER = Mappers.getMapper(AuthUserMapper.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @Autowired
    AuthenticationManager authenticationManager;

    AuthUserRepository repository;

    public AuthUserServiceImpl(AuthUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createAuthUser(AuthUserRequest authUserRequest) {
        authUserRequest.setPassword(passwordEncoder(authUserRequest.getPassword()));
        AuthUser authUser = MAPPER.requestToEntity(authUserRequest);
        repository.save(authUser);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationTokenRequest = new
                UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                loginRequest.getPassword());
        try {
            Authentication authentication = this.authenticationManager.authenticate(authenticationTokenRequest);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            
            AuthUser authUser = (AuthUser) authentication.getPrincipal();
            AuthUserResponse authUserResponse = new AuthUserResponse();
            authUserResponse.setAuthorities(authUser.getAuthorities());
            authUserResponse.setStudent(authUser.getStudent());
            authUserResponse.setTrainer(authUser.getTrainer());
            authUserResponse.setBasicAuthorization("Basic " +
                    Base64Utils.encodeToString(
                            String.format("%s:%s", loginRequest.getEmail(), loginRequest.getPassword())
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

    public String passwordEncoder(String password) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder.encode(password);
    }
}
