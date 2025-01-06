package pl.ryestarter.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ryestarter.feed.domain.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Long> {
}
