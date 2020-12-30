package spring.project.closetoU.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import spring.project.closetoU.domain.Clothes;
import spring.project.closetoU.repository.QuerydslClothesRepository;

import java.util.List;

import static spring.project.closetoU.domain.QCloset.closet;
import static spring.project.closetoU.domain.QClothes.clothes;


@RequiredArgsConstructor
public class QuerydslClothesRepositoryImpl implements QuerydslClothesRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Clothes> findByIds(List<Long> clothesIds) {
        return queryFactory
                .selectFrom(clothes)
                .where(clothes.id.in(clothesIds))
                .fetch();
    }
}
