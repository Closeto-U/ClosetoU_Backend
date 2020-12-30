package spring.project.closetoU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.project.closetoU.domain.ClosetClothes;

public interface ClosetClothesRepository extends JpaRepository<ClosetClothes, Long>, QuerydslClosetClothesRepository {
}
