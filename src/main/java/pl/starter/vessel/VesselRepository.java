package pl.starter.vessel;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.starter.vessel.domain.Vessel;

public interface VesselRepository extends JpaRepository<Vessel, Integer> {
}
