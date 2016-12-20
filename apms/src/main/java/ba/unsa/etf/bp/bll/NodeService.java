package ba.unsa.etf.bp.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.unsa.etf.bp.dto.NodeModel;
import ba.unsa.etf.bp.model.EncodedMessage;
import ba.unsa.etf.bp.model.Message;
import ba.unsa.etf.bp.model.Node;
import ba.unsa.etf.bp.repository.EncodedMessageRepository;
import ba.unsa.etf.bp.repository.MessageRepository;
import ba.unsa.etf.bp.repository.NodeRepository;

@Service
public class NodeService {
	@Autowired
	NodeRepository _nodeRepository;
	
	public List<NodeModel> getNodesInGeoRange(Double neLat, Double neLng, Double swLat, Double swLng) {
		if (!(neLat instanceof Double) || neLat > 90.0 || neLat < -90.0)
			throw new IllegalArgumentException("North-east latitude value must be in range [-90, 90]");
		
		if (!(swLat instanceof Double) || swLat > 90.0 || swLat < -90.0)
			throw new IllegalArgumentException("South-west latitude value must be in range [-90, 90]");
		
		if (!(neLng instanceof Double) || neLng > 180.0 || neLng < -180.0)
			throw new IllegalArgumentException("North-east longitude value must be in range [-180, 180]");
	
		if (!(swLng instanceof Double) || swLng > 180.0 || swLng < -180.0)
			throw new IllegalArgumentException("South-west longitude value must be in range [-180, 180]");
		
		List<NodeModel> data = this._nodeRepository.queryByNorthEastAndSouthWestLatLng(neLat, neLng, swLat, swLng);
		
		return data;
	}
}
