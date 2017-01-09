package ba.unsa.etf.bp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.unsa.etf.bp.model.EncodedMessage;

@Repository
public interface EncodedMessageRepository extends JpaRepository<EncodedMessage, Long>{

	@Query("select em from EncodedMessage em"
			+ " inner join em.message m inner join m.node n"
			+ " where n.id = :nodeId"
			+ " order by em.creationTime DESC")
	List<EncodedMessage> queryLastEncodedMessageByNode(@Param(value="nodeId") Long nodeId, Pageable page);

	@Query("select em from EncodedMessage em"
			+ " inner join em.message m inner join m.node n"
			+ " where n.id = :nodeId and em.creationTime >= :from and em.creationTime <= :to"
			+ " order by em.creationTime DESC ")
	List<EncodedMessage> queryEncodedMessagesByNodeWithTimestamp(@Param(value="nodeId") Long nodeId, 
																 @Param(value="from") Date from, 
																 @Param(value="to") Date to);
}
