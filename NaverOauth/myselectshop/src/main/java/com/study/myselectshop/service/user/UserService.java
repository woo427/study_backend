package com.study.myselectshop.service.user;

import com.study.myselectshop.dto.user.SignupRequestDto;
import com.study.myselectshop.entity.user.User;
import com.study.myselectshop.entity.user.UserRoleEnum;
import com.study.myselectshop.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final String ADMIN_TOKEN = "IAMADMIN";

    public void signup(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        Optional<User> checkEmail = userRepository.findByEmail(signupRequestDto.getEmail());
        if(checkEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 이메일 입니다.");
        }

        UserRoleEnum role = UserRoleEnum.USER;
        if(signupRequestDto.isAdmin()) {
            if(!ADMIN_TOKEN.equals(signupRequestDto.getAdminToken())) {
                throw new IllegalArgumentException("ADMIN 암호가 올바르지 않습니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        User user = new User(username, password, signupRequestDto.getEmail(), role);
        userRepository.save(user);
    }
}
