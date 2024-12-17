package pl.starter.bread.feed.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.starter.bread.starter.domain.Starter;
import java.math.BigDecimal;
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

    @Column(name = "feeding_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime feedingAt;

    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal hydrationPercentage;

    @ManyToOne
    @JoinColumn(name = "starter_id", nullable = false)
    private Starter starter;
}
