package pl.starter.basic;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class FeedDTO extends BasicDTO {
    private double waterAmount;
    private double flourAmount;
    private double previousVolumeMl;
    private double newVolumeMl;
    private LocalDateTime feedingAt;
}
