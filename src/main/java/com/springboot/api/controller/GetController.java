package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String getHello(){
        return "Hello world";
    }
    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value="/name")
    public String getName(){
        return "Flature";
    }
    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){ // 웹 통신의 기본 목적은 데이터를 주고받는 것이기 때문에 대부분 매개변수를 받는 메서드 작성
        return variable;
    }
    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value="/variable2/{variable}")
    public String getVariable2(@PathVariable("value = variable") String var) { // @PathVariable의 "value"는 생략 가능
        return var;
    }
    // http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @ApiOperation(value="GET 메서드 예제", notes="@RequestParma을 활용한 GET Method")
    @GetMapping(value = "/request1")
    public String getRequestParam1( // 쿼리 형식으로 값 전달 ({키}={값})
            @ApiParam(value="이름", required = true) @RequestParam String name,
            @ApiParam(value="이메일", required = true) @RequestParam String email,
            @ApiParam(value="회사", required = true) @RequestParam String organization) { // @Pathvariable의 value 요소 사용 가능
        return name + " " + email + " " + organization; // value1,2,3 값 리턴
    }
    // http://localhost:8080/api/v1/get-api/request2?key1=value&key2=value2
    @GetMapping(value="/value2")
    public String getRequestParam2(@RequestParam Map<String, String> param) { // 어떤 값이 들어올지 모를 때 사용 (회원 가입 시, 취미 같은 선택 항목에 대해서 값을 기입하지 않는 경우)
        StringBuilder sb = new StringBuilder(); // String은 변경 불가능한 문자열 생성, But StringBuilder는 변경 가능한 문자열을 만들어 준다.
        param.entrySet().forEach(map -> {
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });
        return sb.toString();
    }
    // http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        //return memberDto.getName()+" "+memberDto.getEmail()+" "+memberDto.getOrganization();
        return memberDto.toString();
    }
}
