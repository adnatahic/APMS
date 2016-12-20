package ba.unsa.etf.bp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	NodeService	_nodeService;
	
	@RequestMapping(value="nodes", method=RequestMethod.GET)
	public List<NodeModel> getNodesInGeoRange(@RequestParam(value="neLat") Double neLat, @RequestParam(value="neLng") Double neLng,
			@RequestParam(value="swLat") Double swLat, @RequestParam(value="swLng") Double swLng) {
		return this._nodeService.getNodesInGeoRange(neLat, neLng, swLat, swLng);
	}
}
