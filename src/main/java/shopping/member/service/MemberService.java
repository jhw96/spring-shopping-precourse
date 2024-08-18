package shopping.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.member.dto.MemberDto;
import shopping.member.repository.MemberRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // 회원가입
    public Map<String, String> register(MemberDto memberDto) {
        Map<String, String> result = new HashMap<>();

        if (memberRepository.getMemberDto(memberDto).equals(memberDto.getEmail())) {
            result.put("resultMsg", "동일한 이메일 존재합니다.");
            return result;
        }


        return result;
    }


    // 로그인
    public Map<String, String> login(MemberDto memberDto) {
        Map<String, String> result = new HashMap<>();

        MemberDto member = memberRepository.getMemberDto(memberDto);

        result.put("email", member.getEmail());
        result.put("password", member.getPassword());


        return result;
    }

}
