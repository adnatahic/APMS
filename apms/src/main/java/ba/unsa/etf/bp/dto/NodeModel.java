package ba.unsa.etf.bp.dto;

import java.util.Date;
import java.util.List;

public class NodeModel {
	private Long nodeId;
	private String node;
	private Double lat;
	private Double lng;
	private Date creationTime;
	private List<MeasureModel> measurements;
	public NodeModel() {
		
	}
	public NodeModel(Long nodeId, String node, Double lat, Double lng, Date creationTime,
			List<MeasureModel> measurements) {
		this.nodeId = nodeId;
		this.node = node;
		this.lat = lat;
		this.lng = lng;
		this.creationTime = creationTime;
		this.measurements = measurements;
	}
	
	public NodeModel(Long nodeId, String node, Double lat, Double lng, Date creationTime) {
		this.nodeId = nodeId;
		this.node = node;
		this.lat = lat;
		this.lng = lng;
		this.creationTime = creationTime;
		this.measurements = null;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public Double getLat() {
		return lat;
	}
	public Double getLng() {
		return lng;
	}
	public List<MeasureModel> getMeasurements() {
		return measurements;
	}
	public String getNode() {
		return node;
	}
	public Long getNodeId() {
		return nodeId;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public void setMeasurements(List<MeasureModel> measurements) {
		this.measurements = measurements;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}
}
