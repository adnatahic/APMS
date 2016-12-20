package ba.unsa.etf.bp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.unsa.etf.bp.dto.NodeModel;
import ba.unsa.etf.bp.model.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {

	@Query("select new ba.unsa.etf.bp.dto.NodeModel(n.id, n.description, em.lat, em.lng, em.creationTime) from Node n inner join n.messages m inner join m.encodedMessage em " + 
			"where em.lat <= :neLat and em.lat >= :swLat and em.lng <= :neLng and em.lng >= :swLng  and em.creationTime = (select max(em1.creationTime) "
			+ " from Node n1 inner join n1.messages m1 inner join m1.encodedMessage em1"
			+ " where n1.id = n.id)"
			+ "order by em.creationTime DESC")
	List<NodeModel> queryByNorthEastAndSouthWestLatLng(@Param("neLat") Double neLat, @Param("neLng") Double neLng, @Param("swLat") Double swLat, @Param("swLng") Double swLng);
}
