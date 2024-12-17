package pl.starter.bread.starter.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.starter.bread.feed.domain.Feed;
import pl.starter.bread.vessel.domain.Vessel;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Starter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    private int daysLife;
    private String description;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @OneToMany(mappedBy = "starter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StarterCondition> starterConditions;

    @OneToMany(mappedBy = "starter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feed> feedings;

    @OneToMany(mappedBy = "starter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vessel> vessels;

    @PrePersist
    @PreUpdate
    public void updateDaysLife() {
        if (createdAt != null) {
            this.daysLife = (int) ChronoUnit.DAYS.between(createdAt, LocalDateTime.now());
        }
        this.lastUpdated = LocalDateTime.now();
    }
}
