package pl.starter.flour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlourRepository extends JpaRepository<Flour, Integer> {
}
