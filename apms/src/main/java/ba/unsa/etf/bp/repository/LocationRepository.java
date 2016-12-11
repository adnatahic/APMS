package ba.unsa.etf.bp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ba.unsa.etf.bp.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

}
