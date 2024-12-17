package pl.starter.bread.basic;

import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public final class FeedDTO extends BasicDTO {
    private double waterAmount;
    private double flourAmount;
    private LocalDateTime feedingAt;
}
