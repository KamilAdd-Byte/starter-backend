package pl.starter.basic;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FlourDTO {
    private String type;
    private String category;
    private String description;
}
