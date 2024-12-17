package pl.starter.bread.basic;

import lombok.Builder;

@Builder
public final class VesselDTO extends BasicDTO {
    private String name;
    private Integer volumeMl;
    private Double heightCm;
    private Double widthCm;
    private Double depthCm;
    private String material;
    private String description;
}
