package pl.ryestarter.vessel;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryestarter.vessel.domain.Vessel;

public interface VesselRepository extends JpaRepository<Vessel, Integer> {
}
