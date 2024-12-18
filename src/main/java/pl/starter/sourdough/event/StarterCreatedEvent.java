package pl.starter.sourdough.event;

import org.springframework.context.ApplicationEvent;

public class StarterCreatedEvent extends ApplicationEvent {
    private final Long starterId;

    public StarterCreatedEvent(Object source, Long starterId) {
        super(source);
        this.starterId = starterId;
    }

    public Long getStarterId() {
        return starterId;
    }
}
