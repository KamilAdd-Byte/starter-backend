package pl.starter.vessel.domain;

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
@Table(name = "vessel")
public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "volume_ml", nullable = false)
    private float volumeMl;

    @Column(name = "height_cm", nullable = false)
    private Double heightCm;

    @Column(name = "width_cm", nullable = false)
    private Double widthCm;

    @Column(name = "depth_cm", nullable = false)
    private Double depthCm;

    @Column(nullable = false, length = 50)
    private String material;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_keep_starter", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime startKeepStarter;

    @Column(name = "end_keep_starter")
    @CreationTimestamp
    private LocalDateTime endKeepStarter ;

    @ManyToOne
    @JoinColumn(name = "starter_id", nullable = false)
    private Starter starter;

    @PrePersist
    @PreUpdate
    public void calculateVolume() {
        if (heightCm != null && widthCm != null && depthCm != null) {
            this.volumeMl = (float) Math.round(heightCm * widthCm * depthCm);
        }
    }
}
