package pl.starter.listner;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.starter.sourdough.event.StarterCreatedEvent;

@Component
public class StarterCreatedEventListener {

    @EventListener
    public void handleStarterCreatedEvent(StarterCreatedEvent event) {
        Long starterId = event.getStarterId();
        System.out.println("Nowy starter został utworzony, ID: " + starterId);
    }
}
