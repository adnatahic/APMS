package ba.unsa.etf.bp.dto;

import java.util.Date;
import java.util.List;

public class MessageModel {
	private Long id;
	private Date creationTime;
	private Double lat;
	private Double lng;
	private String gatewayIP;
	private String protocol;

	private List<MeasureModel> measurements;

	public MessageModel() {
		
	}
	public MessageModel(Long id, Date creationTime, Double lat, Double lng, String gatewayIP, String protocol,
			List<MeasureModel> measurements) {
		this.id = id;
		this.creationTime = creationTime;
		this.lat = lat;
		this.lng = lng;
		this.gatewayIP = gatewayIP;
		this.protocol = protocol;
		this.measurements = measurements;
	}
	
	public MessageModel(Long id, Date creationTime, Double lat, Double lng, String gatewayIP, String protocol) {
		this.id = id;
		this.creationTime = creationTime;
		this.lat = lat;
		this.lng = lng;
		this.gatewayIP = gatewayIP;
		this.protocol = protocol;
		this.measurements = null;
	}
	
	public Date getCreationTime() {
		return creationTime;
	}
	public String getGatewayIP() {
		return gatewayIP;
	}
	public Long getId() {
		return id;
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
	public String getProtocol() {
		return protocol;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public void setGatewayIP(String gatewayIP) {
		this.gatewayIP = gatewayIP;
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
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
}
