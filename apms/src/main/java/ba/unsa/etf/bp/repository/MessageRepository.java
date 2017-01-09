package ba.unsa.etf.bp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.unsa.etf.bp.dto.EncodedMessageModel;
import ba.unsa.etf.bp.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	
}
