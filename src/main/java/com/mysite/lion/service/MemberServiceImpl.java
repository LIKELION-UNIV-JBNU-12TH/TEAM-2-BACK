package com.mysite.lion.service;


import com.mysite.lion.dto.LogInDTO;
import com.mysite.lion.dto.SignUpDTO;
import com.mysite.lion.entity.Member;
import com.mysite.lion.repository.MemberRepository;
import com.mysite.lion.service.interfaces.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public ResponseEntity<String> signup(SignUpDTO formDTO) {

        Optional<Member> member = memberRepository.findById(formDTO.getId());

        if (member.isEmpty()) {
            Member newMember = Member.builder()
                    .id(formDTO.getId())
                    .password(formDTO.getPassword())
                    .name(formDTO.getName())
                    .email(formDTO.getEmail())
                    .phone(formDTO.getPhone())
                    .build();

            memberRepository.save(newMember);

            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<String> login(LogInDTO loginDTO) {
        Optional<Member> member = memberRepository.findById(loginDTO.getId());

        if (member.isEmpty()) {
            return new ResponseEntity<>("해당 아이디를 가진 회원이 존재하지 않습니다.", HttpStatus.OK);
        }

        Member memberEntity = member.get();
        if (memberEntity.getPassword().equals(loginDTO.getPassword())) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("비밀번호가 일치하지 않습니다.", HttpStatus.OK);
        }
    }

}
