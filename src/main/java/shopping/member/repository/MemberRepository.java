package shopping.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.member.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, Long> {

    // 회원가입
    public MemberDto save(MemberDto memberDto);

    // 로그인
    public MemberDto getMemberDto(MemberDto memberDto);
}
