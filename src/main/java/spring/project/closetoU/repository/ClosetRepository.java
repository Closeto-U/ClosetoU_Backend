package spring.project.closetoU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.project.closetoU.domain.Closet;

import java.util.Optional;

public interface ClosetRepository extends JpaRepository<Closet, Long>, QuerydslClosetRepository {
    Optional<Closet> findByClosetName(String name);
}
