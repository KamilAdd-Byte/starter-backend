package pl.starter.bread.basic;

import lombok.Builder;
import lombok.NonNull;
import java.math.BigDecimal;

@Builder
public final class StarterDTO extends BasicDTO {
    private String name;
    private BigDecimal hydrationPercentage;
    private int daysLife;
    private String description;
    @NonNull
    private FeedDTO feeding;
    @NonNull
    private VesselDTO vessel;

}
