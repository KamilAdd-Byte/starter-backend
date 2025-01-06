package pl.ryestarter.sourdough.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ryestarter.sourdough.domain.Starter;

@Repository
public interface StarterRepository extends JpaRepository<Starter, Long> {
   Starter findByName(String name);
   Starter findById(long id);
}
