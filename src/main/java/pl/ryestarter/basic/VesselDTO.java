package pl.ryestarter.basic;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime startKeepStarter;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime endKeepStarter;
}
