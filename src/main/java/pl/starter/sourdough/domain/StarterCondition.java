package pl.starter.sourdough.domain;

import jakarta.persistence.*;
import lombok.*;
import pl.starter.vessel.domain.Vessel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StarterCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Condition status;

    @Column(name = "jar_weight_g")
    private float jarWeightG;

    @Column(name = "current_mass_g")
    private float currentMassG;

    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal hydrationPercentage;

    private LocalDateTime statusDate;
    private String note;

    @ManyToOne
    @JoinColumn(name = "starter_id", nullable = false)
    private Starter starter;

    @ManyToOne
    @JoinColumn(name = "vessel_id", nullable = false)
    private Vessel vessel;
}
