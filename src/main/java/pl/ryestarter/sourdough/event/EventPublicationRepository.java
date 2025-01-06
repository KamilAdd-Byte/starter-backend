package pl.ryestarter.sourdough.event;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryestarter.sourdough.event.model.EventPublication;

import java.util.UUID;

public interface EventPublicationRepository extends JpaRepository<EventPublication, UUID> {
EventPublication findEventPublicationBySerializedEvent(String serializedEvent);
}
