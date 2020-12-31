package spring.project.closetoU.repository;

import spring.project.closetoU.domain.Closet;

import java.util.List;

public interface QuerydslClosetRepository {
    List<Closet> findClosetByMemberId(Long memberId);
}
