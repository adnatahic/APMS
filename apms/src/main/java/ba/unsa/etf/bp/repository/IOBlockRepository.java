package ba.unsa.etf.bp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.unsa.etf.bp.model.IOBlock;

@Repository
public interface IOBlockRepository extends JpaRepository<IOBlock, Long> {

	@Query("select iob from IOBlock iob"
			+ " where iob.node.id = :nodeId "
			+ " order by iob.ordinal")
	List<IOBlock> queryIOBlocksByNodeId(@Param(value="nodeId") Long nodeId);
}
