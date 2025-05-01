package me.minkyoung.todo_list.Service;

import lombok.RequiredArgsConstructor;
import me.minkyoung.todo_list.Dto.LoginRequest;
import me.minkyoung.todo_list.Dto.SignupRequest;
import me.minkyoung.todo_list.Entity.User;
import me.minkyoung.todo_list.Repository.UserRepository;
import me.minkyoung.todo_list.jwt.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void signup(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .build();

        userRepository.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("가입되지 않은 이메일입니다."));
        System.out.println("비밀번호 비교 - 입력값: " + request.getPassword());
        System.out.println("비밀번호 비교 - DB값: " + user.getPassword());
        System.out.println("비교 결과: " + passwordEncoder.matches(request.getPassword(), user.getPassword()));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        return jwtTokenProvider.createToken(user.getEmail());
    }

}