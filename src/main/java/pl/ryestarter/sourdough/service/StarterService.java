package pl.ryestarter.sourdough.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pl.ryestarter.basic.*;
import pl.ryestarter.feed.controller.StarterFeedingDTO;
import pl.ryestarter.feed.domain.Feed;
import pl.ryestarter.feed.repository.FeedRepository;
import pl.ryestarter.flour.Flour;
import pl.ryestarter.flour.FlourRepository;
import pl.ryestarter.sourdough.domain.Condition;
import pl.ryestarter.sourdough.domain.Starter;
import pl.ryestarter.sourdough.domain.StarterCondition;
import pl.ryestarter.sourdough.event.EventPublicationRepository;
import pl.ryestarter.sourdough.event.StarterCreatedEvent;
import pl.ryestarter.sourdough.event.model.EventPublication;
import pl.ryestarter.sourdough.repository.StarterRepository;
import pl.ryestarter.vessel.VesselRepository;
import pl.ryestarter.vessel.domain.Vessel;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;

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

        Feed feed = modelMapper.map(starterDTO.getFirstFeed(), Feed.class);
        feed.setStarter(starter);

        Vessel vessel = modelMapper.map(starterDTO.getVessel(), Vessel.class);
        vessel.setStarter(starter);

        Flour flour = modelMapper.map(starterDTO.getFlour(), Flour.class);

        Starter savedStarter = starterRepository.save(starter);
        feedRepository.save(feed);
        vesselRepository.save(vessel);
        flourRepository.save(flour);

        EventPublication eventPublication = getEventPublication(savedStarter);

        StarterCreatedEvent starterCreatedEvent = new StarterCreatedEvent(this, savedStarter.getId());

        String serializedEvent = serializeEvent(starterCreatedEvent);
        eventPublication.setSerializedEvent(serializedEvent);

        eventPublicationRepository.save(eventPublication);
        eventPublisher.publishEvent(starterCreatedEvent);
        starter.setLastUpdated(LocalDateTime.now());

        //todo separate to service
        StarterCondition starterCondition = new StarterCondition();
        starterCondition.setStarter(savedStarter);
        starterCondition.setStatus(Condition.BREEDING);

        return new StarterCreatedDTO(savedStarter.getId());
    }

    private EventPublication getEventPublication(Starter savedStarter) {
        EventPublication eventPublication = new EventPublication();
        eventPublication.setEventType("StarterCreated");
        eventPublication.setEventPayload(String.format("Starter ID: %s", savedStarter.getId()));
        eventPublication.setPublicationDate(LocalDateTime.now());
        eventPublication.setListenerId("StarterEventListener");
        eventPublication.setCompletionDate(LocalDateTime.now());
        return eventPublication;
    }

    private String serializeEvent(StarterCreatedEvent event) {
        //todo finish!
        return new StringJoiner(", ", "{", "}")
                .add("\"eventId\": \"" + event.getStarterId() + "\"")
                .add("\"timestamp\": \"" + LocalDateTime.now() + "\"")
                .toString();
    }

    public StarterActiveDTO getActiveStarter() {
        List<Starter> all = starterRepository.findAll();
        return modelMapper.map(all.get(0), StarterActiveDTO.class);
    }

    public StarterFeedingDTO feedStarter(FeedDTO feedDTO) {
        Starter starterToFeed = starterRepository.findById(feedDTO.getStarterId());
        Feed newFeed = modelMapper.map(feedDTO, Feed.class);
        newFeed.setStarter(starterToFeed);

        starterToFeed.getFeedings().add(newFeed);
        starterToFeed.setLastUpdated(LocalDateTime.now());

        starterRepository.save(starterToFeed);
        feedRepository.save(newFeed);
        return new StarterFeedingDTO(newFeed.getId(), starterToFeed.getId());
    }
}
