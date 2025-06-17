package com.study.myselectshop.presentation.controller.user;

import com.study.myselectshop.application.service.user.UserService;
import com.study.myselectshop.presentation.dto.ApiResponse;
import com.study.myselectshop.presentation.dto.user.SignupRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

//    회원가입 후 토큰 전달해야함.

    @PostMapping("/signup")
    public ApiResponse<String> signup(@Valid @RequestBody SignupRequestDto requestDto) {
        userService.signup(requestDto);
        return ApiResponse.success("상품 등록 완료", "회원가입이 완료되었습니다.");
    }
//
//    @GetMapping("/user-info")
//    @ResponseBody
//    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        String username = userDetails.getUser().getUsername();
//        UserRoleEnum role = userDetails.getUser().getRole();
//        boolean isAdmin = (role == UserRoleEnum.ADMIN);
//        return new UserInfoDto(username, isAdmin);
//    }
}
