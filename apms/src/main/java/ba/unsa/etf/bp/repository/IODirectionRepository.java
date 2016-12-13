package ba.unsa.etf.bp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ba.unsa.etf.bp.model.IODirection;

@Repository
public interface IODirectionRepository extends JpaRepository<IODirection, Long> {

}
