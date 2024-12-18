package pl.starter.basic;

import lombok.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VesselDTO extends BasicDTO {
    private String name;
    private float volumeMl;
    private Double heightCm;
    private Double widthCm;
    private Double depthCm;
    private String material;
    private String description;
    private LocalDateTime startKeepStarter;
    private LocalDateTime endKeepStarter;
}
