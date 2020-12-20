package spring.project.closetoU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.project.closetoU.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
