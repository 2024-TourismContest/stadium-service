package yaguhang.stadium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yaguhang.stadium.domain.Stadium;

import java.util.Optional;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    Optional<Stadium> findTopByNameContaining(String name);
    Optional<Stadium> findTopByNameLike(String name);
    Optional<Stadium> findTopById(Long id);
}
