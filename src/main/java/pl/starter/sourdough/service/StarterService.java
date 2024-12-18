package pl.starter.sourdough.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pl.starter.basic.StarterCreatedDTO;
import pl.starter.basic.StarterDTO;
import pl.starter.feed.domain.Feed;
import pl.starter.feed.repository.FeedRepository;
import pl.starter.flour.Flour;
import pl.starter.flour.FlourRepository;
import pl.starter.sourdough.domain.Starter;
import pl.starter.sourdough.event.StarterCreatedEvent;
import pl.starter.sourdough.repository.StarterRepository;
import pl.starter.vessel.VesselRepository;
import pl.starter.vessel.domain.Vessel;

@Service
@RequiredArgsConstructor
public class StarterService {
    private final StarterRepository starterRepository;
    private final FeedRepository feedRepository;
    private final VesselRepository vesselRepository;
    private final FlourRepository flourRepository;
    private final ModelMapper modelMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public StarterCreatedDTO createNewStarter(StarterDTO starterDTO) {
        Starter starter = modelMapper.map(starterDTO, Starter.class);

        Feed feed = modelMapper.map(starterDTO.getFeed(), Feed.class);
        feed.setStarter(starter);

        Vessel vessel = modelMapper.map(starterDTO.getVessel(), Vessel.class);
        vessel.setStarter(starter);

        Flour flour = modelMapper.map(starterDTO.getFlour(), Flour.class);

        Starter savedStarter = starterRepository.save(starter);
        feedRepository.save(feed);
        vesselRepository.save(vessel);
        flourRepository.save(flour);
        eventPublisher.publishEvent(new StarterCreatedEvent(this, savedStarter.getId()));

        return new StarterCreatedDTO(savedStarter.getId());
    }
}
