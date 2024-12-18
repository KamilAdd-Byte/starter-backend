package pl.starter.basic;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarterDTO extends BasicDTO {
    private String name;
    @NonNull
    private FlourDTO flour;
    @NonNull
    private FeedDTO feed;
    @NonNull
    private VesselDTO vessel;
}
