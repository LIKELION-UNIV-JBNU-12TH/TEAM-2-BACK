package com.mysite.lion.service.interfaces;


import com.mysite.lion.dto.LogInDTO;
import com.mysite.lion.dto.SignUpDTO;
import org.springframework.http.ResponseEntity;


public interface MemberService {
    ResponseEntity<String> signup(SignUpDTO formDTO);
    ResponseEntity<String> login(LogInDTO loginDTO);
}
