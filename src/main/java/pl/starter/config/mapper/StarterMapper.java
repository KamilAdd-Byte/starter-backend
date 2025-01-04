package pl.starter.config.mapper;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.starter.basic.FirstFeedDTO;
import pl.starter.basic.FlourDTO;
import pl.starter.basic.StarterDTO;
import pl.starter.basic.VesselDTO;
import pl.starter.feed.domain.Feed;
import pl.starter.flour.Flour;
import pl.starter.sourdough.domain.Starter;
import pl.starter.vessel.domain.Vessel;
import java.util.List;

@Configuration
public class StarterMapper {

    @Bean
    public ModelMapper modelMapper(List<ModelMapperConfigurer> modelMapperConfigurers) {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setPropertyCondition(Conditions.isNotNull());

        modelMapperConfigurers.forEach(modelMapperConfigurer -> modelMapperConfigurer.configure(modelMapper));

        starterMappings(modelMapper);
        return modelMapper;
    }

    private void starterMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(StarterDTO.class, Starter.class)
                .addMapping(StarterDTO::getName, Starter::setName);

        modelMapper.typeMap(FirstFeedDTO.class, Feed.class)
                .addMapping(FirstFeedDTO::getWaterAmount, Feed::setWaterAmount)
                .addMapping(FirstFeedDTO::getFlourAmount, Feed::setFlourAmount)
                .addMapping(FirstFeedDTO::getFeedingAt, Feed::setFeedingAt);

        modelMapper.typeMap(VesselDTO.class, Vessel.class)
                .addMapping(VesselDTO::getName, Vessel::setName)
                .addMapping(VesselDTO::getHeightCm, Vessel::setHeightCm)
                .addMapping(VesselDTO::getWidthCm, Vessel::setWidthCm)
                .addMapping(VesselDTO::getDepthCm, Vessel::setDepthCm)
                .addMapping(VesselDTO::getMaterial, Vessel::setMaterial)
                .addMapping(VesselDTO::getDescription, Vessel::setDescription);


        modelMapper.typeMap(FlourDTO.class, Flour.class)
                .addMapping(FlourDTO::getType, Flour::setType)
                .addMapping(FlourDTO::getCategory, Flour::setCategory)
                .addMapping(FlourDTO::getDescription, Flour::setDescription);
    }

    public static Converter<FirstFeedDTO, Feed> toFeed() {
        return new AbstractConverter<>() {
            @Override
            protected Feed convert(FirstFeedDTO source) {
                return Feed.builder()
                        .waterAmount(source.getWaterAmount())
                        .flourAmount(source.getFlourAmount())
                        .feedingAt(source.getFeedingAt())
                        .build();
            }
        };
    }

    public static Converter<VesselDTO, Vessel> toVessel() {
        return new AbstractConverter<>() {
            @Override
            protected Vessel convert(VesselDTO source) {
                return Vessel.builder()
                        .name(source.getName())
                        .volumeMl(source.getVolumeMl())
                        .heightCm(source.getHeightCm())
                        .widthCm(source.getWidthCm())
                        .depthCm(source.getDepthCm())
                        .material(source.getMaterial())
                        .description(source.getDescription())
                        .startKeepStarter(source.getStartKeepStarter())
                        .endKeepStarter(source.getEndKeepStarter())
                        .build();
            }
        };
    }
}
