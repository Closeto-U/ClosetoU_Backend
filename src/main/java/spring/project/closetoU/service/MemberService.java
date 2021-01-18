package spring.project.closetoU.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.project.closetoU.domain.Member;
import spring.project.closetoU.advice.exception.NotUniqueValueException;
import spring.project.closetoU.advice.exception.EntityNotFoundException;
import spring.project.closetoU.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        Member savedMember = memberRepository.save(member);

        return savedMember.getId();
    }

    @Transactional
    public void update(Long memberId, Member member) {
        Member findMember = findById(memberId);
        findMember.update(member);
    }

    @Transactional
    public void updatePassword(Long memberId, String password) {
        memberRepository.updatePassword(memberId, password);
    }

    @Transactional
    public void delete(Long memberId) {
        findById(memberId);

        memberRepository.deleteById(memberId);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("ID [%s] 정보를 찾을 수 없습니다.", id)));
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Email [%s] 정보를 찾을 수 없습니다.", email)));
    }

    public void checkExistsEmail(String email) {
        if (memberRepository.existsByEmail(email) == 1)
            throw new NotUniqueValueException(String.format("이미 존재하는 Email 입니다. [%s]", email));
    }
}
