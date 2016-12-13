package ba.unsa.etf.bp.dto;

import java.util.Date;

import ba.unsa.etf.bp.model.EncodedMessage;

public class EncodedMessageModel {
	private Long id;
	private Date creationTime;
	
	private Double lat;
	
	private Double lng;
	
	private String nodeId;
	
	private String gatewayIP;

	private String protocol;
	
	private String encodedData;
	
	private Long MessageId;
	
	public EncodedMessageModel(Long id, Date creationTime, Double lat, Double lng, String nodeId, String gatewayIP,
			String protocol, String encodedData, Long messageId) {
		this.id = id;
		this.creationTime = creationTime;
		this.lat = lat;
		this.lng = lng;
		this.nodeId = nodeId;
		this.gatewayIP = gatewayIP;
		this.protocol = protocol;
		this.encodedData = encodedData;
		this.MessageId = messageId;
	}
	
	public EncodedMessageModel(EncodedMessage encodedMessage) {
		this.id = encodedMessage.getId();
		this.creationTime = encodedMessage.getCreationTime();
		this.lat = encodedMessage.getLat();
		this.lng = encodedMessage.getLng();
		this.nodeId = encodedMessage.getNodeId();
		this.gatewayIP = encodedMessage.getGatewayIP();
		this.protocol = encodedMessage.getProtocol();
		this.encodedData = encodedMessage.getEncodedData();
		this.MessageId = encodedMessage.getMessage().getId();
	}
	
	public Date getCreationTime() {
		return creationTime;
	}

	public String getEncodedData() {
		return encodedData;
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

	public Long getMessageId() {
		return MessageId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public void setEncodedData(String encodedData) {
		this.encodedData = encodedData;
	}

	public void setGatewayIP(String gatewayIP) {
		this.gatewayIP = gatewayIP;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public void setMessageId(Long messageId) {
		MessageId = messageId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
}
