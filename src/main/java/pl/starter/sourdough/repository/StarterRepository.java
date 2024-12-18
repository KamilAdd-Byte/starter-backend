package pl.starter.sourdough.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.starter.sourdough.domain.Starter;

@Repository
public interface StarterRepository extends JpaRepository<Starter, Long> {
}
