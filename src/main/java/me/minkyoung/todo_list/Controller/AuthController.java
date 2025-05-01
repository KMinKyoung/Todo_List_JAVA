package me.minkyoung.todo_list.Controller;

import lombok.RequiredArgsConstructor;
import me.minkyoung.todo_list.Dto.AuthResponse;
import me.minkyoung.todo_list.Dto.LoginRequest;
import me.minkyoung.todo_list.Dto.SignupRequest;
import me.minkyoung.todo_list.Repository.UserRepository;
import me.minkyoung.todo_list.Service.UserService;
import me.minkyoung.todo_list.jwt.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        userService.signup(request);
        return ResponseEntity.ok("회원가입 성공");
    }
    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);  // 로그인 후 JWT 토큰 생성
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
