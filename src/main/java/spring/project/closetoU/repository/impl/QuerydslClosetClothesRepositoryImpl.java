package spring.project.closetoU.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import spring.project.closetoU.domain.ClosetClothes;
import spring.project.closetoU.domain.QClosetClothes;
import spring.project.closetoU.repository.QuerydslClosetClothesRepository;

import java.util.List;

import static spring.project.closetoU.domain.QClosetClothes.*;

@RequiredArgsConstructor
public class QuerydslClosetClothesRepositoryImpl implements QuerydslClosetClothesRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Long> findclothesIdsbyClosetId(Long closetId) {
        return queryFactory
                .select(closetClothes.clothes.id)
                .from(closetClothes)
                .where(closetClothes.closet.id.eq(closetId))
                .fetch();
    }
}
