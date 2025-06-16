package com.study.myselectshop.presentation.controller.user;

import com.study.myselectshop.application.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

//    회원가입 controller 있어야 함

//    @PostMapping("/user/signup")
//    public String signup(@Valid SignupRequestDto requestDto, BindingResult bindingResult) {
//        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//        if(fieldErrors.size() > 0) {
//            for (FieldError fieldError : bindingResult.getFieldErrors()) {
//                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
//            }
//            return "redirect:/api/user/signup";
//        }
//        userService.signup(requestDto);
//        return "redirect:/api/user/login-page";
//    }
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
