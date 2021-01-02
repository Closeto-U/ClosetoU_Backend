package spring.project.closetoU.repository;

import spring.project.closetoU.domain.Clothes;

import java.util.List;

public interface QuerydslClothesRepository {
    List<Clothes> findClothesList(List<Long> closetId);
}
