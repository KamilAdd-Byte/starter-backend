package pl.starter.config.mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperConfigurer {
    void configure(ModelMapper modelMapper);
}
