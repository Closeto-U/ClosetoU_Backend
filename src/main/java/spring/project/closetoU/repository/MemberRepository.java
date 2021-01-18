package spring.project.closetoU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.project.closetoU.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslMemberRepository {
    Optional<Member> findByEmail(String email);
}
