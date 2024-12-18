package pl.starter.feed.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.starter.sourdough.domain.Starter;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "water_amount", nullable = false)
    private double waterAmount;

    @Column(name = "flour_amount", nullable = false)
    private double flourAmount;

    @Column(name = "previous_volume_ml", nullable = false)
    private double previousVolumeMl;

    @Column(name = "new_volume_ml", nullable = false)
    private double newVolumeMl;

    @Column(name = "feeding_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime feedingAt;

    @ManyToOne
    @JoinColumn(name = "starter_id", nullable = false)
    private Starter starter;
}
