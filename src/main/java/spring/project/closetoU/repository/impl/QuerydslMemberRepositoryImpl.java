package spring.project.closetoU.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import spring.project.closetoU.domain.Member;
import spring.project.closetoU.repository.QuerydslMemberRepository;

import static spring.project.closetoU.domain.QMember.member;

@RequiredArgsConstructor
public class QuerydslMemberRepositoryImpl implements QuerydslMemberRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public void updatePassword(Long memberId, String password) {
        queryFactory
                .update(member)
                .set(member.password, password)
                .where(member.id.eq(memberId))
                .execute();
    }

    @Override
    public long existsByEmail(String email) {
        return queryFactory
                .selectFrom(member)
                .where(member.email.eq(email))
                .fetchCount();
    }
}
