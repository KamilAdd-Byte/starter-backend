package pl.starter.bread.starter.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.starter.bread.basic.StarterDTO;
import pl.starter.bread.mapper.GenericStarterMapper;
import pl.starter.bread.starter.domain.Starter;
import pl.starter.bread.starter.repository.StarterRepository;

@Service
@RequiredArgsConstructor
public class StarterService {
    private StarterRepository starterRepository;
    private GenericStarterMapper genericMapper;

    @Transactional
    public StarterDTO createNewStarter(StarterDTO starterDTO) {
        Starter starter = genericMapper.toEntity(starterDTO, Starter.class);
        Starter savedStarter = starterRepository.save(starter);
        return genericMapper.toDTO(savedStarter, StarterDTO.class);
    }
}
