package spring.project.closetoU.repository;

import spring.project.closetoU.domain.Member;

import java.util.List;

public interface QuerydslMemberRepository {
    void updatePassword(Long memberId, String password);
    long existsByEmail(String email);
}
