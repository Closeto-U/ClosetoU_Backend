package spring.project.closetoU.repository;

import spring.project.closetoU.domain.Clothes;
import spring.project.closetoU.domain.dto.CCDto;

import java.util.List;

public interface QuerydslClothesRepository {
    List<Clothes> findClothesDtoByClosetId(Long closetId);

    List<CCDto> findClothesDtoByClosetIds(List<Long> closetIds);
}
