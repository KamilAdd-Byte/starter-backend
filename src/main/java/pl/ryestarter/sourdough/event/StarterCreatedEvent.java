package pl.ryestarter.sourdough.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class StarterCreatedEvent extends ApplicationEvent {
    private final Long starterId;

    @JsonCreator
    public StarterCreatedEvent(
            @JsonProperty("source") Object source,
            @JsonProperty("starterId") Long starterId) {
        super(source);
        this.starterId = starterId;
    }
}