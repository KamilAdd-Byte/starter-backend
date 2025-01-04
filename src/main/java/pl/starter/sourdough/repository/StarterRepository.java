package pl.starter.sourdough.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.starter.feed.domain.Feed;
import pl.starter.sourdough.domain.Starter;

import java.util.List;

@Repository
public interface StarterRepository extends JpaRepository<Starter, Long> {
   Starter findByName(String name);
   Starter findById(long id);
}
