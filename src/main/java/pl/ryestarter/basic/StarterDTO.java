package pl.ryestarter.basic;

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
    private FirstFeedDTO firstFeed;
    @NonNull
    private VesselDTO vessel;
}
