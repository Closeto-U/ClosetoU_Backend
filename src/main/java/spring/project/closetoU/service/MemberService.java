package spring.project.closetoU.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.project.closetoU.domain.Member;
import spring.project.closetoU.exception.type.NotUniqueEmailException;
import spring.project.closetoU.exception.type.UserNotFoundException;
import spring.project.closetoU.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository userRepository;

    @Transactional
    public Long join(Member member) {
        userRepository.save(member);

        return member.getId();
    }

    @Transactional
    public void update(Long memberId, Member member) {
        Member findMember = userRepository.findById(memberId)
                .orElseThrow(() -> new UserNotFoundException(String.format("ID [%s] 정보를 찾을 수 없습니다.", memberId)));

        findMember.update(member);
    }

    @Transactional
    public void delete(Long memberId) {
        userRepository.findById(memberId)
                .orElseThrow(() -> new UserNotFoundException(String.format("ID [%s] 정보를 찾을 수 없습니다.", memberId)));
        ;

        userRepository.deleteById(memberId);
    }

    public List<Member> findAll() {
        return userRepository.findAll();
    }

    public Member findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("ID [%s] 정보를 찾을 수 없습니다.", id)));
    }

    public Member findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(String.format("Email [%s] 정보를 찾을 수 없습니다.", email)));
    }

    public void checkExistsEmail(String email) {
        if (userRepository.existsByEmail(email))
            throw new NotUniqueEmailException(String.format("이미 존재하는 Email 입니다. [%s]", email));
    }
}
