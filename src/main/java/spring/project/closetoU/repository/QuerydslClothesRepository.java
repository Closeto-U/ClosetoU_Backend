package spring.project.closetoU.repository;

import spring.project.closetoU.domain.Clothes;
import spring.project.closetoU.domain.dto.ClothesDto;

import java.util.List;

public interface QuerydslClothesRepository {
    List<Clothes> findClothesList(List<Long> closetId);

    List<ClothesDto> findClothesDtoByClosetId(Long closetId);

    List<ClothesDto> findClothesDtoByClosetIds(List<Long> closetIds);
}
