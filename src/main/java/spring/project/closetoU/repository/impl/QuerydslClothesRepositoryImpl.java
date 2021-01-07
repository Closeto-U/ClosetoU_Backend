package spring.project.closetoU.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import spring.project.closetoU.domain.Clothes;
import spring.project.closetoU.domain.dto.CCDto;
import spring.project.closetoU.domain.dto.ClothesDto;
import spring.project.closetoU.repository.QuerydslClothesRepository;

import java.util.List;

import static spring.project.closetoU.domain.QClosetClothes.closetClothes;
import static spring.project.closetoU.domain.QClothes.clothes;


@RequiredArgsConstructor
public class QuerydslClothesRepositoryImpl implements QuerydslClothesRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Clothes> findClothesList(List<Long> clothesIds) {
        return queryFactory
                .selectFrom(clothes)
                .where(clothes.id.in(clothesIds))
                .fetch();
    }

    public List<Clothes> findClothesDtoByClosetId(Long closetId) {
        return queryFactory
                .select(clothes)
                .from(closetClothes)
                .join(closetClothes.clothes, clothes)
                .where(closetClothes.closet.id.eq(closetId))
                .fetch();
    }

    public List<CCDto> findClothesDtoByClosetIds(List<Long> closetIds) {
        return queryFactory
                .select(
                        Projections.constructor(
                                CCDto.class,
                                closetClothes.closet.id,
                                Projections.constructor(
                                        ClothesDto.class,
                                        clothes
                                )
                        )
                )
                .from(closetClothes)
                .join(closetClothes.clothes, clothes)
                .where(closetClothes.closet.id.in(closetIds))
                .fetch();
    }
}
