package pl.starter.sourdough.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import pl.starter.sourdough.event.EventPublicationRepository;
import pl.starter.sourdough.event.StarterCreatedEvent;
import pl.starter.sourdough.event.model.EventPublication;
import pl.starter.sourdough.repository.StarterRepository;
import pl.starter.vessel.VesselRepository;
import pl.starter.vessel.domain.Vessel;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StarterService {
    private final StarterRepository starterRepository;
    private final FeedRepository feedRepository;
    private final VesselRepository vesselRepository;
    private final FlourRepository flourRepository;
    private final ModelMapper modelMapper;
    private final ApplicationEventPublisher eventPublisher;
    private final EventPublicationRepository eventPublicationRepository;

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

        EventPublication eventPublication = new EventPublication();
        eventPublication.setEventType("StarterCreated");
        eventPublication.setEventPayload(String.format("Starter ID: %s", savedStarter.getId()));
        eventPublication.setPublicationDate(LocalDateTime.now());
        eventPublication.setListenerId("StarterEventListener");
        eventPublication.setCompletionDate(LocalDateTime.now());

        StarterCreatedEvent starterCreatedEvent = new StarterCreatedEvent(this, savedStarter.getId());

        String serializedEvent = serializeEvent(starterCreatedEvent);
        eventPublication.setSerializedEvent(serializedEvent);

        eventPublicationRepository.save(eventPublication);
        eventPublisher.publishEvent(starterCreatedEvent);

        return new StarterCreatedDTO(savedStarter.getId());
    }
    private String serializeEvent(StarterCreatedEvent event) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize event", e);
        }
    }

    public StarterDTO getStarter() {
        List<Starter> all = starterRepository.findAll();
        return modelMapper.map(all.getFirst(), StarterDTO.class);
    }
}
