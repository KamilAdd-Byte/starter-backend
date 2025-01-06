package pl.ryestarter.basic;

import lombok.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirstFeedDTO extends BasicDTO {
    private double waterAmount;
    private double flourAmount;
    private double previousVolumeMl;
    private double newVolumeMl;
    private LocalDateTime feedingAt;
}
