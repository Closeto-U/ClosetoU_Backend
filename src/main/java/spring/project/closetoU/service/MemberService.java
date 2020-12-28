package spring.project.closetoU.service;

import lombok.RequiredArgsConstructor;
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

    private final MemberRepository userRepository;

    @Transactional
    public Long join(Member member) {
        Member savedMember = userRepository.save(member);

        return savedMember.getId();
    }

    @Transactional
    public void update(Long memberId, Member member) {
        Member findMember = findById(memberId);

        findMember.update(member);
    }

    @Transactional
    public void delete(Long memberId) {
        findById(memberId);

        userRepository.deleteById(memberId);
    }

    public List<Member> findAll() {
        return userRepository.findAll();
    }

    public Member findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Member :\nID [%s] 정보를 찾을 수 없습니다.", id)));
    }

    public Member findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Member :\nEmail [%s] 정보를 찾을 수 없습니다.", email)));
    }

    public void checkExistsEmail(String email) {
        if (userRepository.existsByEmail(email))
            throw new NotUniqueValueException(String.format("Member :\n이미 존재하는 Email 입니다. [%s]", email));
    }
}
