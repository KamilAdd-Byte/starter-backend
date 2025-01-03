package pl.starter.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedDTO extends BasicDTO {
    private double waterAmount;
    private double flourAmount;
    private double previousVolumeMl;
    private double newVolumeMl;
    private LocalDateTime feedingAt;
}
