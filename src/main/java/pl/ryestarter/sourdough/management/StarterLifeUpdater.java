package pl.ryestarter.sourdough.management;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.ryestarter.sourdough.domain.Starter;
import pl.ryestarter.sourdough.repository.StarterRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StarterLifeUpdater {
    private final StarterRepository starterRepository;

    @Scheduled(cron = "${starter.life.updater.cron}")
    public void updateDaysLifeForAllStarters() {
        List<Starter> starters = starterRepository.findAll();
        for (Starter starter : starters) {
            if (starter.getCreatedAt() != null) {
                int daysLife = Period.between(starter.getCreatedAt().toLocalDate(), LocalDate.now()).getDays();
                starter.setDaysLife(daysLife);
                starter.setLastUpdated(LocalDateTime.now());
            }
        }
        starterRepository.saveAll(starters);
    }
}
