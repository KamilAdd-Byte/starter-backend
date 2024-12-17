package pl.starter.bread.starter.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class StarterCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Condition status;

    private LocalDateTime statusDate;
    private String note;

    @ManyToOne
    @JoinColumn(name = "starter_id", nullable = false)
    private Starter starter;
}
