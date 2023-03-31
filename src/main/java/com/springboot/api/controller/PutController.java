package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController // @ResponseBody 생략 가능
@RequestMapping("/api/v1/put-api")
public class PutController {
    // http://localhost:8080/api/v1/put-api/member
    @PutMapping(value="/memver")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb=new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue());
        });

        return sb.toString();
    }
    // http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value="/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
    // http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value="/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }
    // http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value="/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) // HttpStatus.ACCEPTED는 응답 코드 202를 가지고 있다. (응답 코드 202 : 요청이 성공적으로 접수되었으나, 아직 해당 요청에 대해 처리중이거나 처리 시작 전임을 의미)
                // 요청이 처리 중 실패할 수도 있기 때문에 요청은 실행될 `수도 실행되지 않을 수도 있다.
                .body(memberDto);
    }
}
