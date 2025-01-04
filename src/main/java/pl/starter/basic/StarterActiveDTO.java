package pl.starter.basic;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarterActiveDTO extends BasicDTO {
    private String name;
    @NonNull
    private FlourDTO flour;
    @NonNull
    private List<FirstFeedDTO> feeds;
    @NonNull
    private List<VesselDTO> vessels;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime lastUpdated;

    private int daysLife;
    private double hoursLife;
}
