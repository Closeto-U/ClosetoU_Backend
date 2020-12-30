package spring.project.closetoU.repository;

import spring.project.closetoU.domain.ClosetClothes;

import java.util.List;

public interface QuerydslClosetClothesRepository {
    List<Long> findclothesIdsbyClosetId(Long closetId);
}
