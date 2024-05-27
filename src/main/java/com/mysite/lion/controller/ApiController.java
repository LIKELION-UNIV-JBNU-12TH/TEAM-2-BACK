package com.mysite.lion.controller;


import com.mysite.lion.dto.LogInDTO;
import com.mysite.lion.dto.SignUpDTO;
import com.mysite.lion.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> userSignup(@RequestBody SignUpDTO formDTO) {
        return memberService.signup(formDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LogInDTO loginDTO) {
        return memberService.login(loginDTO);
    }
}
