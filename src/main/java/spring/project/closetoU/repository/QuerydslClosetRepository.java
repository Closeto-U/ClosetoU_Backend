package spring.project.closetoU.repository;

import spring.project.closetoU.domain.Closet;
import spring.project.closetoU.domain.dto.ClosetDto;

import java.util.List;

public interface QuerydslClosetRepository {
    List<Closet> findClosetByMemberId(Long memberId);

}
