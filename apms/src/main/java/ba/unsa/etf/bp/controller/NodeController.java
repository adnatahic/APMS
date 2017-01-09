package ba.unsa.etf.bp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.unsa.etf.bp.bll.NodeService;
import ba.unsa.etf.bp.dto.NodeModel;

@RestController
@RequestMapping("api/")
public class NodeController {
	@Autowired
	private NodeService	_nodeService;
	
	@RequestMapping(value="nodes", method=RequestMethod.GET)
	public List<NodeModel> getNodesInGeoRange(@RequestParam Double neLat,
											  @RequestParam Double neLng,
											  @RequestParam Double swLat, 
											  @RequestParam Double swLng, 
											  @RequestParam(required = false) @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") Date from,
											  @RequestParam(required = false) @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") Date to) {
		if (from == null || to == null)
			return this._nodeService.getNodesInGeoRange(neLat, neLng, swLat, swLng);
		else
			return this._nodeService.getNodesInGeoRangeWithTimestamp(neLat, neLng, swLat, swLng, from, to);
	}
}
