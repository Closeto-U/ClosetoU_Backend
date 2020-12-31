package spring.project.closetoU.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import spring.project.closetoU.domain.Closet;
import spring.project.closetoU.domain.QCloset;
import spring.project.closetoU.repository.QuerydslClosetRepository;

import java.util.List;

import static spring.project.closetoU.domain.QCloset.*;

@RequiredArgsConstructor
public class QuerydslClosetRepositoryImpl implements QuerydslClosetRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Closet> findClosetByMemberId(Long memberId) {
        return queryFactory
                .selectFrom(closet)
                .where(closet.member.id.eq(memberId))
                .fetch();
    }
}
