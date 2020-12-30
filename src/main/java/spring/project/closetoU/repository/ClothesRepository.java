package spring.project.closetoU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.project.closetoU.domain.Clothes;

public interface ClothesRepository extends JpaRepository<Clothes, Long>, QuerydslClothesRepository {
}
