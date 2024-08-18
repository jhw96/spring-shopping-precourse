package shopping.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shopping.member.service.MemberService;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/members")
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원가입
    @PostMapping("/register")
    public Map<String,String> register(@RequestBody Map<String,String> member){
        Map<String,String> result = new HashMap<>();


        return result;
    }

    // 로그인
    @PostMapping("/login")
    public Map<String,String> login(@RequestBody Map<String,String> member){
        Map<String,String> result = new HashMap<>();

        return result;
    }


}
