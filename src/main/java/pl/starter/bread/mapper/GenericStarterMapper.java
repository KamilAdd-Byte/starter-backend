package pl.starter.bread.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.starter.bread.basic.FeedDTO;
import pl.starter.bread.basic.StarterDTO;
import pl.starter.bread.basic.VesselDTO;
import pl.starter.bread.starter.domain.Starter;
import pl.starter.bread.vessel.domain.Vessel;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GenericStarterMapper {
    private ModelMapper modelMapper;

    public <D, E> E toEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public <D, E> D toDTO(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <D, E> List<E> toEntityList(List<D> dtoList, Class<E> entityClass) {
        return dtoList.stream()
                .map(dto -> toEntity(dto, entityClass))
                .collect(Collectors.toList());
    }

    public <D, E> List<D> toDTOList(List<E> entityList, Class<D> dtoClass) {
        return entityList.stream()
                .map(entity -> toDTO(entity, dtoClass))
                .collect(Collectors.toList());
    }


    public Starter toEntity(StarterDTO dto) {
        return modelMapper.map(dto, Starter.class);
    }

    public VesselDTO toDTO(Vessel vessel) {
        return modelMapper.map(vessel, VesselDTO.class);
    }

    public Vessel toEntity(VesselDTO vesselDTO) {
        return modelMapper.map(vesselDTO, Vessel.class);
    }
}
