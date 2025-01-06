package pl.ryestarter.sourdough.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.ryestarter.feed.domain.Feed;
import pl.ryestarter.flour.Flour;
import pl.ryestarter.vessel.domain.Vessel;
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
    private double totalWeightStarters;
    private double hoursLife;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @OneToMany(mappedBy = "starter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StarterCondition> starterConditions;

    @OneToMany(mappedBy = "starter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feed> feedings;

    @OneToMany(mappedBy = "starter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vessel> vessels;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "flour_id", referencedColumnName = "id")
    private Flour flour;

    @PrePersist
    @PreUpdate
    public void updateDaysLife() {
        if (createdAt != null) {
            this.daysLife = (int) ChronoUnit.DAYS.between(createdAt, LocalDateTime.now());
            this.hoursLife = (double) ChronoUnit.HOURS.between(createdAt, LocalDateTime.now());
        }
        this.lastUpdated = LocalDateTime.now();
    }
}
