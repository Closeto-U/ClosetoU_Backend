package spring.project.closetoU.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.project.closetoU.domain.Member;
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

    public List<Member> findAll() {
        return userRepository.findAll();
    }

    public Optional<Member> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<Member> findUser(String email) {
        return userRepository.findByEmail(email);
    }
}
