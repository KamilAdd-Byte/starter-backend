package pl.ryestarter.listner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.ryestarter.sourdough.event.StarterCreatedEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class StarterCreatedEventListener {

    @EventListener
    public void handleStarterCreatedEvent(StarterCreatedEvent event) {
        Long starterId = event.getStarterId();
        log.info("New starter has been created, ID: {}", starterId);
    }
}
