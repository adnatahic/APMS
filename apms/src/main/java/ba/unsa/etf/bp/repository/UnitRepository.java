package ba.unsa.etf.bp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ba.unsa.etf.bp.model.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

}
