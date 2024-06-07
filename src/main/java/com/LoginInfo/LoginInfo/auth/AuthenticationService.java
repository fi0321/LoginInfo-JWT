package com.LoginInfo.LoginInfo.auth;

import com.LoginInfo.LoginInfo.Logininfo.LoginInfo;
import com.LoginInfo.LoginInfo.Logininfo.LoginInfoRepository;
import com.LoginInfo.LoginInfo.Userinfo.UserInfo;
import com.LoginInfo.LoginInfo.Userinfo.UserInfoRepository;
import com.LoginInfo.LoginInfo.role.RoleRepository;
import com.LoginInfo.LoginInfo.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoginInfoRepository loginInfoRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserInfoRepository userInfoRepository;



    public RegistrationResponse register(RegistrationRequest request) {
        var userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new IllegalStateException("Role User was not initialized"));

        LocalDateTime now = LocalDateTime.now();

        var userInfo = UserInfo.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
        userInfoRepository.save(userInfo);

        var loginInfo = LoginInfo.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(true) // Enable the account upon registration
                .roles(List.of(userRole))
                .createdDate(now)
                .lastModifiedDate(now)
                .userInfo(userInfo)
                .build();
        loginInfoRepository.save(loginInfo);


        return new RegistrationResponse("Account registered successfully");
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var loginInfo = (LoginInfo) auth.getPrincipal();
        if (!loginInfo.isEnabled()) {
            throw new DisabledException("Account is not enabled.");
        }

        var jwtToken = jwtService.generateToken(loginInfo);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
