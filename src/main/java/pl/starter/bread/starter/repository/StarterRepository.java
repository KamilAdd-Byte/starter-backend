package pl.starter.bread.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.starter.bread.starter.domain.Starter;

@Repository
public interface StarterRepository extends JpaRepository<Starter, Long> {
}
